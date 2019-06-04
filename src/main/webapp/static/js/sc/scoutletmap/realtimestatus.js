var vm = new Vue({
    el:'#dpLTE',
    data: {
        keyword: null
    },
    methods : {
        load: function (outletid, serialid) {
            var chart = Highcharts.chart({
                chart: {
                    renderTo: 'container',
                    type: 'spline',
                    events: {
                        load: getData()
                    }
                },
                title: {
                    text: '实时数据'
                },
                xAxis: {
                    type: 'datetime',
                    tickPixelInterval: 150
                },
                yAxis: {
                    title: {
                        text: ''
                    }
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.series.name + '</b><br/>' +
                            Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                            Highcharts.numberFormat(this.y, 2);
                    }
                },
                credits:{ // 不显示版权信息
                    enabled:false
                },
                legend: { //显示曲线开关
                    enabled: true
                },
                series: [{
                    name: '电压',
                    data: []
                },{
                    name: '电流',
                    data: []
                },{
                    name: '功率',
                    data: []
                }]
            });

            function activeLastPointToolip(chart) {
                //持续跟踪最新一个点
                //多条曲线共存时不太好用, 需改进
                var points = chart.series[0].points;
                chart.tooltip.refresh(points[points.length -1]);
            }

            function getData() { //从服务器获取数据
                var dataU = [],
                    dataC = [],
                    dataP = [],
                    t,
                    uploaddate;
                $.ajax({
                    type : 'post',
                    url : '../../sc/upload/getRealTimeData?_' + $.now(),
                    data : JSON.stringify({"outletid":outletid, "serialid":serialid}),
                    dataType : 'json',
                    contentType : 'application/json',
                    success : function(e) {
                        if(e.length != 0){
                            var series = chart.series[0],
                                shift = series.data.length > 20; // 当数据点数量超过 20 个，则指定删除第一个点, 数量过多时导致图像跳跃
                            t = e[0].uploaddate.split(/[- :]/);
                            uploaddate = new Date(Date.UTC(t[0], t[1]-1, t[2], t[3], t[4], t[5])).getTime();
                            dataU.push(uploaddate, e[0].votage);
                            dataC.push(uploaddate, e[0].current);
                            dataP.push(uploaddate, e[0].power);
                            chart.series[0].addPoint(dataU, true, shift);
                            chart.series[1].addPoint(dataC, true, shift);
                            chart.series[2].addPoint(dataP, true, shift);

                            setTimeout(getData,3000);
                        }else{
                            dialogMsg("检测到该端口停止充电", 'info');
                            dialogClose();
                        }
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown) {
                        dialogMsg(errorThrown, 'error');
                        dialogClose();
                    },
                    cache: false
                });
            }
        }
    }
});
var map = new AMap.Map('container', {
    resizeEnable: true,
    center:[120.038930, 30.224656],
    zoom:14
});
AMap.plugin('AMap.ToolBar',function(){
    var toolbar = new AMap.ToolBar();
    map.addControl(toolbar)
});
map.on('complete', function() {
    $.ajax({
        type: 'get',
        async: false,
        contentType: 'application/json',
        url: '../../sc/outlet/listOutlets?_' + $.now(),
        dataType: 'json',
        data: null,
        success: function (data) {
            map.clearMap();//清除标记
            data.forEach(function (e) {
                var color = 'black';
                if(e.chargingPortNum > 0){
                    color = 'blue';
                }else{
                    color = 'gray';
                }
                AMapUI.loadUI(['overlay/SimpleMarker'], function(SimpleMarker) {
                    var marker = new SimpleMarker({
                        iconLabel: e.chargingPortNum,
                        iconStyle: color,
                        map: map,
                        position: [e.longitude, e.latitude],
                        outletid: e.outletid,
                    });
                    marker.content = [e.outletid, e.outletname];
                    //marker 点击时打开
                    // marker.on('click', vm.info(marker));
                    AMap.event.addListener(marker, 'click', function () {
                        vm.info(marker)
                    });
                });
            });
            map.setFitView();
        },
    });
});

var vm = new Vue({
    el:'#dpLTE',
    data: {
        keyword: null,
        outlet: null,
        markers: [],
    },
    methods : {
        info: function (marker) {
            if(marker.He.iconLabel === 0){
                dialogMsg("该设备暂没有端口正在充电", 'info');
            }else{
                dialogOpen({
                    title: marker.content[1]+' 正在充电的端口',
                    url: 'sc/scoutletmap/info.html?_' + $.now(),
                    width: '800px',
                    height: '500px',
                    btn: [],
                    success: function(iframeId){
                        top.frames[iframeId].vm.keyword = marker.content[0];
                        top.frames[iframeId].vm.load();
                    },
                    yes: function(iframeId){
                        dialogClose();
                    }
                });
            }
        },
    }
});
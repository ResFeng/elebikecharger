/**
 * 端口-js
 */
$(function () {
    initialPage();
    getGrid();
});

function initialPage() {
    $(window).resize(function() {
        $('#dataGrid').bootstrapTable('resetView', {height: $(window).height()});
    });
}

function getGrid() {
    $('#dataGrid').bootstrapTableEx({
        url: '../../sc/serial/listByOutletId?_' + $.now(),
        height: $(window).height(),
        queryParams: function(params){
            params.name = vm.keyword;
            return params;
        },
        columns: [
            // {checkbox: false},
            {field : "outletid", title : "智能充电桩", width : "100px"},
            {field : "serialid", title : "端口id", width : "100px"},
            {field : "status", title : "状态", width : "100px"},
            {field : "qrcodeUrl", title : "qrcode", visible : false},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '<a href="javascript:;" class="btn btn-default" onclick="vm.qrcode(\''+row.outletid+'\', \''+row.serialid+'\')"><i class="fa fa-qrcode"></i>&nbsp;二维码</a>';
                    // var _html = '<img src="\''+row.qrcodeUrl+'\'" height="42px" width="42px" onclick="vm.qrcode(\''+row.outletid+'\', \''+row.serialid+'\')>';
                    if(row.status == 1){
                        _html += '<a href="javascript:;" class="btn btn-default" onclick="vm.realTimeLine(\''+row.outletid+'\', \''+row.serialid+'\')"><i class="fa fa-line-chart"></i>&nbsp;实时曲线</a>';
                    }
                    return _html;
                }
            }
        ]
    })
}

var vm = new Vue({
    el:'#dpLTE',
    data: {
        keyword: null
    },
    methods : {
        load: function() {
            setTimeout(function () {
                $('#dataGrid').bootstrapTable('refresh');
            }, 200);
        },
        qrcode: function (outletid, serialid) {
            dialogOpen({
                id: 'qrcode',
                title: outletid+' '+serialid+' 二维码',
                url: 'sc/scoutlet/qrcode.html?_' + $.now(),
                width: '500px',
                height: '500px',
                btn: false,
                success: function(iframeId){
                    top.frames[iframeId].vm.outletid = outletid;
                    top.frames[iframeId].vm.serialid = serialid;
                    top.frames[iframeId].vm.load();
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                },
            });
        },
        realTimeLine: function (outletid, serialid) {
            dialogOpen({
                id: 'realTimeData',
                title: outletid+"   #"+ serialid +' 端口实时曲线',
                url: 'sc/scoutletmap/realtimestatus.html?_' + $.now(),
                scroll : false,
                width: "1030px",
                height: "600px",
                btn: false,
                success: function (iframeId) {
                    top.frames[iframeId].vm.load(outletid, serialid);
                }
            })
        }
    }
});
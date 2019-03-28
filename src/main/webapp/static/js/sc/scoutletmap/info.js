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
        url: '../../sc/serial/listChargingSerial?_' + $.now(),
        height: $(window).height(),
        queryParams: function(params){
            params.name = vm.keyword;
            return params;
        },
        columns: [
            // {checkbox: false},
            {field : "outletid", title : "智能充电桩", width : "250px"},
            {field : "serialid", title : "端口id", width : "250px"},
            {title : "实时曲线", formatter : function(value, row, index) {
                    var _html = '<a href="javascript:;" class="btn btn-default" onclick="vm.realTimeLine(\''+row.outletid+'\', \''+row.serialid+'\'"><i class="fa fa-search"></i>&nbsp;实时曲线</a>';
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
        realTimeLine: function (outletid, serialid) {
            console.log("here is outletid "+outletid);
            console.log("here is serialid "+serialid);
        }
    }
})
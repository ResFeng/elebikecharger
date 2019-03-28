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
            {title : "二维码", formatter : function(value, row, index) {
                    var _html = '<a href="javascript:;" onclick="vm.qrcode(\''+row.outletid+'\', \''+row.serialid+'\')" title="二维码">二维码</a>';
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
            console.log("here is outletid "+outletid);
            console.log("here is serialid "+serialid);
        }
    }
})
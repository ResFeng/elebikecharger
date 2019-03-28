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
        url: '../../sc/chargeprofit/list?_' + $.now(),
        height: $(window).height(),
        queryParams: function(params){
            params.providerId = vm.providerId;
            params.chargeDate = vm.chargeDate;
            return params;
        },
        columns: [
            {field : "outletName", title : "设备名", width : "300px"},
            {field : "chargedate", title : "日期", visible: false, width : "100px"},
            {field : "outletid", title : "", visible:false, width : "100px"},
            {field : "providerId", title : "", visible:false, width : "100px"},
            {field : "profits", title : "收入", width : "100px"},
            {field : "chargenum", title : "充电次数", width : "100px"},
            {field : "powerconsumption", title : "用电量", width : "100px"},
            {field : "distprofits", title : "利润", width : "100px"},
        ]
    })
}

var vm = new Vue({
    el:'#dpLTE',
    data: {
        providerId: null,
        chargeDate: null,
    },
    methods : {
        load: function() {
            setTimeout(function () {
                $('#dataGrid').bootstrapTable('refresh');
            }, 200);
        },
        acceptClick: function() {
            dialogClose();
        }
    }
})
/**
 * js
 */

$(function () {
    initialPage();
    getGrid();
});

function initialPage() {
    vm.dateRangeSelect(1);
    $(window).resize(function() {
        $('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
    });
    //日期选择
    laydate.render({
        elem: '#dateRange',
        range: true,
        theme: '#3C8DBC',
        eventElem: '#dateRange',
        trigger: 'click',
        done: function(value, date, endDate){
            vm.dateRangeSelect(0);
            vm.dateRange = value;
            vm.startDate = formatDate(date.year + '-' + date.month + '-' + date.date, 'yyyy-MM-dd');
            vm.endDate = formatDate(endDate.year + '-' + endDate.month + '-' + endDate.date, 'yyyy-MM-dd');
        }
    });
    vm.getProviderList();
}

function getGrid() {
    $('#dataGrid').bootstrapTable({
        url: '../../sc/charge/getSerialReport?_' + $.now(),
        dataField: "total",//服务端返回数据键值 就是说记录放的键值是rows，分页时使用总记录数的键值为total
        height: $(window).height()-56,//高度调整
        pagination: false,
        sidePagination: "client",//服务端分页
        contentType: "application/json",//请求数据内容格式 默认是 application/json 自己根据格式自行服务端处理
        dataType: "json",//期待返回数据类型
        method: "post",//请求方式
        searchAlign: "left",//查询框对齐方式
        queryParamsType: "limit",//查询参数组织方式
        queryParams: function(params){
                params.providerId = vm.providerId;
                params.startDate = vm.startDate;
                params.endDate = vm.endDate;
                params.name = vm.keyword;
                return params;
            },
        searchOnEnterKey: false,//回车搜索
        // showRefresh: true,//刷新按钮
        // showColumns: true,//列选择按钮
        // buttonsAlign: "left",//按钮对齐方式
        // toolbar: "#toolbar",//指定工具栏
        // toolbarAlign: "right",//工具栏对齐方式
        columns: [
            {field : "outletid", title : "设备号", width : "100px"},
            {field : "outletName", title : "设备名称", width : "200px"},
            {field : "serialNum", title : "端口数", width : "50px"},
            {field : "serialid", title : "端口号", width : "50px"},
            {field : "chargetime", title : "充电时间", width : "50px"},
            {field : "chargeNum", title : "充电次数", width : "50px"},
            {field : "payment", title : "收入金额", width : "100px"}
        ],
        locale: "zh-CN", //中文支持
        onLoadSuccess: function () {
            var data = $('#dataGrid').bootstrapTable('getData', true);
            mergeCells(data, "outletid", 1, $('#dataGrid'));
            mergeCells(data, "outletName", 2, $('#dataGrid'));
        }
    });
    // $('#dataGrid').bootstrapTableEx({
    //     url: '../../sc/charge/getSerialReport?_' + $.now(),
    //     height: $(window).height()-56,
    //     queryParams: function(params){
    //         params.providerId = vm.providerId;
    //         params.startDate = vm.startDate;
    //         params.endDate = vm.endDate;
    //         params.name = vm.keyword;
    //         return params;
    //     },
    //     columns: [
    //         {field : "outletid", title : "设备号", width : "100px"},
    //         {field : "outletName", title : "设备名称", width : "200px"},
    //         {field : "serialNum", title : "端口数", width : "50px"},
    //         {field : "serialid", title : "端口号", width : "50px"},
    //         {field : "chargetime", title : "充电时间", width : "50px"},
    //         {field : "chargeNum", title : "充电次数", width : "50px"},
    //         {field : "payment", title : "收入金额", width : "100px"}
    //     ],
    //     onLoadSuccess: function () {
    //         var data = $('#dataGrid').bootstrapTable('getData', true);
    //         mergeCells(data, "outletid", 1, $('#dataGrid'));
    //         mergeCells(data, "outletName", 2, $('#dataGrid'));
    //     }
    // })
}

var vm = new Vue({
    el:'#dpLTE',
    data: {
        keyword: null,
        startDate : null,
        endDate : null,
        dateRangeText : '时间范围',
        dateRange : null,
        providerId: null
    },
    methods : {
        load: function() {
            vm.providerId = $('.provider').val();
            if(vm.providerId != null){
                $('#dataGrid').bootstrapTable('refresh');
            }
        },
        getProviderList: function(){
            $.ajax({
                type:"POST",	//post request
                url:'../../sc/provider/listAll?_' + $.now(),
                dataType:"json",
                error:function () {
                },
                success:function(data){
                    var optionString = "";
                    for(var i = 0; i<data.length; i++){
                        optionString += "<option grade=\""+data[i].providerid+"\" value=\""+data[i].providerid+"\"";
                        optionString += ">"+data[i].providername+"</option>";
                    }
                    $('.provider').append(optionString);
                    if(data.length == 1){
                        $('.provider').attr('value', data[0].providerid);
                        vm.providerId = data[0].providerid;
                    }
                }
            });
        },
        dateRangeSelect : function(count) {
            if(count==1){
                vm.dateRangeText = '最近一天';
                vm.startDate = countDay(-1);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else if(count ==7){
                vm.dateRangeText = '最近一周';
                vm.startDate = countDay(-7);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else if(count ==30){
                vm.dateRangeText = '最近一月';
                vm.startDate = countDay(-30);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else{
                vm.dateRangeText = '时间范围';
                vm.startDate = '';
                vm.endDate = '';
                vm.dateRange = '';
            }
        },
        detail: function(chargedate, providerId, providerName) {
            dialogOpen({
                title: providerName + " " + chargedate + ' 收益详细',
                url: 'sc/scchargeprofit/detail.html?_' + $.now(),
                width: '800px',
                height: '500px',
                success: function(iframeId){
                    top.frames[iframeId].vm.chargeDate = chargedate;
                    top.frames[iframeId].vm.providerId = providerId;
                    top.frames[iframeId].vm.load();
                },
                yes : function(iframeId) {
                    dialogClose();
                },
            });
        },
    }
});

function mergeCells(data,fieldName,colspan,target){
    //声明一个map计算相同属性值在data对象出现的次数和
    var sortMap = {};
    for(var i = 0 ; i < data.length ; i++){
        for(var prop in data[i]){
            if(prop == fieldName){
                var key = data[i][prop]
                if(sortMap.hasOwnProperty(key)){
                    sortMap[key] = sortMap[key] * 1 + 1;
                } else {
                    sortMap[key] = 1;
                }
                break;
            }
        }
    }
    for(var prop in sortMap){
        console.log(prop,sortMap[prop])
    }
    var index = 0;
    for(var prop in sortMap){
        var count = sortMap[prop] * 1;
        $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});
        index += count;
    }
}
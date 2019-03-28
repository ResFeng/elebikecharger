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
    $('#dataGrid').bootstrapTableEx({
        url: '../../sc/chargeprofit/getProfitReport?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.providerId = vm.providerId;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            params.name = vm.keyword;
            return params;
        },
        columns: [
            {field : "outletid", title : "设备号", width : "200px"},
            {field : "outletName", title : "设备名称", width : "200px"},
            {field : "serialNum", title : "端口数", width : "100px"},
            {field : "chargeTime", title : "充电时间", width : "100px"},
            {field : "chargenum", title : "充电次数", width : "100px"},
            {field : "profits", title : "收入金额", width : "100px"}
        ]
    })
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
})
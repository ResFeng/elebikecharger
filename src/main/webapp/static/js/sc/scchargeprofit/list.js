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
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sc/chargeprofit/getProfit?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "providerName", title : "运营商", width : "300px"},
            {field : "chargedate", title : "日期", width : "100px"},
            {field : "outletid", title : "", visible:false, width : "100px"},
            {field : "providerId", title : "", visible:false, width : "100px"},
            {field : "profits", title : "收入", width : "100px"},
            {field : "chargenum", title : "充电次数", width : "100px"},
            {field : "powerconsumption", title : "用电量", width : "100px"},
            {field : "distprofits", title : "利润", width : "100px"},
            {title : "查看详细", formatter : function(value, row, index) {
                    var _html = '<a href="javascript:;" class="btn btn-default" onclick="vm.detail(\''+row.chargedate+'\', \''+row.providerId+'\', \''+row.providerName+'\')"><i class="fa fa-search"></i>&nbsp;收益详细</a>';
                    return _html;
                }
            }
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
        dateRange : null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
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
                btn: [],
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
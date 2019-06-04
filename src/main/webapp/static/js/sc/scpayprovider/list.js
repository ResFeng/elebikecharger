/**
 * js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
	var date = new Date();//月的开始时间
    var TodayMonth = date.getFullYear()+"-"+(date.getMonth()+1);
    $('#monthStart').datetimepicker({
        language:  'zh-CN',
        todayBtn:  false,
        autoclose: true,
        startView: 3,//默认视图为年视图
        minView: 3,
        format: 'yyyy-mm',
        forceParse: true,
        endDate:TodayMonth
    }).on("changeDate",function(e){
        $('#monthEnd').datetimepicker("setStartDate",e.date);//根据前端选择的结束时间设置插件可选择的开始时间
        vm.startDate = e.date;
    }).val(TodayMonth);

//月的结束时间
    $('#monthEnd').datetimepicker({
        language:  'zh-CN',
        todayBtn:  false,
        autoclose: true,
        startView: 3,
        minView: 3,
        format: 'yyyy-mm',
        forceParse: true,
        endDate:TodayMonth
    }).on("changeDate",function(e){
        $('#monthStart').datetimepicker("setEndDate",e.date);//根据前端选择的开始时间设置插件可选择的结束时间
        vm.endDate = e.date;
    }).val(TodayMonth);

    vm.startDate = TodayMonth;
    vm.endDate = TodayMonth;
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sc/chargeprofit/listMonthProfit?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			params.startDate = vm.startDate;
			params.endDate = vm.endDate;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "providerId", title : "", visible:false, width : "100px"},
            {field : "providerName", title : "运营商", width : "300px"},
            {field : "chargeMonth", title : "月份", width : "100px"},
            {field : "profits", title : "收入", width : "100px"},
            {field : "distprofits", title : "利润", width : "100px"},
            {field : "payId", title : "支付编号", width : "100px", formatter : function(value, row, index) {
                    if(row.payId != null){
                        return row.payId;
                    }else if(row.payId == null){
                        return '未支付';
                    }else{
                        return '未知';
                    }
            }},
            {title : "操作", formatter : function(value, row, index) {
                var _html = '';
                if(row.payId != null){
                    _html += '<a type="button" id="printCredential" onclick="vm.print(\''+row.payId+'\', \''+row.providerName+'\')" class="btnPrint btn btn-default" href="../scprint/printCredential.html"><i class="fa fa-print"></i>&nbsp;打印凭据</span></a>' +
                        '&nbsp&nbsp<a type="button" id="printDetail" onclick="vm.print(\''+row.payId+'\', \''+row.providerName+'\', \''+row.providerId+'\', \''+row.chargeMonth+'\')" class="btnPrint btn btn-default" href="../scprint/printDetail.html"><i class="fa fa-print"></i>&nbsp;打印详细</a>'
                }else if(row.payId == null){
                    _html = '<a href="javascript:;" class="btn btn-default" onclick="vm.pay(\''+row.providerId+'\', \''+row.providerName+'\', \''+row.chargeMonth+'\', \''+row.profits+'\')"><i class="fa fa-search"></i>&nbsp;转    账</a>';
                }
                    return _html;
                }
            }
		],
        onLoadSuccess: function () {
            $(".btnPrint").printPage();
        }
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
        keyword: null,
        startDate : null,
        endDate : null,
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
        print: function (payId, providerName, providerId, chargeMonth) {
		    var info = {'payId':payId, 'providerName':providerName, 'providerId': providerId, 'payMonth': chargeMonth};
		    localStorage.setItem('info', JSON.stringify(info));
        },
        pay: function (providerId, providerName, chargeMonth, profits) {
            dialogOpen({
                title: '转账: '+providerName+' '+chargeMonth,
                url: 'sc/scpayprovider/pay.html?_' + $.now(),
                width: '800px',
                height: '430px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scPay.providerId = providerId;
                    top.frames[iframeId].vm.scPay.payMonth = chargeMonth;
                    top.frames[iframeId].vm.scPay.amount = profits;
                    top.frames[iframeId].vm.load();
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                },
            });
        }
	}
});
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
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sc/providerbalance/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "balanceid", title : "", width : "100px"},
            {field : "providerid", title : "", width : "100px"},
            {field : "balancedate", title : "", width : "100px"},
            {field : "operator", title : "", width : "100px"},
            {field : "amount", title : "", width : "100px"},
            {field : "paymenttype", title : "", width : "100px"},
            {field : "openid", title : "", width : "100px"},
            {field : "accountname", title : "", width : "100px"},
            {field : "paymentamount", title : "", width : "100px"},
            {field : "paymentratio", title : "", width : "100px"},
            {field : "paymentstatus", title : "", width : "100px"},
            {field : "paymentid", title : "", width : "100px"},
            {field : "paymentdate", title : "", width : "100px"},
            {field : "remark", title : "", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:providerbalance:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.balanceid+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:providerbalance:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.balanceid+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增',
				url: 'sc/scproviderbalance/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(balanceid) {
            dialogOpen({
                title: '编辑',
                url: 'sc/scproviderbalance/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scProviderbalance.balanceid = balanceid;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, balanceid) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.balanceid;
                });
            } else {
                ids.push(balanceid);
            }
            $.RemoveForm({
                url: '../../sc/providerbalance/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})
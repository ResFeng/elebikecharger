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
		url: '../../sc/charge/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "userid", title : "智能充电桩", width : "100px"},
            {field : "outletid", title : "", width : "100px"},
            {field : "serialid", title : "", width : "100px"},
            {field : "chargedate", title : "", width : "100px"},
            {field : "mode", title : "", width : "100px"},
            {field : "currentstatus", title : "", width : "100px"},
            {field : "settingtime", title : "", width : "100px"},
            {field : "chargetime", title : "", width : "100px"},
            {field : "remaintime", title : "", width : "100px"},
            {field : "realcost", title : "", width : "100px"},
            {field : "payment", title : "", width : "100px"},
            {field : "stoptype", title : "", width : "100px"},
            {field : "enddate", title : "", width : "100px"},
            {field : "status", title : "", width : "100px"},
            {field : "havelooked", title : "", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:charge:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.chargeid+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:charge:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.chargeid+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
				url: 'sc/sccharge/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(chargeid) {
            dialogOpen({
                title: '编辑',
                url: 'sc/sccharge/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scCharge.chargeid = chargeid;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, chargeid) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.chargeid;
                });
            } else {
                ids.push(chargeid);
            }
            $.RemoveForm({
                url: '../../sc/charge/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})
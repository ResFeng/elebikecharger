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
		url: '../../sc/provider/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "providerid", title : "provider", width : "100px"},
            {field : "providertype", title : "运营商类型", width : "100px"},
            {field : "providername", title : "运营商名称", width : "100px"},
            {field : "joindate", title : "加入时间", width : "100px"},
            {field : "address", title : "", visible: false, width : "100px"},
            {field : "province", title : "", visible: false, width : "100px"},
            {field : "city", title : "", visible: false, width : "100px"},
            {field : "area", title : "", visible: false, width : "100px"},
            {field : "legal", title : "", visible: false, width : "100px"},
            {field : "telephone", title : "手机号", width : "100px"},
            {field : "wechatid", title : "微信号", width : "100px"},
            {field : "openid", title : "openId", width : "100px"},
            {field : "citizenid", title : "身份证", width : "100px"},
            {field : "email", title : "邮箱", width : "100px"},
            {field : "bank", title : "银行", width : "100px"},
            {field : "account", title : "银行账户", width : "100px"},
            {field : "accountname", title : "姓名", width : "100px"},
            {field : "enable", title : "启用", width : "100px"},
            {field : "remark", title : "备注", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:provider:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:provider:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
				url: 'sc/scprovider/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑',
                url: 'sc/scprovider/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scProvider.id = id;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, id) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.id;
                });
            } else {
                ids.push(id);
            }
            $.RemoveForm({
                url: '../../sc/provider/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})
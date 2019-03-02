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
		url: '../../sc/upload/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "outletid", title : "智能充电桩", width : "100px"},
            {field : "serialid", title : "", width : "100px"},
            {field : "chargeid", title : "", width : "100px"},
            {field : "uploaddate", title : "", width : "100px"},
            {field : "votage", title : "", width : "100px"},
            {field : "current", title : "", width : "100px"},
            {field : "power", title : "", width : "100px"},
            {field : "chargetime", title : "", width : "100px"},
            {field : "remaintime", title : "", width : "100px"},
            {field : "pricemode", title : "", width : "100px"},
            {field : "realcost", title : "", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:upload:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.uploadid+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:upload:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.uploadid+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
				url: 'sc/scupload/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(uploadid) {
            dialogOpen({
                title: '编辑',
                url: 'sc/scupload/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scUpload.uploadid = uploadid;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, uploadid) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.uploadid;
                });
            } else {
                ids.push(uploadid);
            }
            $.RemoveForm({
                url: '../../sc/upload/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})
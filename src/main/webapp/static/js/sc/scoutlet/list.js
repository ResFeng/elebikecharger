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
		url: '../../sc/outlet/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "outletid", title : "设备号", width : "100px"},
            {field : "providerid", title : "", visible: false, width : "100px"},
            {field : "outletname", title : "设备名", width : "150px"},
            {field : "typeid", title : "设备类型", width : "70px"},
            {field : "price", title : "", visible: false, width : "100px"},
            {field : "province", title : "", visible: false, width : "100px"},
            {field : "city", title : "", visible: false, width : "100px"},
            {field : "areaid", title : "", visible: false, width : "100px"},
            {field : "serverid", title : "", visible: false, width : "100px"},
            {field : "installationsite", title : "安装地址", width : "300px"},
            {field : "longitude", title : "", visible: false, width : "100px"},
            {field : "latitude", title : "", visible: false, width : "100px"},
            {field : "serialnumber", title : "", visible: false, width : "100px"},
            {field : "pricemode", title : "", visible: false, width : "100px"},
            {field : "describe", title : "", visible: false, width : "100px"},
            {field : "ip", title : "", visible: false, width : "100px"},
            {field : "serialnum", title : "", visible: false, width : "100px"},
            {field : "session", title : "", visible: false, width : "100px"},
            {field : "appkey", title : "", visible: false, width : "100px"},
            {field : "isonline", title : "是否在线", width : "100px", formatter: function(value, row, index){
                    if(row.isonline === 0){
                        return '<i class="fa fa-toggle-off"></i>';
                    }
                    if(row.isonline === 1){
                        return '<i class="fa fa-toggle-on"></i>';
                    }
                }},
            {field : "signalquality", title : "", visible: false, width : "100px"},
            {field : "enable", title : "是否启用", width : "100px", formatter: function(value, row, index){

                    if (row.enable === 1) {
                        if (hasPermission('sc:outlet:edit')) {
                            return '<input type="checkbox" class="js-switch" data-id="' + row.outletid + '" checked>';
                        } else {
                            return '<i class="fa fa-toggle-on"></i>';
                        }
                    }

                    if (row.enable === 0) {
                        if (hasPermission('sc:outlet:edit')) {
                            return '<input type="checkbox" class="js-switch" data-id="' + row.outletid + '">';
                        } else {
                            return '<i class="fa fa-toggle-off"></i>';
                        }
                    }
                }},
            {field : "version", title : "固件版本", width : "100px"},
            {field : "iccid", title : "", visible: false, width : "100px"},
            {field : "enabledate", title : "", visible: false, width : "100px"},
            {field : "recoverdate", title : "", visible: false, width : "100px"},
            {field : "electricityprice", title : "", visible: false, width : "100px"},
            {field : "distributionmode", title : "", visible: false, width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:outlet:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.outletid+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:outlet:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.outletid+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
                    }
                    return _html;
                }
            }
		],

        onPostBody: function () {
            switchUtils.init({
                selector: '.js-switch',
                single: false,
                change: function (switchContainer) {
                    var url = '../../sc/outlet/disable?_' + $.now();
                    if (switchUtils.checked(switchContainer)) {
                        url = '../../sc/outlet/enable?_' + $.now();
                    }
                    $.AjaxForm({
                        url: url,
                        param: switchUtils.data(switchContainer, "id"),
                        success: function (data) {
                            vm.load();
                        },
                        false: function (data) {
                            console.log(data)
                        }
                    });

                }
            });
        },
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
				url: 'sc/scoutlet/add.html?_' + $.now(),
				width: '600px',
				height: '700px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(outletid) {
            dialogOpen({
                title: '编辑',
                url: 'sc/scoutlet/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scOutlet.outletid = outletid;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, outletid) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.outletid;
                });
            } else {
                ids.push(outletid);
            }
            $.RemoveForm({
                url: '../../sc/outlet/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})
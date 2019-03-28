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
        url: '../../sc/chargeprofit/list?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            return params;
        },
        columns: [
            {checkbox: true},
            {field : "chargedate", title : "", width : "100px"},
            {field : "outletid", title : "", width : "100px"},
            {field : "profits", title : "", width : "100px"},
            {field : "chargenum", title : "", width : "100px"},
            {field : "powerconsumption", title : "", width : "100px"},
            {field : "distprofits", title : "", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:chargeprofit:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:chargeprofit:remove')) {
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
                url: 'sc/scchargeprofit/add.html?_' + $.now(),
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
                url: 'sc/scchargeprofit/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scChargeprofit.id = id;
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
                url: '../../sc/chargeprofit/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
    }
})
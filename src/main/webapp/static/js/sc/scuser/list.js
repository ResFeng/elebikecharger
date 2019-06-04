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
        url: '../../sc/user/list?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            return params;
        },
        columns: [
            {checkbox: true},
            // {field : "userid", title : "id", width : "100px"},
            {field : "username", title : "用户名", width : "100px"},
            {field : "mobile", title : "手机号", width : "150px"},
            {field : "account", title : "账户余额", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sc:user:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.userid+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sc:user:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.userid+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
        // save: function() {
        //     dialogOpen({
        //         title: '新增',
        //         url: 'sc/scuser/add.html?_' + $.now(),
        //         width: '420px',
        //         height: '350px',
        //         yes : function(iframeId) {
        //             top.frames[iframeId].vm.acceptClick();
        //         },
        //     });
        // },
        edit: function(userid) {
            dialogOpen({
                title: '编辑',
                url: 'sc/scuser/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.scUser.userid = userid;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, userid) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.userid;
                });
            } else {
                ids.push(userid);
            }
            $.RemoveForm({
                url: '../../sc/user/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
    }
})
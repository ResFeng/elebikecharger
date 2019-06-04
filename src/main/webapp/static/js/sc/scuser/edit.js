/**
 * 编辑-js
 */
var vm = new Vue({
    el:'#dpLTE',
    data: {
        scUser: {
            userid: 0
        }
    },
    methods : {
        setForm: function() {
            $.SetForm({
                url: '../../sc/user/info?_' + $.now(),
                param: vm.scUser.userid,
                success: function(data) {
                    vm.scUser = data;
                }
            });
        },
        acceptClick: function() {
            if (!$('#form').Validform()) {
                return false;
            }
            $.ConfirmForm({
                url: '../../sc/user/update?_' + $.now(),
                param: vm.scUser,
                success: function(data) {
                    $.currentIframe().vm.load();
                }
            });
        }
    }
})
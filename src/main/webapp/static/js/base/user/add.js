/**
 * 新增-用户管理js
 */
$(function(){
    vm.getRoleList();
    vm.getProviderList();
})
var vm = new Vue({
	el:'#dpLTE',
	data: {
		roleList:{},
		user:{
			orgId: 0,
			orgName: null,
			status: 1,
			roleIdList: null,
			providerId: null,
            email: null,
            mobile: null,
		}
	},
	methods : {
        getRoleList: function(){
            $('.roleSelect').selectBindEx({
                url: '../../sys/role/select?_' + $.now(),
                placeholder: '请选择角色',
                value: 'roleId',
                text: 'roleName',
				change: function (data) {
                	var mobile = vm.user.mobile;
                	var email = vm.user.email;
                    if(data === '1'){
                        $('.provider').attr("checkexpession", "");
                        $('.provider').val(null).trigger('change');
                        $('.provider').attr('disabled', 'disabled');
                    }else{
                        $('.provider').attr("checkexpession", "NotNull");
                        $('.provider').removeAttr('disabled');
                    }
                    vm.user.email = email;
                    vm.user.mobile = mobile;
                }
            });
        },
		getProviderList: function(){
            $('.provider').selectBindEx({
                url: '../../sc/provider/listAll?_' + $.now(),
                placeholder: '请选择运营商',
                value: 'providerid',
                text: 'providername',
                change: function (providerid) {
                    if(providerid != null){
                        $.SetForm({
                            url: '../../sc/provider/info?_' + $.now(),
                            param: providerid,
                            success: function (data) {
                                vm.user.providerId = providerid;
                                vm.user.email = data.email;
                                vm.user.mobile = data.telephone;
                                $('.mobile').val(data.telephone);
                                $('.email').val(data.email);
                            }
                        });
                    }else{
                        vm.user.email = null;
                        vm.user.mobile = null;
                        $('.mobile').val(null);
                        $('.email').val(null);
                    }
                }
            });
		},
		orgTree: function() {
			dialogOpen({
				id: 'layerOrgTree',
				title: '选择机构',
		        url: 'base/user/org.html?_' + $.now(),
		        scroll : true,
		        width: "300px",
		        height: "450px",
		        yes : function(iframeId) {
		        	top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
		acceptClick: function() {
            if (!$('#form').Validform()) {
                return false;
            }
            vm.user.roleIdList = $('.roleSelect').val();
		    $.SaveForm({
		    	url: '../../sys/user/save?_' + $.now(),
		    	param: vm.user,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
});

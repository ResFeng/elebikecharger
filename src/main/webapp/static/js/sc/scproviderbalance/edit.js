/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scProviderbalance: {
			balanceid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/providerbalance/info?_' + $.now(),
		    	param: vm.scProviderbalance.balanceid,
		    	success: function(data) {
		    		vm.scProviderbalance = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/providerbalance/update?_' + $.now(),
		    	param: vm.scProviderbalance,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
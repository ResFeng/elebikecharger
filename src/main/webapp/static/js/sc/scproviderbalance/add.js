/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scProviderbalance: {
			balanceid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/providerbalance/save?_' + $.now(),
		    	param: vm.scProviderbalance,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

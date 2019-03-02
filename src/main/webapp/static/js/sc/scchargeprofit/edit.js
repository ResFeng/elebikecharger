/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scChargeprofit: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/chargeprofit/info?_' + $.now(),
		    	param: vm.scChargeprofit.id,
		    	success: function(data) {
		    		vm.scChargeprofit = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/chargeprofit/update?_' + $.now(),
		    	param: vm.scChargeprofit,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
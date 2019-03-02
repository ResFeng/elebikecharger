/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scChargeprofit: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/chargeprofit/save?_' + $.now(),
		    	param: vm.scChargeprofit,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

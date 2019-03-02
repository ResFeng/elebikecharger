/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scCharge: {
			chargeid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/charge/save?_' + $.now(),
		    	param: vm.scCharge,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

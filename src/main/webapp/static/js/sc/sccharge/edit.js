/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scCharge: {
			chargeid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/charge/info?_' + $.now(),
		    	param: vm.scCharge.chargeid,
		    	success: function(data) {
		    		vm.scCharge = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/charge/update?_' + $.now(),
		    	param: vm.scCharge,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
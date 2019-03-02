/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scRecharge: {
			rechargeid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/recharge/info?_' + $.now(),
		    	param: vm.scRecharge.rechargeid,
		    	success: function(data) {
		    		vm.scRecharge = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/recharge/update?_' + $.now(),
		    	param: vm.scRecharge,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
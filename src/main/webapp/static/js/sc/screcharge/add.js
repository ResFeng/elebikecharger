/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scRecharge: {
			rechargeid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/recharge/save?_' + $.now(),
		    	param: vm.scRecharge,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

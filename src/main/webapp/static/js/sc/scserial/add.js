/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scSerial: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/serial/save?_' + $.now(),
		    	param: vm.scSerial,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

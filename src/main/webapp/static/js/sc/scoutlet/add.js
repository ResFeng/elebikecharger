/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scOutlet: {
			outletid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/outlet/save?_' + $.now(),
		    	param: vm.scOutlet,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

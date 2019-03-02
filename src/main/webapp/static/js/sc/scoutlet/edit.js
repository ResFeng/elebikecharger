/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scOutlet: {
			outletid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/outlet/info?_' + $.now(),
		    	param: vm.scOutlet.outletid,
		    	success: function(data) {
		    		vm.scOutlet = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/outlet/update?_' + $.now(),
		    	param: vm.scOutlet,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
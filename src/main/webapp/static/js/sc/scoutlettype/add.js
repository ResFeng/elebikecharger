/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scOutlettype: {
			typeid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/outlettype/save?_' + $.now(),
		    	param: vm.scOutlettype,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

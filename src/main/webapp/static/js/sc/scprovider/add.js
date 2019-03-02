/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scProvider: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/provider/save?_' + $.now(),
		    	param: vm.scProvider,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

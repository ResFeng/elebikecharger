/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scUpload: {
			uploadid: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/upload/save?_' + $.now(),
		    	param: vm.scUpload,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

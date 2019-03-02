/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scUpload: {
			uploadid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/upload/info?_' + $.now(),
		    	param: vm.scUpload.uploadid,
		    	success: function(data) {
		    		vm.scUpload = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/upload/update?_' + $.now(),
		    	param: vm.scUpload,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
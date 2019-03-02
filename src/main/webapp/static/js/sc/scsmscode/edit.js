/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scSmscode: {
			phonenum: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/smscode/info?_' + $.now(),
		    	param: vm.scSmscode.phonenum,
		    	success: function(data) {
		    		vm.scSmscode = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/smscode/update?_' + $.now(),
		    	param: vm.scSmscode,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
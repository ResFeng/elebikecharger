/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scSmscode: {
			phonenum: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/smscode/save?_' + $.now(),
		    	param: vm.scSmscode,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})

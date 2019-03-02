/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scProvider: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/provider/info?_' + $.now(),
		    	param: vm.scProvider.id,
		    	success: function(data) {
		    		vm.scProvider = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/provider/update?_' + $.now(),
		    	param: vm.scProvider,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scOutlettype: {
			typeid: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/outlettype/info?_' + $.now(),
		    	param: vm.scOutlettype.typeid,
		    	success: function(data) {
		    		vm.scOutlettype = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/outlettype/update?_' + $.now(),
		    	param: vm.scOutlettype,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
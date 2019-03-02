/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scPrice: {
			pricemode: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sc/price/info?_' + $.now(),
		    	param: vm.scPrice.pricemode,
		    	success: function(data) {
		    		vm.scPrice = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sc/price/update?_' + $.now(),
		    	param: vm.scPrice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
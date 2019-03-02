/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		scPrice: {
			pricemode: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sc/price/save?_' + $.now(),
		    	param: vm.scPrice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})


var vm = new Vue({
    el:'#dpLTE',
    data: {
        outletid: null,
        serialid: null
    },
    methods : {
        load: function () {
            $('#qrcode').attr("src", "/Path/O-"+vm.outletid+"/O-"+vm.outletid+"-"+vm.serialid+".jpg");
        }
    }
});
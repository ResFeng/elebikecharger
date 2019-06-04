/**
 * 支付
 */
var vm = new Vue({
    el:'#dpLTE',
    data: {
        scPay: {
            providerId: '',
            payMonth: '',
            amount: '',
            paymentType: 1,
            openId: '',
            accountName: '',
            bankAccount: '',
            bankCode: '',
            remark: '',
        }
    },
    methods : {
        load: function(){
            $.ajax({
                url: '../../sc/provider/info?_' + $.now(),
                data: JSON.stringify(vm.scPay.providerId),
                type: 'post',
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    vm.scPay.openId = data.rows.openid;
                    vm.scPay.bankCode = data.rows.bankcode;
                    vm.scPay.accountName = data.rows.providerfullname;
                    vm.scPay.bankAccount = data.rows.bankaccount;
                    console.log(data.rows);
                },
            })
        },
        acceptClick: function() {
            if(vm.scPay.paymentType == 0){
                if (!$('#formBalance').Validform()) {
                    return false;
                }
                $.SaveForm({
                    url: '../../sc/payprovider/pay?_' + $.now(),
                    param: vm.scPay,
                    success: function(data) {
                        // console.log(data);
                        $.currentIframe().vm.load();
                    }
                });
            }else if(vm.scPay.paymentType == 1){
                if (!$('#formBank').Validform()) {
                    return false;
                }
                $.SaveForm({
                    url: '../../sc/payprovider/save?_' + $.now(),
                    param: vm.scChargeprofit,
                    success: function(data) {
                        $.currentIframe().vm.load();
                    }
                });
            }
        },
    }
});

function openCity(evt, cityName, paymentType) {
    var i, tabcontent, tablinks;
    vm.scPay.paymentType = paymentType;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

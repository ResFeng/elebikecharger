/**
 * js
 */

$(function () {
    initialPage();
    getGrid();
});

function initialPage() {
    $(window).resize(function() {
        $('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
    });
    vm.getProviderList();
}

function getGrid() {
    $('#dataGrid').bootstrapTableEx({
        url: '../../sc/payprovider/list?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            params.providerId = vm.providerId;
            return params;
        },
        columns: [
            {checkbox: true},
            {field : "id", title: "编号", visible:false},
            {field : "providerId", title : "", visible:false, width : "100px"},
            {field : "providerName", title : "运营商", width : "300px"},
            {field : "payMonth", title : "月份", width : "100px"},
            {field : "amount", title : "金额", width : "100px"},
            {field : "paymentType", title : "支付方式", width : "100px", formatter : function(value, row, index) {
                    if(row.paymentType == 0){
                        return "微信零钱";
                    }else if(row.paymentType == 1){
                        return '银行账户';
                    }else{
                        return '未知';
                    }
            }},
            {field : "paymentstatus", title : "状态", width: "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if(row.id != null){
                        _html += '<a type="button" id="printCredential" onclick="vm.print(\''+row.id+'\', \''+row.providerName+'\')" class="btnPrint btn btn-default" href="../scprint/printCredential.html"><i class="fa fa-print"></i>&nbsp;打印凭据</span></a>' +
                            '&nbsp&nbsp<a type="button" id="printDetail" onclick="vm.print(\''+row.id+'\', \''+row.providerName+'\',  \''+row.providerId+'\', \''+row.payMonth+'\')" class="btnPrint btn btn-default" href="../scprint/printDetail.html"><i class="fa fa-print"></i>&nbsp;打印详细</a>'
                    }
                    return _html;
                }
            }
        ],
        onLoadSuccess: function () {
            $(".btnPrint").printPage();
        }
    })
}

var vm = new Vue({
    el:'#dpLTE',
    data: {
        keyword: null,
        startDate : null,
        endDate : null,
        providerId: null,
    },
    methods : {
        load: function() {
            $('#dataGrid').bootstrapTable('refresh');
        },
        getProviderList: function(){
            $.ajax({
                type:"POST",	//post request
                url:'../../sc/provider/listAll?_' + $.now(),
                dataType:"json",
                error:function () {
                },
                success:function(data){
                    var optionString = "";
                    optionString += "<option grade=\""+null+"\" value=\""+null+"\"";
                    optionString += ">"+"--所有运营商--"+"</option>";
                    for(var i = 0; i<data.length; i++){
                        optionString += "<option grade=\""+data[i].providerid+"\" value=\""+data[i].providerid+"\"";
                        optionString += ">"+data[i].providername+"</option>";
                    }
                    $('.provider').append(optionString);
                    // if(data.length == 1){
                    //     $('.provider').attr('value', data[0].providerid);
                    //     vm.providerId = data[0].providerid;
                    // }
                }
            });
        },
        print: function (payId, providerName, providerId, chargeMonth) {
            var info = {'payId':payId, 'providerName':providerName, 'providerId': providerId, 'payMonth': chargeMonth};
            localStorage.setItem('info', JSON.stringify(info));
        },
    }
});
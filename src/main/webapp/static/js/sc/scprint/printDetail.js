$(function () {
    var info = JSON.parse(localStorage.getItem('info'));
    var payType = ['微信零钱', '银行账户'];

    $.ajax({
        url: '../../sc/payprovider/getById?_' + $.now(),
        data: info.payId,
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            var $sub = $("<div id='sub'><h1 class='sub'>打款凭据</h1></div>");
            var $payId = $("<div id='payId' class='payId'>No. "+info.payId+"</div>");
            var $title = $("<div id='title'></div>");
            var $titleTable = $("<table class='titleTable' border='1' cellspacing='0' id='titleTable'>");
            var $titleBody = $("<tbody id='titleBody'>" +
                "<tr class='titleTr'>" +
                "<th class='titleHead'>运营商:</th>" +
                "<td class='titleContent' colspan='5'>"+info.providerName+"</td>" +
                "</tr>" +
                "<tr class='titleTr'>" +
                "<th class='titleHead'>姓名</th>" +
                "<td class='titleContent'>"+data.accountName+"</td>" +
                "<th class='titleHead'>结算月份:</th>" +
                "<td class='titleContent'>"+data.payMonth+"</td>" +
                "<th class='titleHead'>打款日期:</th>" +
                "<td class='titleContent'>"+data.payDate+"</td>" +
                "</tr>" +
                "<tr class='titleTr'>" +
                "<th class='titleHead'>转账方式:</th>\n" +
                "<td class='titleContent'>"+payType[data.paymentType]+"</td>\n" +
                "<th class='titleHead'>金额:</th>\n" +
                "<td class='titleContent'>"+data.amount+"</td>\n" +
                "<th class='titleHead'>中文大写:</th>\n" +
                "<td class='titleContent'>"+upRMB(data.amount)+"</td>" +
                "</tr>" +
                "<tr class='titleTr'>" +
                "<th class='titleHead'>备注</th>" +
                "<td class='titleContent' colspan='5'>"+data.remark+"</td>" +
                "</tr>" +
                "</tbody>");
            $('#content').append($sub);
            $('#content').append($payId);
            $('#content').append($title);
            $('#title').append($titleTable);
            $('#titleTable').append($titleBody);
        },
    });
    $.ajax({
        url: '../../sc/chargeprofit/listForDetail?_' + $.now(),
        data: JSON.stringify(info),
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            var $detailSub = $("<div id='detailSub'><h1 class='detailSub'>收入详细</div>");
            var $detailTable = $("<table class='detailTable' border = '1' cellspacing='0' id='detailTable'></table>");
            var $detailHead = $("<thead id='detailHead'>" +
                    "<th class='detailHead1'>设备</th>" +
                    "<th class='detailHead2'>充电次数</th>" +
                    "<th class='detailHead2'>收入</th>" +
                    "<th class='detailHead2'>用电量</th>" +
                    "<th class='detailHead2'>利润</th>" +
                "</thead>");
            var $detailBody = $("<tbody id='detailBody'></tbody>");
            $("#content").append($detailSub);
            $("#content").append($detailTable);
            $("#detailTable").append($detailHead);
            $("#detailTable").append($detailBody);
            var count = [0, 0, 0, 0];
            for(var i = 0; i < data.length; i++){
                var $detailTr = $("<tr>" +
                        "<td class='detailContent'>"+data[i].outletName+"</td>" +
                        "<td class='detailContent'>"+data[i].chargenum+"</td>" +
                        "<td class='detailContent'>"+data[i].profits+"</td>" +
                        "<td class='detailContent'>"+data[i].powerconsumption+"</td>" +
                        "<td class='detailContent'>"+data[i].distprofits+"</td>" +
                    "</tr>");
                count[0] += data[i].chargenum;
                count[1] += data[i].profits;
                count[2] += data[i].powerconsumption;
                count[3] += data[i].distprofits;
                $("#detailBody").append($detailTr);
                if(i == data.length -1){
                    var $tail = $("<tr>" +
                            "<th class='detailHead'>合计</th>" +
                            "<td class='detailContent'>"+count[0]+"</td>" +
                            "<td class='detailContent'>"+count[1].toFixed(2)+"</td>" +
                            "<td class='detailContent'>"+count[2].toFixed(2)+"</td>" +
                            "<td class='detailContent'>"+count[3].toFixed(2)+"</td>" +
                        "</tr>");
                    $("#detailBody").append($tail);
                }
            }

        }
    })
});

function upRMB(n){
    var fraction = ['角', '分'];
    var digit = [
        '零', '壹', '贰', '叁', '肆',
        '伍', '陆', '柒', '捌', '玖'
    ];
    var unit = [
        ['元', '万', '亿'],
        ['', '拾', '佰', '仟']
    ];
    var head = n < 0 ? '欠' : '';
    n = Math.abs(n);
    var s = '';
    for (var i = 0; i < fraction.length; i++) {
        s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
    }
    s = s || '整';
    n = Math.floor(n);
    for (var i = 0; i < unit[0].length && n > 0; i++) {
        var p = '';
        for (var j = 0; j < unit[1].length && n > 0; j++) {
            p = digit[n % 10] + unit[1][j] + p;
            n = Math.floor(n / 10);
        }
        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
    }
    return head + s.replace(/(零.)*零元/, '元')
        .replace(/(零.)+/g, '零')
        .replace(/^整$/, '零元整');
}
$(function () {
    var info = JSON.parse(localStorage.getItem('info'));
    console.log(info);
    var payType = ['微信零钱', '银行账户'];

    $.ajax({
        url: '../../sc/payprovider/getById?_' + $.now(),
        data: JSON.stringify(info.payId),
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
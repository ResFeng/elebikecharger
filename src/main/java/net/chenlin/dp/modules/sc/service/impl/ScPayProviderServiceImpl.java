package net.chenlin.dp.modules.sc.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.dao.ScPayProviderMapper;
import net.chenlin.dp.modules.sc.entity.ScPayProviderEntity;
import net.chenlin.dp.modules.sc.service.ScPayProviderSerivce;
import net.chenlin.dp.modules.sc.utils.*;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.*;

@Service("scPayProviderService")
public class ScPayProviderServiceImpl implements ScPayProviderSerivce {

    @Autowired
    private ScPayProviderMapper scPayProviderMapper;

    private static final String TRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 企业付款

    private static final String TRANSFERS_PAY_QUERY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo"; // 企业付款查询

    private static final String APP_ID = ConfigUtil.getProperty("wx.appid");

    private static final String MCH_ID = ConfigUtil.getProperty("wx.mchid");

    private static final String API_SECRET = ConfigUtil.getProperty("wx.api.secret");


    /**
     * 列表
     * @param params
     * @return
     */
    public Page<ScPayProviderEntity> list(Map<String, Object> params) {
        Query query = new Query(params);
        Page<ScPayProviderEntity> page = new Page<>(query);
        scPayProviderMapper.listForPage(page, query);
        return page;
    }

    /**
     * 根据id获取账单
     * @param id
     * @return
     */
    @Override
    public ScPayProviderEntity getById(Object id){
        return scPayProviderMapper.getById(id);
    }

    /**
     * 打款
     * @param scPayProviderEntity
     * @return
     */
    @Override
    public R pay(ScPayProviderEntity scPayProviderEntity) {
        scPayProviderEntity.setPaymentStatus("0");//表示未付款
        scPayProviderEntity.setIp("127.0.0.1");
        String amount = scPayProviderEntity.getAmount().multiply(new BigDecimal(100)).toString();
        scPayProviderMapper.save(scPayProviderEntity);
        Map<String, Object> params = new HashMap<>();
        params.put("providerId", scPayProviderEntity.getProviderId());
        params.put("payMonth", scPayProviderEntity.getPayMonth());
        scPayProviderEntity.setId(scPayProviderMapper.getId(params));
        String randomString = RandomStringUtils.randomAlphanumeric(32);
        scPayProviderEntity.setRandomString(randomString);

        //pack request datas and transfer to xml doc
        Map<String, String> requestParams = new HashMap<>();

        try {
            requestParams.put("mch_appid", APP_ID);//appid
            requestParams.put("mchid", MCH_ID);//mchid   1507841551
            requestParams.put("nonce_str", scPayProviderEntity.getRandomString());//random string
            requestParams.put("partner_trade_no", scPayProviderEntity.getId() + "");
            requestParams.put("openid", scPayProviderEntity.getOpenId());//openid
            requestParams.put("check_name", "FORCE_CHECK");//checkusername
            requestParams.put("re_user_name", scPayProviderEntity.getAccountName());//check username
            requestParams.put("amount", "30");//amount
            requestParams.put("desc", scPayProviderEntity.getRemark());//remark
            requestParams.put("spbill_create_ip", "115.200.47.30");//ip address
            requestParams.put("sign", PayUtil.getSign(requestParams, API_SECRET));//create signature
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, String> restmap = null;
        String restxml = HttpUtils.posts(TRANSFERS_PAY, XmlUtil.xmlFormat(requestParams, false));
        try {
            restmap = XmlUtil.xmlParse(restxml);
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e1) {
            e1.printStackTrace();
        }
        int count = 500;
        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
            scPayProviderEntity.setPaymentStatus("2");
            count = 0;
        } else {
            System.out.println(restmap.get("err_code"));
            System.out.println(restmap.get("err_code_des"));
            scPayProviderEntity.setPaymentStatus("1");
            scPayProviderMapper.remove(scPayProviderEntity.getId());
            count = 500;
        }
        return CommonUtils.msg(count);
//        System.out.println(count);
//        return CommonUtils.msg(count);


        //transfer and get result
//        String transfer= WxPayApi.transfers(requestParams, "", "");
//        Map<String, String> map = PaymentKit.xmlToMap(transfer);
//        String return_code = map.get("return_code");
//        String result_code = null;
//        count = 0;
//        if (("SUCCESS").equals(return_code)) {
//            result_code = map.get("result_code");
//            if (("SUCCESS").equals(result_code)) {
//                //transfer success
//                scPayProviderEntity.setPaymentStatus("2");
//                count = scPayProviderMapper.update(scPayProviderEntity);
//            } else {
//                //transfer fail
//                scPayProviderEntity.setPaymentStatus("1");
//                return CommonUtils.msg(500);
//            }
//        }
//            return CommonUtils.msg(count);
    }


//        get 32 bits random string
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
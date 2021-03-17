package com.lxsk.bussiness.controller;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lxsk.bussiness.dao.CustomerSignSearchDao;
import com.lxsk.bussiness.domain.*;
import com.lxsk.bussiness.service.*;
import com.lxsk.common.utils.*;
import com.lxsk.netool.Packets;
import com.lxsk.netool.YQUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 上行接口地址
 */
@RestController
@RequestMapping("/lxsk/up")
public class ShcpeUPController {
    private static final Logger logger = LoggerFactory.getLogger(ShcpeDownController.class);

    public static final ResourceBundle CONFIG_RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    @Autowired
    private CustomerSignApplyService signApplyService;
    @Autowired
    private CustomerSignResultService signResultService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CancelOrderService cancelOrderService;
    @Autowired
    private CustomerSignSearchService signSearchService;
    @Autowired
    private CustomerSignSearchDeatilService signSearchDeatilService;

    /**
     * 客户签约
     * @param signApply
     * @param bindingResult
     * @return  custSign
     */
    @PostMapping("/DGK003")
    public R custSign(@Valid CustomerSignApplyDO signApply, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if("1".equals(signApply.getBillType()) && CommUtil.isEmpty(signApply.getAcceptor())){
            return R.error("商票承兑人不能为空");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",signApply.getIdNo());
        map.put("idType",signApply.getIdType());
        map.put("status",1);//生效
        List<CustomerSignResultDO> list = signResultService.list(map);
        if(!CollectionUtils.isEmpty(list)){
            return R.error("已签约的客户无需签约申请");
        }
        signApply.setSeqNo(SerialNumUtil.msgId("LXSK"));
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");

        Element seqNo = document.createElement("seqNo");
        seqNo.setTextContent(signApply.getSeqNo());

        Element clientName = document.createElement("clientName");
        clientName.setTextContent(signApply.getClientName());

        Element idType = document.createElement("idType");
        idType.setTextContent(signApply.getIdType());

        Element idNo = document.createElement("idNo");
        idNo.setTextContent(signApply.getIdNo());

        Element salesRevenue = document.createElement("salesRevenue");
        salesRevenue.setTextContent(signApply.getSalesRevenue());

        Element contactName = document.createElement("contactName");
        contactName.setTextContent(signApply.getContactName());

        Element contactTelphone = document.createElement("contactTelphone");
        contactTelphone.setTextContent(signApply.getContactTelphone());

        Element billType = document.createElement("billType");
        billType.setTextContent(signApply.getBillType());

        Element hasPaPc = document.createElement("hasPaPc");
        hasPaPc.setTextContent(signApply.getHasPaPc());

        Element noticeON = document.createElement("noticeON");
        noticeON.setTextContent(signApply.getNoticeON());
        Element channelCode = document.createElement("channelCode");
        Element acceptor = document.createElement("acceptor");

        Element provCd = document.createElement("provCd");
        provCd.setTextContent(signApply.getProvCd());

        Element cityCd = document.createElement("cityCd");
        cityCd.setTextContent(signApply.getCityCd());

        result.appendChild(seqNo);
        result.appendChild(clientName);
        result.appendChild(idType);
        result.appendChild(idNo);
        result.appendChild(salesRevenue);
        result.appendChild(contactName);
        result.appendChild(contactTelphone);
        result.appendChild(billType);
        result.appendChild(hasPaPc);
        result.appendChild(noticeON);
        result.appendChild(channelCode);
        result.appendChild(acceptor);
        result.appendChild(provCd);
        result.appendChild(cityCd);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("客户签约,请求XML信息:{}",xml);
        String bsnCode = "DGK003";
        return client(xml, bsnCode,response -> {
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("客户签约,银企直连响应head信息:{}",resultHead);
            byte[] resultBody = response.getBody();
            if(CommUtil.isEmpty(resultBody)){
                return R.error("客户签约失败");
            }
            String resBody = new String(resultBody,"GBK");
            logger.info("客户签约,银企直连响应body信息:{}",resBody);
            Map<String, Object> stringObjectMap = XmlUtils.xmlToMap(resBody);
            if("0".equals(stringObjectMap.get("code"))){
                return R.error(stringObjectMap.get("msg").toString());
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("code"))){
                signApply.setCode(Integer.parseInt(stringObjectMap.get("code").toString()));
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("acctmgr"))){
                signApply.setAcctmgr(stringObjectMap.get("code").toString());
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("branchName"))){
                signApply.setBranchName(stringObjectMap.get("branchName").toString());
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("acctmgrPhone"))){
                signApply.setAcctmgrPhone(stringObjectMap.get("acctmgrPhone").toString());
            }
            signApplyService.save(signApply);
            return R.ok(stringObjectMap);
        });

    }

    /**
     *客户签约查询
     * @param params
     * @return   custSignResultSearch
     */
    @PostMapping("/DGK004")
    public R custSignResultSearch(@RequestParam Map<String,Object> params) throws Exception {
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element channelCode = document.createElement("channelCode");
        Element seqNo = document.createElement("seqNo");
        seqNo.setTextContent(params.get("seqNo").toString());
        result.appendChild(channelCode);
        result.appendChild(seqNo);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("请求XML信息:{}",xml);
        String bsnCode = "DGK004";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("银企直连响应head信息:{}",resultHead);
            byte[] resultBody = response.getBody();
            if(CommUtil.isEmpty(resultBody)){
                return R.error("签约查询失败");
            }
            String resBody = new String(resultBody,"GBK");
            logger.info("银企直连响应body信息:{}",resBody);
            Map<String, Object> map = XmlUtils.xmlToMap(resBody);
            if("0".equals(map.get("map"))){
                return R.error(String.valueOf(map.get("msg")));
            }
            CustomerSignSearchDO signSearchDao = new CustomerSignSearchDO();
            if("0".equals(map.get("code"))){
                return R.error(map.get("msg").toString());
            }
            signSearchDao.setCode(Integer.parseInt(map.get("code").toString()));
            if(!CommUtil.isEmpty(map.get("msg"))){
                signSearchDao.setMsg(map.get("msg").toString());
            }
            if(!CommUtil.isEmpty(map.get("acceptor"))){
                signSearchDao.setAcceptor(map.get("acceptor").toString());
            }
            if(!CommUtil.isEmpty(map.get("acceptor"))){
                signSearchDao.setAcceptor(map.get("acceptor").toString());
            }
            if(!CommUtil.isEmpty(map.get("billType"))){
                signSearchDao.setBillType(map.get("billType").toString());
            }
            if(!CommUtil.isEmpty(map.get("status"))){
                signSearchDao.setStatus(map.get("status").toString());
            }
            signSearchDao.setSeqNo(params.get("seqNo").toString());
            signSearchDao.setCreateTime(new Date());
            signSearchService.save(signSearchDao);
            CustomerSignSearchDeatilDO signSearchDeatilDO;
            if(!CommUtil.isEmpty(map.get("list"))){
                boolean bool = JSONUtil.isJsonArray(map.get("list").toString());
                if(bool){
                    net.sf.json.JSONArray list = net.sf.json.JSONArray.fromObject(map.get("list"));
                    for(int i=0;i<list.size();i++){
                        net.sf.json.JSONObject jsonObject = list.getJSONObject(i);
                        signSearchDeatilDO = new CustomerSignSearchDeatilDO();
                        signSearchDeatilDO.setBilllimitAmt(jsonObject.getString("billLimitAmt"));
                        signSearchDeatilDO.setBranch(jsonObject.getString("branch"));
                        signSearchDeatilDO.setChannelCode(jsonObject.getString("channelCode"));
                        signSearchDeatilDO.setCreditNo(jsonObject.getString("creditNo"));
                        signSearchDeatilDO.setCustManagerName(jsonObject.getString("custManagerName"));
                        signSearchDeatilDO.setCustManagerTel(jsonObject.getString("custManagerTel"));
                        signSearchDeatilDO.setDisBankName(jsonObject.getString("disBankName"));
                        signSearchDeatilDO.setDisBankNo(jsonObject.getString("disBankNo"));
                        signSearchDeatilDO.setRemainingAmt(jsonObject.getString("remainingAmt"));
                        signSearchDeatilDO.setSearchId(signSearchDao.getId());
                        signSearchDeatilService.save(signSearchDeatilDO);
                    }
                }else{
                    net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(map.get("list"));
                    signSearchDeatilDO = new CustomerSignSearchDeatilDO();
                    signSearchDeatilDO.setBilllimitAmt(jsonObject.getString("billLimitAmt"));
                    signSearchDeatilDO.setBranch(jsonObject.getString("branch"));
                    signSearchDeatilDO.setChannelCode(jsonObject.getString("channelCode"));
                    signSearchDeatilDO.setCreditNo(jsonObject.getString("creditNo"));
                    signSearchDeatilDO.setCustManagerName(jsonObject.getString("custManagerName"));
                    signSearchDeatilDO.setCustManagerTel(jsonObject.getString("custManagerTel"));
                    signSearchDeatilDO.setDisBankName(jsonObject.getString("disBankName"));
                    signSearchDeatilDO.setDisBankNo(jsonObject.getString("disBankNo"));
                    signSearchDeatilDO.setRemainingAmt(jsonObject.getString("remainingAmt"));
                    signSearchDeatilDO.setSearchId(signSearchDao.getId());
                    signSearchDeatilService.save(signSearchDeatilDO);
                }
            }
            return R.ok(map);
        });
    }

    /**
     *可贴现机构查询
     * @param params
     * @return   queryOrganList
     */
    @PostMapping("/D328")
    public R queryOrganList(@RequestParam Map<String,Object> params) throws Exception {
        if(CommUtil.isEmpty(params.get("source"))){
            return R.error("请填写接口来源");
        }
        if(CommUtil.isEmpty(params.get("channelCode"))){
            return R.error("渠道编号不能为空");
        }
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");
        Element source = document.createElement("source");
        source.setTextContent(params.get("source").toString());
        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(params.get("channelCode").toString());
        bean.appendChild(source);
        bean.appendChild(channelCode);
        Element page = document.createElement("Page");
        Element pageSize = document.createElement("pageSize");
        pageSize.setTextContent("15");
        Element currentPage = document.createElement("currentPage");
        currentPage.setTextContent("1");
        page.appendChild(pageSize);
        page.appendChild(currentPage);
        result.appendChild(bean);
        result.appendChild(page);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("可贴现机构,查询请求XML信息:{}",xml);
        String bsnCode = "D328";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("可贴现机构查询,响应head信息:{}",resultHead);
            byte[] body1 = response.getBody();
            if(CommUtil.isEmpty(body1)){
                return R.error("可贴现机构查询失败");
            }
            String bodyResult = new String(body1,"GBK");
            logger.info("可贴现机构查询,响应body信息:{}",bodyResult);
            Map<String, Object> stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            return R.ok(stringObjectMap);
        });
    }

    /**
     *询价
     * @param discountRateDO
     * @return   dscntRateSearch
     */
    @PostMapping("/D326")
    public R dscntRateSearch(@Valid DiscountRateDO discountRateDO,BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if("1".equals(discountRateDO.getBillType()) && CommUtil.isEmpty(discountRateDO.getAcceptorBankNo())){
            return R.error("银票,承兑人开户行行号必填");
        }
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");

        Element source = document.createElement("source");
        source.setTextContent(discountRateDO.getSource());

        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(discountRateDO.getChannelCode());

        Element custAccount = document.createElement("custAccount");
        Element custName = document.createElement("custName");
        Element orgsType = document.createElement("orgsType");
        Element orgsCode = document.createElement("orgsCode");

        Element billType = document.createElement("billType");
        billType.setTextContent(discountRateDO.getBillType());

        Element billClass = document.createElement("billClass");
        billClass.setTextContent(discountRateDO.getBillClass());

        Element acceptor = document.createElement("acceptor");
        acceptor.setTextContent(discountRateDO.getAcceptor());

        Element acceptorAcctNo = document.createElement("acceptorAcctNo");
        Element acceptorBankNo = document.createElement("acceptorBankNo");
        if(!CommUtil.isEmpty(discountRateDO.getAcceptorBankNo())){
            acceptorBankNo.setTextContent(discountRateDO.getAcceptorBankNo());
        }
        Element billMoney = document.createElement("billMoney");
        billMoney.setTextContent(discountRateDO.getBillMoney());

        Element dueDt = document.createElement("dueDt");
        dueDt.setTextContent(discountRateDO.getDueDt());

        bean.appendChild(source);
        bean.appendChild(channelCode);
        bean.appendChild(custAccount);
        bean.appendChild(custName);
        bean.appendChild(orgsType);
        bean.appendChild(orgsCode);
        bean.appendChild(billType);
        bean.appendChild(billClass);
        bean.appendChild(acceptor);
        bean.appendChild(acceptorAcctNo);
        bean.appendChild(acceptorBankNo);
        bean.appendChild(billMoney);
        bean.appendChild(dueDt);

        result.appendChild(bean);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("询价,请求XML信息:{}",xml);
        String bsnCode = "D326";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("询价,响应head信息:{}",resultHead);
            byte[] body1 = response.getBody();
            if(CommUtil.isEmpty(body1)){
                return R.error("平安银行询价失败");
            }
            String bodyResult = new String(body1,"GBK");
            logger.info("询价,响应body信息:{}",bodyResult);
            Map<String, Object> stringObjectMap  = XmlUtils.xmlToMap(bodyResult);
            return R.ok(stringObjectMap);
        });
    }

    /**
     *承兑人信息查询
     * @param params
     * @return   queryAcceptor
     */
    @PostMapping("/DGK006")
    public R queryAcceptor(@RequestParam Map<String,Object> params) throws Exception {

        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");

        Element keyword = document.createElement("keyword");
        if(!CommUtil.isEmpty(params.get("keyword"))){
            keyword.setTextContent(params.get("keyword").toString());
        }
        Element pageSize = document.createElement("pageSize");
        pageSize.setTextContent("10");
        Element page = document.createElement("page");
        page.setTextContent("1");
        result.appendChild(keyword);
        result.appendChild(pageSize);
        result.appendChild(page);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("承兑人信息查询,请求XML信息:{}",xml);
        String bsnCode = "DGK006";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("承兑人信息查询,响应head信息:{}",resultHead);
            byte[] body1 = response.getBody();
            Map<String, Object> stringObjectMap = new HashMap<>();
            if(!CommUtil.isEmpty(body1)){
                String bodyResult = new String(body1,"GBK");
                logger.info("承兑人信息查询,响应body信息:{}",bodyResult);
                stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            }
            return R.ok(stringObjectMap);
        });
    }


    /**
     *提交订单
     * @param orderDO
     * @return  submitOrder
     */
    @PostMapping("/D322")
    public R submitOrder(@Valid OrderDO orderDO,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        orderDO.setApplyFlowNo(SerialNumUtil.creatSerailNum(""));
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");

        Element source = document.createElement("source");
        source.setTextContent(orderDO.getSource());

        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(orderDO.getChannelCode());

        Element applyFlowNo = document.createElement("applyFlowNo");
        applyFlowNo.setTextContent(orderDO.getApplyFlowNo());

        Element orderNumber = document.createElement("orderNumber");
        orderNumber.setTextContent(orderDO.getOrderNumber());

        Element custName = document.createElement("custName");
        custName.setTextContent(orderDO.getCustName());

        Element orgsType = document.createElement("orgsType");
        orgsType.setTextContent(orderDO.getOrgsType());

        Element orgsCode = document.createElement("orgsCode");
        orgsCode.setTextContent(orderDO.getOrgsCode());

        Element discDate = document.createElement("discDate");
        discDate.setTextContent(orderDO.getDiscDate());

        Element discRate = document.createElement("discRate");
        discRate.setTextContent(orderDO.getDiscRate());

        Element billNos = document.createElement("billNos");
        billNos.setTextContent(orderDO.getBillNo());

        Element custContacts = document.createElement("custContacts");
        custContacts.setTextContent(orderDO.getCustContacts());

        Element custPhone = document.createElement("custPhone");
        custPhone.setTextContent(orderDO.getCustPhone());

        bean.appendChild(source);
        bean.appendChild(channelCode);
        bean.appendChild(applyFlowNo);
        bean.appendChild(orderNumber);
        bean.appendChild(custName);
        bean.appendChild(orgsType);
        bean.appendChild(orgsCode);
        bean.appendChild(discDate);
        bean.appendChild(discRate);
        bean.appendChild(billNos);
        bean.appendChild(custContacts);
        bean.appendChild(custPhone);
        result.appendChild(bean);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("订单提交,查询请求XML信息:{}",xml);
        String bsnCode = "D322";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("订单提交,响应head信息:{}",resultHead);
            byte[] body1 = response.getBody();
            Map<String, Object> stringObjectMap = new HashMap<>();
            if(!CommUtil.isEmpty(body1)){
                String bodyResult = new String(body1,"GBK");
                logger.info("订单提交,响应body信息:{}",bodyResult);
                stringObjectMap = XmlUtils.xmlToMap(bodyResult);
                if(!CommUtil.isEmpty(stringObjectMap.get("errCode"))){
                    orderDO.setErrCode(stringObjectMap.get("errCode").toString());
                }
                if(!CommUtil.isEmpty(stringObjectMap.get("errMsg"))){
                    orderDO.setErrMsg(stringObjectMap.get("errMsg").toString());
                }
            }
            String[] split = orderDO.getBillNo().split(",");
            for (String s : split) {
                orderDO.setBillNo(s);
                orderDO.setCreateTime(new Date());
                orderService.save(orderDO);
            }
            //logger.info("订单提交成功orderNumber:{}",orderDO.getOrderNumber());
            return R.ok(stringObjectMap);
        });
    }


    /**
     *订单查询
     * @param orderDO
     * @return   queryOrder
     */
    @PostMapping("/D323")
    public R queryOrder(@Valid CancelOrderDO orderDO,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");

        Element source = document.createElement("source");
        source.setTextContent(orderDO.getSource());

        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(orderDO.getChannelCode());

        Element applyFlowNo = document.createElement("applyFlowNo");

        Element orderNumber = document.createElement("orderNumber");
        orderNumber.setTextContent(orderDO.getOrderNumber());

        Element custName = document.createElement("custName");
        custName.setTextContent(orderDO.getCustName());

        Element orgsType = document.createElement("orgsType");
        orgsType.setTextContent(orderDO.getOrgsType());

        Element orgsCode = document.createElement("orgsCode");
        orgsCode.setTextContent(orderDO.getOrgsCode());

        Element billNos = document.createElement("billNos");
        billNos.setTextContent(orderDO.getBillNos());

        bean.appendChild(source);
        bean.appendChild(channelCode);
        bean.appendChild(applyFlowNo);
        bean.appendChild(orderNumber);
        bean.appendChild(custName);
        bean.appendChild(orgsType);
        bean.appendChild(orgsCode);
        bean.appendChild(billNos);
        result.appendChild(bean);

        Element page = document.createElement("Page");
        Element pageSize = document.createElement("pageSize");
        pageSize.setTextContent("15");
        Element currentPage = document.createElement("currentPage");
        currentPage.setTextContent("1");
        page.appendChild(pageSize);
        page.appendChild(currentPage);
        result.appendChild(page);

        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("订单查询,请求XML信息:{}",xml);
        String bsnCode = "D323";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("订单查询,响应head信息:{}",resultHead);
            byte[] body1 = response.getBody();
            Map<String, Object> stringObjectMap;
            if(CommUtil.isEmpty(body1)){
                return R.error("平安银行订单查询失败");
            }
            String bodyResult = new String(body1,"GBK");
            logger.info("订单查询,响应body信息:{}",bodyResult);
            stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            if(!CommUtil.isEmpty(stringObjectMap.get("errCode"))){
                orderDO.setErrCode(stringObjectMap.get("errCode").toString());
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("errMsg"))){
                orderDO.setErrMsg(stringObjectMap.get("errMsg").toString());
            }
            Map<String,Object> map = new HashMap<>();
            if("AAAAAAA".equals(orderDO.getErrCode())){
                net.sf.json.JSONArray list = net.sf.json.JSONArray.fromObject(stringObjectMap.get("list"));
                for(int i=0;i<list.size();i++){
                    net.sf.json.JSONObject jsonObject = list.getJSONObject(i);
                    String applyFlowNo1 = jsonObject.getString("applyFlowNo");
                    String orderNumber1 = jsonObject.getString("orderNumber");
                    String billNo = jsonObject.getString("billNo");
                    String discProcess = jsonObject.getString("discProcess");
                    map.put("applyFlowNo",applyFlowNo1);
                    map.put("orderNumber",orderNumber1);
                    map.put("billNo",billNo);
                    List<OrderDO> list1 = orderService.list(map);
                    if(!CollectionUtils.isEmpty(list1)){
                        OrderDO orderDO1 = list1.get(0);
                        orderDO1.setDiscProcess(discProcess);
                        orderDO1.setUpdateTime(new Date());
                        orderDO1.setErrMsg(orderDO.getErrMsg());
                        orderDO1.setErrCode(orderDO.getErrCode());
                        orderService.update(orderDO1);
                    }
                }
            }
            return R.ok(stringObjectMap);
        });
    }

    /**
     *取消订单
     * @param orderDO
     *    cancelOrder
     */
    @PostMapping("/D324")
    public R cancelOrder(@Valid CancelOrderDO orderDO,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if(CommUtil.isEmpty(orderDO.getApplyFlowNo())){
            return R.error("接口流水号不能为空");
        }
        if(CommUtil.isEmpty(orderDO.getDiscDate())){
            return R.error("贴现日期不能为空");
        }
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");

        Element source = document.createElement("source");
        source.setTextContent(orderDO.getSource());

        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(orderDO.getChannelCode());

        Element applyFlowNo = document.createElement("applyFlowNo");
        applyFlowNo.setTextContent(orderDO.getApplyFlowNo());

        Element orderNumber = document.createElement("orderNumber");
        orderNumber.setTextContent(orderDO.getOrderNumber());

        Element custName = document.createElement("custName");
        custName.setTextContent(orderDO.getCustName());

        Element orgsType = document.createElement("orgsType");
        orgsType.setTextContent(orderDO.getOrgsType());

        Element orgsCode = document.createElement("orgsCode");
        orgsCode.setTextContent(orderDO.getOrgsCode());

        Element discDate = document.createElement("discDate");
        discDate.setTextContent(orderDO.getDiscDate());

        Element billNos = document.createElement("billNos");
        if(!CommUtil.isEmpty(orderDO.getBillNos())){
            billNos.setTextContent(orderDO.getBillNos());
        }
        bean.appendChild(source);
        bean.appendChild(channelCode);
        bean.appendChild(applyFlowNo);
        bean.appendChild(orderNumber);
        bean.appendChild(custName);
        bean.appendChild(orgsType);
        bean.appendChild(orgsCode);
        bean.appendChild(discDate);
        bean.appendChild(billNos);
        result.appendChild(bean);
        document.appendChild(result);

        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("订单取消,请求XML信息:{}",xml);
        String bsnCode = "D324";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("订单取消,响应head信息:{}",resultHead);
            byte[] body = response.getBody();
            if(CommUtil.isEmpty(body)){
               return R.error("订单取消失败");
            }
            String bodyResult = new String(body,"GBK");
            logger.info("订单取消,响应body信息:{}",bodyResult);
            Map<String, Object> stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            if(!CommUtil.isEmpty(stringObjectMap.get("errCode"))){
                orderDO.setErrCode(stringObjectMap.get("errCode").toString());
            }
            if(!CommUtil.isEmpty(stringObjectMap.get("errMsg"))){
                orderDO.setErrMsg(stringObjectMap.get("errMsg").toString());
            }
            cancelOrderService.save(orderDO);
            return R.ok(stringObjectMap);
        });
    }

    /**
     *贴现凭证数据查询
     * @param orderDO
     * @param bindingResult
     * @throws Exception  queryVoucher
     */
    @PostMapping("/D325")
    public R queryVoucher(@Valid CancelOrderDO orderDO,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return R.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if(CommUtil.isEmpty(orderDO.getBillNos())){
            return R.error("票号不能为空");
        }
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");
        Element bean = document.createElement("Bean");

        Element source = document.createElement("source");
        source.setTextContent(orderDO.getSource());

        Element channelCode = document.createElement("channelCode");
        channelCode.setTextContent(orderDO.getChannelCode());

        Element orderNumber = document.createElement("orderNumber");
        orderNumber.setTextContent(orderDO.getOrderNumber());

        Element custName = document.createElement("custName");
        custName.setTextContent(orderDO.getCustName());

        Element orgsType = document.createElement("orgsType");
        orgsType.setTextContent(orderDO.getOrgsType());

        Element orgsCode = document.createElement("orgsCode");
        orgsCode.setTextContent(orderDO.getOrgsCode());

        Element billNos = document.createElement("billNo");
        billNos.setTextContent(orderDO.getBillNos());

        bean.appendChild(source);
        bean.appendChild(channelCode);
        bean.appendChild(orderNumber);
        bean.appendChild(custName);
        bean.appendChild(orgsType);
        bean.appendChild(orgsCode);
        bean.appendChild(billNos);
        result.appendChild(bean);

        Element page = document.createElement("Page");
        Element pageSize = document.createElement("pageSize");
        pageSize.setTextContent("15");
        Element currentPage = document.createElement("currentPage");
        currentPage.setTextContent("1");
        page.appendChild(pageSize);
        page.appendChild(currentPage);
        result.appendChild(page);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("贴现凭证数据查询,请求XML信息:{}",xml);
        String bsnCode = "D325";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("贴现凭证数据查询,响应head信息:{}",resultHead);
            byte[] body = response.getBody();
            if(CommUtil.isEmpty(body)){
                return R.error("贴现凭证数据查询失败");
            }
            String bodyResult = new String(body,"GBK");
            logger.info("贴现凭证数据查询,响应body信息:{}",bodyResult);
            Map<String, Object> stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            return R.ok(stringObjectMap);
        });
    }


    /**
     *省市代码查询
     * @param map
     * @throws Exception  queryProvCityCode
     */
    @PostMapping("/DGK010")
    public R DGK010(@RequestParam Map<String,Object> map) throws Exception{
        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);  //不显示standalone="no"
        Element result = document.createElement("Result");

        Element provCode = document.createElement("provCode");
        if(!CommUtil.isEmpty(map.get("provCode"))){
            provCode.setTextContent(map.get("provCode").toString());
        }
        result.appendChild(provCode);
        document.appendChild(result);
        String xml = XmlUtil.toStr(document,"GBK",false);
        logger.info("省市代码查询,请求XML信息:{}",xml);
        String bsnCode = "DGK010";
        return client(xml,bsnCode,response->{
            byte[] head = response.getHead();
            String resultHead = new String(head,"GBK");
            logger.info("省市代码查询,响应head信息:{}",resultHead);
            byte[] body = response.getBody();
            Map<String, Object> stringObjectMap = new HashMap<>();
            if(!CommUtil.isEmpty(body)){
                String bodyResult = new String(body,"GBK");
                logger.info("省市代码查询,响应body信息:{}",bodyResult);
                stringObjectMap = XmlUtils.xmlToMap(bodyResult);
            }
            return R.ok(stringObjectMap);
        });
    }
    /**
     * 请求平安
     * @param
     * @param
     * @return
     */
    private static R client(String xml,String bsnCode,ResponseHandle responseHandle) throws Exception {
        // 配置项获取
        String ip = CONFIG_RESOURCE_BUNDLE.getString("b2bi.ip");//前置机ip
        String prot = CONFIG_RESOURCE_BUNDLE.getString("b2bi.prot");//前置机端口号
        String yqdm = CONFIG_RESOURCE_BUNDLE.getString("b2bi.yqdm");//企业代码
        String msg = YQUtil.asemblyPackets(yqdm,bsnCode,xml);
        Packets packets = YQUtil.send2server(ip, Integer.parseInt(prot), msg,1);
        logger.info("报文头：{}",msg);
        //对平安的响应做业务处理,可执行处理
        return responseHandle.excute(packets);
    }

}

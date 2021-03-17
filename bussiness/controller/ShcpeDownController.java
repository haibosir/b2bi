package com.lxsk.bussiness.controller;

import com.lxsk.bussiness.domain.CustomerSignResultDO;
import com.lxsk.bussiness.service.CustomerSignResultService;
import com.lxsk.common.utils.CommUtil;
import com.lxsk.common.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * 下行接口地址
 */
@RestController
@RequestMapping("/lxsk/down")
public class ShcpeDownController {
    private static final Logger logger = LoggerFactory.getLogger(ShcpeUPController.class);

    @Autowired
    private CustomerSignResultService signResultService;
    /**
     *客户签约 回调
     * @param
     * @return
     */
    @PostMapping("/DGK005")
    public byte[] signCallback(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        logger.info("签约异步通知来了");
        InputStream in = req.getInputStream();
        resp.addHeader("Content-Type", "application/octet-stream");
        OutputStream byteout = resp.getOutputStream();
        int lengthHeadLen = 222;
        int lengthHeadType = 0;
        int lengthBodyLenStartposi = 30;
        int lengthBodyLen = 10;
        int contentLength = 0;
        String errMsg;
        byte[] lenHeadBuf = new byte[lengthHeadLen];
        int off = 0;
        while (off < lengthHeadLen) {
            off = off + in.read(lenHeadBuf, off, lengthHeadLen - off);
            if (off < 0) {
                errMsg="ERROR:while reading 222 head.";
                return errMsg.getBytes();
            }
        }
        byteout.write(lenHeadBuf);
        //获取报文头中的长度字段
        if (lengthHeadType == 0) {
            try{
                contentLength = Integer.parseInt(new String(lenHeadBuf, lengthBodyLenStartposi, lengthBodyLen).trim());
            }catch(Exception e){
                logger.info("获取报文头中的长度字段失败--->lenHeadBuf:{}",new String(lenHeadBuf));
                logger.info("获取报文头中的长度字段失败");
            }
        }
        //read msg content.
        byte[] contentBuf = new byte[contentLength];
        off = 0;
        while (off < contentLength) {
            off = off + in.read(contentBuf, off, contentLength - off);
            if (off < 0) {
                errMsg="ERROR:while reading length-["+contentLength+"] body.";
                return errMsg.getBytes();
            }
        }
        String res = new String(contentBuf,"GBK");
        Map<String, Object> result = XmlUtils.xmlToMap(res);
        logger.info("平安银行异步通知报文:{}",result);
        CustomerSignResultDO signResultDO = new CustomerSignResultDO();
        signResultDO.setChannelCode(String.valueOf(result.get("channelCode")));
        signResultDO.setSeqNo(String.valueOf(result.get("seqNo")));
        signResultDO.setCode(Integer.parseInt(String.valueOf(result.get("code"))));
        signResultDO.setMsg(String.valueOf(result.get("msg")));
        if(!CommUtil.isEmpty(result.get("acceptor"))){
            signResultDO.setAcceptor(result.get("acceptor").toString());
        }
        if(!CommUtil.isEmpty(result.get("beginDate"))){
            signResultDO.setBeginDate(result.get("beginDate").toString());
        }
        if(!CommUtil.isEmpty(result.get("endDate"))){
            signResultDO.setEndDate(result.get("endDate").toString());
        }
        if(!CommUtil.isEmpty(result.get("billLimit"))){
            signResultDO.setBillLimit(result.get("billLimit").toString());
        }
        if(!CommUtil.isEmpty(result.get("totalAmt"))){
            signResultDO.setTotalAmt(result.get("totalAmt").toString());
        }
        if(!CommUtil.isEmpty(result.get("remainingAmt"))){
            signResultDO.setRemainingAmt(result.get("remainingAmt").toString());
        }
        if(!CommUtil.isEmpty(result.get("billType"))){
            signResultDO.setBillType(result.get("billType").toString());
        }
        if(!CommUtil.isEmpty(result.get("branch"))){
            signResultDO.setBranch(result.get("branch").toString());
        }
        if(!CommUtil.isEmpty(result.get("channelCreateTime"))){
            signResultDO.setChannelCreateTime(result.get("channelCreateTime").toString());
        }
        if(!CommUtil.isEmpty(result.get("clientName"))){
            signResultDO.setClientName(result.get("clientName").toString());
        }
        if(!CommUtil.isEmpty(result.get("idNo"))){
            signResultDO.setIdNo(result.get("idNo").toString());
        }
        if(!CommUtil.isEmpty(result.get("idType"))){
            signResultDO.setIdType(result.get("idType").toString());
        }
        if(!CommUtil.isEmpty(result.get("status"))){
            signResultDO.setIdType(result.get("status").toString());
        }
        if(!CommUtil.isEmpty(result.get("creditNo"))){
            signResultDO.setCreditNo(result.get("creditNo").toString());
        }
        if(!CommUtil.isEmpty(result.get("custManagerName"))){
            signResultDO.setCustManagerName(result.get("custManagerName").toString());
        }
        if(!CommUtil.isEmpty(result.get("custManagerTel"))){
            signResultDO.setCustManagerTel(result.get("custManagerTel").toString());
        }
        if(!CommUtil.isEmpty(result.get("disBankName"))){
            signResultDO.setDisBankName(result.get("disBankName").toString());
        }
        if(!CommUtil.isEmpty(result.get("disBankNo"))){
            signResultDO.setDisBankNo(result.get("disBankNo").toString());
        }
        signResultService.save(signResultDO);
        return contentBuf;
    }
}

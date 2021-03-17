package com.lxsk.bussiness.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {

    private Bean bean;

    private CustInfo custInfo;

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public CustInfo getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustInfo custInfo) {
        this.custInfo = custInfo;
    }
}

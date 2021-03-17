package com.lxsk.bussiness.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustInfo {

    private String role;

    private String name;

    private String bank_no;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }
}

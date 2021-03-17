package com.lxsk.bussiness.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pageSize;

    private String currentPage;

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize='" + pageSize + '\'' +
                ", currentPage='" + currentPage + '\'' +
                '}';
    }
}

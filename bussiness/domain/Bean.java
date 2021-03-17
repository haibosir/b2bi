package com.lxsk.bussiness.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bean {

   private String source;

   private String channelCode;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "source='" + source + '\'' +
                ", channelCode='" + channelCode + '\'' +
                '}';
    }
}

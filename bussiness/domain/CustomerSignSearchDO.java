package com.lxsk.bussiness.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户签约查询; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
public class CustomerSignSearchDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//渠道号码
	private String channelCode;
	//DGK003接口的申请流水号
	private String seqNo;
	//受理状态（1成功；0拒绝）
	private Integer code;
	//状态描述（拒绝详情：工商信息有误、其他原因）
	private String msg;
	//承兑人
	private String acceptor;
	//票据类型：0-是银票，1-是商票
	private String billType;
	//客户状态：:0-待生效，1-生效，2-已失效
	private String status;

	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：渠道号码
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：渠道号码
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 设置：DGK003接口的申请流水号
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：DGK003接口的申请流水号
	 */
	public String getSeqNo() {
		return seqNo;
	}
	/**
	 * 设置：受理状态（1成功；0拒绝）
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：受理状态（1成功；0拒绝）
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：状态描述（拒绝详情：工商信息有误、其他原因）
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：状态描述（拒绝详情：工商信息有误、其他原因）
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：承兑人
	 */
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**
	 * 获取：承兑人
	 */
	public String getAcceptor() {
		return acceptor;
	}
	/**
	 * 设置：票据类型：0-是银票，1-是商票
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}
	/**
	 * 获取：票据类型：0-是银票，1-是商票
	 */
	public String getBillType() {
		return billType;
	}
	/**
	 * 设置：客户状态：:0-待生效，1-生效，2-已失效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：客户状态：:0-待生效，1-生效，2-已失效
	 */
	public String getStatus() {
		return status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

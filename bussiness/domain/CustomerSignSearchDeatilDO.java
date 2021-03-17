package com.lxsk.bussiness.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
public class CustomerSignSearchDeatilDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//渠道ID
	private String channelCode;
	//额度号
	private String creditNo;
	//授信分行
	private String branch;
	//客户经理姓名(存在多个时，用英文逗号隔开)
	private String custManagerName;
	//客户经理联系方式(存在多个时，用英文逗号隔开)
	private String custManagerTel;
	//贴入行行号
	private String disBankNo;
	//贴入行名称
	private String disBankName;
	//剩余额度
	private String remainingAmt;
	//票据额度
	private String billlimitAmt;
	//签约查询id
	private Integer searchId;

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
	 * 设置：渠道ID
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：渠道ID
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 设置：额度号
	 */
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	/**
	 * 获取：额度号
	 */
	public String getCreditNo() {
		return creditNo;
	}
	/**
	 * 设置：授信分行
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * 获取：授信分行
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * 设置：客户经理姓名(存在多个时，用英文逗号隔开)
	 */
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	/**
	 * 获取：客户经理姓名(存在多个时，用英文逗号隔开)
	 */
	public String getCustManagerName() {
		return custManagerName;
	}
	/**
	 * 设置：客户经理联系方式(存在多个时，用英文逗号隔开)
	 */
	public void setCustManagerTel(String custManagerTel) {
		this.custManagerTel = custManagerTel;
	}
	/**
	 * 获取：客户经理联系方式(存在多个时，用英文逗号隔开)
	 */
	public String getCustManagerTel() {
		return custManagerTel;
	}
	/**
	 * 设置：贴入行行号
	 */
	public void setDisBankNo(String disBankNo) {
		this.disBankNo = disBankNo;
	}
	/**
	 * 获取：贴入行行号
	 */
	public String getDisBankNo() {
		return disBankNo;
	}
	/**
	 * 设置：贴入行名称
	 */
	public void setDisBankName(String disBankName) {
		this.disBankName = disBankName;
	}
	/**
	 * 获取：贴入行名称
	 */
	public String getDisBankName() {
		return disBankName;
	}
	/**
	 * 设置：剩余额度
	 */
	public void setRemainingAmt(String remainingAmt) {
		this.remainingAmt = remainingAmt;
	}
	/**
	 * 获取：剩余额度
	 */
	public String getRemainingAmt() {
		return remainingAmt;
	}
	/**
	 * 设置：票据额度
	 */
	public void setBilllimitAmt(String billlimitAmt) {
		this.billlimitAmt = billlimitAmt;
	}
	/**
	 * 获取：票据额度
	 */
	public String getBilllimitAmt() {
		return billlimitAmt;
	}
	/**
	 * 设置：签约查询id
	 */
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	/**
	 * 获取：签约查询id
	 */
	public Integer getSearchId() {
		return searchId;
	}
}

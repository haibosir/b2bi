package com.lxsk.bussiness.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 平安客户签约-结果; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-11 14:57:05
 */
public class CustomerSignResultDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//渠道号码-线下平台
	private String channelCode;
	//申请流水号
	private String seqNo;
	//受理状态（1成功；0拒绝）
	private Integer code;
	//状态描述（拒绝详情：工商信息有误、其他原因）
	private String msg;
	//承兑人(商票返回)
	private String acceptor;
	//额度起始日(yyyyMMdd)
	private String beginDate;
	//额度结束（yyyyMMdd）
	private String endDate;
	//票据额度
	private String billLimit;
	//额度总额
	private String totalAmt;
	//剩余额度
	private String remainingAmt;
	//票据类型：0-是银票，1-是商票
	private String billType;
	//授信分行
	private String branch;
	//渠道对应业务的维护日期(yyyMMdd)
	private String channelCreateTime;
	//公司客户名称
	private String clientName;
	//公司证件号码
	private String idNo;
	//公司证件类型：0-是组织机构代码，1-是社会统一信用码
	private String idType;
	//客户状态：:0-待生效，1-生效，2-已失效
	private String status;
	//创建时间
	private Date createTime;
	//额度号
	private String creditNo;
	//客户经理姓名
	private String custManagerName;
	//客户经理联系方式
	private String custManagerTel;
	//贴入行名称
	private String disBankName;
	//贴入行行号
	private String disBankNo;

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
	 * 设置：渠道号码-线下平台
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：渠道号码-线下平台
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 设置：申请流水号
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：申请流水号
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
	 * 设置：承兑人(商票返回)
	 */
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**
	 * 获取：承兑人(商票返回)
	 */
	public String getAcceptor() {
		return acceptor;
	}
	/**
	 * 设置：额度起始日(yyyyMMdd)
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：额度起始日(yyyyMMdd)
	 */
	public String getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：额度结束（yyyyMMdd）
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：额度结束（yyyyMMdd）
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：票据额度
	 */
	public void setBillLimit(String billLimit) {
		this.billLimit = billLimit;
	}
	/**
	 * 获取：票据额度
	 */
	public String getBillLimit() {
		return billLimit;
	}
	/**
	 * 设置：额度总额
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	/**
	 * 获取：额度总额
	 */
	public String getTotalAmt() {
		return totalAmt;
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
	 * 设置：渠道对应业务的维护日期(yyyMMdd)
	 */
	public void setChannelCreateTime(String channelCreateTime) {
		this.channelCreateTime = channelCreateTime;
	}
	/**
	 * 获取：渠道对应业务的维护日期(yyyMMdd)
	 */
	public String getChannelCreateTime() {
		return channelCreateTime;
	}
	/**
	 * 设置：公司客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：公司客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：公司证件号码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：公司证件号码
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：公司证件类型：0-是组织机构代码，1-是社会统一信用码
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：公司证件类型：0-是组织机构代码，1-是社会统一信用码
	 */
	public String getIdType() {
		return idType;
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
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
	 * 设置：客户经理姓名
	 */
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	/**
	 * 获取：客户经理姓名
	 */
	public String getCustManagerName() {
		return custManagerName;
	}
	/**
	 * 设置：客户经理联系方式
	 */
	public void setCustManagerTel(String custManagerTel) {
		this.custManagerTel = custManagerTel;
	}
	/**
	 * 获取：客户经理联系方式
	 */
	public String getCustManagerTel() {
		return custManagerTel;
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
}

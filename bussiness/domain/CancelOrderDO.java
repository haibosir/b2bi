package com.lxsk.bussiness.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;



/**
 * 平安取消订单; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public class CancelOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//S1-银企直连 S2-B2BI S3-OPEN API S4-OPEN BANKS 5-网银 S6-橙e中台
	@NotBlank(message = "接口来源不能为空")
	@Length(max = 5, message = "接口来源长度超过限制")
	private String source;
	//渠道编号
	@NotBlank(message = "渠道编号不能为空")
	@Length(max = 20, message = "渠道编号长度超过限制")
	private String channelCode;
	//接口流水号仅数字，建议包含日期与时分秒数据
	private String applyFlowNo;
	//订单编号仅支持字母与数字
	@NotBlank(message = "订单编号不能为空")
	@Length(max = 50, message = "订单编号长度超过限制")
	private String orderNumber;
	//客户名称
	@NotBlank(message = "客户名称不能为空")
	@Length(max = 120, message = "客户名称长度超过限制")
	private String custName;
	//证件类型1-统一社会信用证 2-组织机构代码证
	@NotBlank(message = "证件类型不能为空")
	@Length(max = 1, message = "证件类型长度超过限制")
	private String orgsType;
	//证件号
	@NotBlank(message = "证件号不能为空")
	@Length(max = 20, message = "证件号长度超过限制")
	private String orgsCode;
	//贴现日期YYYY-MM-DD
	private String discDate;
	//不输，则整个订单都取消；输入，则取消输入的票号，输入支持英文逗号分隔,最多200张票
	private String billNos;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//AAAAAAA表示接口调用成功；BBBBBBB表示接口调用失败。

	private String errCode;
	//失败原因
	private String errMsg;

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
	 * 设置：S1-银企直连 S2-B2BI S3-OPEN API S4-OPEN BANK
S5-网银 S6-橙e中台

	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：S1-银企直连 S2-B2BI S3-OPEN API S4-OPEN BANK
S5-网银 S6-橙e中台

	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：渠道编号
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：渠道编号
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 设置：接口流水号仅数字，建议包含日期与时分秒数据
	 */
	public void setApplyFlowNo(String applyFlowNo) {
		this.applyFlowNo = applyFlowNo;
	}
	/**
	 * 获取：接口流水号仅数字，建议包含日期与时分秒数据
	 */
	public String getApplyFlowNo() {
		return applyFlowNo;
	}
	/**
	 * 设置：订单编号仅支持字母与数字
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * 获取：订单编号仅支持字母与数字
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 设置：客户名称
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * 设置：证件类型1-统一社会信用证 2-组织机构代码证
	 */
	public void setOrgsType(String orgsType) {
		this.orgsType = orgsType;
	}
	/**
	 * 获取：证件类型1-统一社会信用证 2-组织机构代码证
	 */
	public String getOrgsType() {
		return orgsType;
	}
	/**
	 * 设置：证件号
	 */
	public void setOrgsCode(String orgsCode) {
		this.orgsCode = orgsCode;
	}
	/**
	 * 获取：证件号
	 */
	public String getOrgsCode() {
		return orgsCode;
	}
	/**
	 * 设置：贴现日期YYYY-MM-DD
	 */
	public void setDiscDate(String discDate) {
		this.discDate = discDate;
	}
	/**
	 * 获取：贴现日期YYYY-MM-DD
	 */
	public String getDiscDate() {
		return discDate;
	}
	/**
	 * 设置：不输，则整个订单都取消；输入，则取消输入的票号，输入支持英文逗号分隔,最多200张票
	 */
	public void setBillNos(String billNos) {
		this.billNos = billNos;
	}
	/**
	 * 获取：不输，则整个订单都取消；输入，则取消输入的票号，输入支持英文逗号分隔,最多200张票
	 */
	public String getBillNos() {
		return billNos;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：AAAAAAA表示接口调用成功；BBBBBBB表示接口调用失败。

	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	/**
	 * 获取：AAAAAAA表示接口调用成功；BBBBBBB表示接口调用失败。

	 */
	public String getErrCode() {
		return errCode;
	}
	/**
	 * 设置：失败原因
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * 获取：失败原因
	 */
	public String getErrMsg() {
		return errMsg;
	}
}

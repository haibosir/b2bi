package com.lxsk.bussiness.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;



/**
 * 平安订单申请; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//S1-银企直连 S2-B2BI S3-OPEN API S4-OPEN BANK S5-网银 S6-橙e中台
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
	@NotBlank(message = "贴现日期不能为空")
	@Length(max = 10, message = "贴现日期长度超过限制")
	private String discDate;
	//贴现利率
	@NotBlank(message = "贴现利率不能为空")
	@Length(max = 8, message = "贴现利率长度超过限制")
	private String discRate;
	//票号
	@NotBlank(message = "票号不能为空")
	@Length(max = 6200, message = "票号长度超过限制")
	private String billNo;
	//客户联系人
	@NotBlank(message = "客户联系人为空")
	@Length(max = 120, message = "客户联系人长度超过限制")
	private String custContacts;
	//客户联系方式仅支持半角短横线或纯数字
	@NotBlank(message = "客户联系方式为空")
	@Length(max = 30, message = "客户联系方式长度超过限制")
	private String custPhone;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//AAAAAAA表示接口调用成功；BBBBBBB表示接口调用失败。

	private String errCode;
	//失败原因
	private String errMsg;
	//1、收到订单,等待网银提票：我行ECDS未收到对应票号票据的贴现申请；
	//2、订单已取消；
	//3、订单受理中：我行ECDS已收到对应票号票据的贴现申请，票据处于贴现待签收状态；
	//4、订单已完成：我行ECDS已收到对应票号票据的贴现申请，并放款成功；
	//5、已驳回：我行ECDS已收到对应票号票据的贴现申请并予驳回。
	//6. 已失效（提票日期>贴现日期）
	private String discProcess;
	//驳回原因
	private String rejectReason;

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
	 * 设置：贴现利率
	 */
	public void setDiscRate(String discRate) {
		this.discRate = discRate;
	}
	/**
	 * 获取：贴现利率
	 */
	public String getDiscRate() {
		return discRate;
	}
	/**
	 * 设置：票号
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	/**
	 * 获取：票号
	 */
	public String getBillNo() {
		return billNo;
	}
	/**
	 * 设置：客户联系人
	 */
	public void setCustContacts(String custContacts) {
		this.custContacts = custContacts;
	}
	/**
	 * 获取：客户联系人
	 */
	public String getCustContacts() {
		return custContacts;
	}
	/**
	 * 设置：客户联系方式仅支持半角短横线或纯数字
	 */
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	/**
	 * 获取：客户联系方式仅支持半角短横线或纯数字
	 */
	public String getCustPhone() {
		return custPhone;
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
	/**
	 * 设置：1、收到订单,等待网银提票：我行ECDS未收到对应票号票据的贴现申请；
2、订单已取消；
3、订单受理中：我行ECDS已收到对应票号票据的贴现申请，票据处于贴现待签收状态；
4、订单已完成：我行ECDS已收到对应票号票据的贴现申请，并放款成功；
5、已驳回：我行ECDS已收到对应票号票据的贴现申请并予驳回。
6. 已失效（提票日期>贴现日期）

	 */
	public void setDiscProcess(String discProcess) {
		this.discProcess = discProcess;
	}
	/**
	 * 获取：1、收到订单,等待网银提票：我行ECDS未收到对应票号票据的贴现申请；
2、订单已取消；
3、订单受理中：我行ECDS已收到对应票号票据的贴现申请，票据处于贴现待签收状态；
4、订单已完成：我行ECDS已收到对应票号票据的贴现申请，并放款成功；
5、已驳回：我行ECDS已收到对应票号票据的贴现申请并予驳回。
6. 已失效（提票日期>贴现日期）

	 */
	public String getDiscProcess() {
		return discProcess;
	}
	/**
	 * 设置：驳回原因
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	/**
	 * 获取：驳回原因
	 */
	public String getRejectReason() {
		return rejectReason;
	}
}

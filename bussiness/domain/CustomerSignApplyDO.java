package com.lxsk.bussiness.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;



/**
 * 平安 客户签约申请; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
@XmlRootElement
public class CustomerSignApplyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Integer id;
	//
	private String channelCode;
	//申请流水号
	private String seqNo;
	//公司名称
	@NotBlank(message = "公司名称不能为空")
	@Length(max = 64, message = "公司名称长度超过限制")
	private String clientName;
	//证件类型：0-是组织机构代码，1-是社会
	@NotBlank(message = "证件类型不能为空")
	@Length(max = 2, message = "证件类型长度超过限制")
	private String idType;
	//证件号码
	@NotBlank(message = "证件号码不能为空")
	@Length(max = 64, message = "证件号码长度超过限制")
	private String idNo;
	//年度销售收入(元)
	@NotBlank(message = "年度销售收入不能为空")
	@Length(max = 20, message = "年度销售收入长度超过限制")
	private String salesRevenue;
	//联系人姓名
	@NotBlank(message = "联系人姓名不能为空")
	@Length(max = 128, message = "联系人姓名长度超过限制")
	private String contactName;
	//联系人手机号
	@NotBlank(message = "联系人手机号不能为空")
	@Length(max = 11, message = "联系人手机号长度超过限制")
	private String contactTelphone;
	//票据类型：0-是银票，1-是商票
	@NotBlank(message = "票据类型不能为空")
	@Length(max = 2, message = "票据类型长度超过限制")
	private String billType;
	//选择承兑人（银行线下提供），当票据类型为商票时必须输入
	private String acceptor;
	//是否有平安对公账号：0-无，1-有
	@NotBlank(message = "是否有平安对公账号不能为空")
	@Length(max = 2, message = "是否有平安对公账号长度超过限制")
	private String hasPaPc;
	//是否需要结果通知，1-需要0-不需要 不填写默认为0
	private String noticeON;
	//省代码
	@NotBlank(message = "省代码不能为空")
	@Length(max = 16, message = "省代码长度超过限制")
	private String provCd;
	//市代码
	@NotBlank(message = "市代码不能为空")
	@Length(max = 16, message = "市代码长度超过限制")
	private String cityCd;
	//受理状态（1成功；0拒绝）
	private Integer code;
	//状态描述（拒绝详情：工商信息有误、其他原因）
	private String msg;
	//银行客户经理联系人姓名
	private String acctmgr;
	//银行客户经理手机
	private String acctmgrPhone;
	//银行客户经理分行名称
	private String branchName;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

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
	 * 设置：
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：
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
	 * 设置：公司名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：证件类型：0-是组织机构代码，1-是社会
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：证件类型：0-是组织机构代码，1-是社会
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：年度销售收入(元)
	 */
	public void setSalesRevenue(String salesRevenue) {
		this.salesRevenue = salesRevenue;
	}
	/**
	 * 获取：年度销售收入(元)
	 */
	public String getSalesRevenue() {
		return salesRevenue;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系人手机号
	 */
	public void setContactTelphone(String contactTelphone) {
		this.contactTelphone = contactTelphone;
	}
	/**
	 * 获取：联系人手机号
	 */
	public String getContactTelphone() {
		return contactTelphone;
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
	 * 设置：选择承兑人（银行线下提供），当票据类型为商票时必须输入
	 */
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**
	 * 获取：选择承兑人（银行线下提供），当票据类型为商票时必须输入
	 */
	public String getAcceptor() {
		return acceptor;
	}
	/**
	 * 设置：是否有平安对公账号：0-无，1-有
	 */
	public void setHasPaPc(String hasPaPc) {
		this.hasPaPc = hasPaPc;
	}
	/**
	 * 获取：是否有平安对公账号：0-无，1-有
	 */
	public String getHasPaPc() {
		return hasPaPc;
	}
	/**
	 * 设置：是否需要结果通知，1-需要0-不需要 不填写默认为0


	 */
	public void setNoticeON(String noticeON) {
		this.noticeON = noticeON;
	}
	/**
	 * 获取：是否需要结果通知，1-需要0-不需要 不填写默认为0


	 */
	public String getNoticeON() {
		return noticeON;
	}

	public String getProvCd() {
		return provCd;
	}

	public void setProvCd(String provCd) {
		this.provCd = provCd;
	}

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
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
	 * 设置：银行客户经理联系人姓名
	 */
	public void setAcctmgr(String acctmgr) {
		this.acctmgr = acctmgr;
	}
	/**
	 * 获取：银行客户经理联系人姓名
	 */
	public String getAcctmgr() {
		return acctmgr;
	}
	/**
	 * 设置：银行客户经理手机
	 */
	public void setAcctmgrPhone(String acctmgrPhone) {
		this.acctmgrPhone = acctmgrPhone;
	}
	/**
	 * 获取：银行客户经理手机
	 */
	public String getAcctmgrPhone() {
		return acctmgrPhone;
	}
	/**
	 * 设置：银行客户经理分行名称
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * 获取：银行客户经理分行名称
	 */
	public String getBranchName() {
		return branchName;
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

	@Override
	public String toString() {
		return "CustomerSignApplyDO{" +
				"id=" + id +
				", channelCode='" + channelCode + '\'' +
				", seqNo='" + seqNo + '\'' +
				", clientName='" + clientName + '\'' +
				", idType='" + idType + '\'' +
				", idNo='" + idNo + '\'' +
				", salesRevenue='" + salesRevenue + '\'' +
				", contactName='" + contactName + '\'' +
				", contactTelphone='" + contactTelphone + '\'' +
				", billType='" + billType + '\'' +
				", acceptor='" + acceptor + '\'' +
				", hasPaPc='" + hasPaPc + '\'' +
				", noticeON='" + noticeON + '\'' +
				", provCd='" + provCd + '\'' +
				", cityCd='" + cityCd + '\'' +
				", code=" + code +
				", msg='" + msg + '\'' +
				", acctmgr='" + acctmgr + '\'' +
				", acctmgrPhone='" + acctmgrPhone + '\'' +
				", branchName='" + branchName + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}

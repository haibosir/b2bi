package com.lxsk.bussiness.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;



/**
 * 平安贴现利率查询; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public class DiscountRateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//S1-银企直连 S2-B2BI S3-OPEN API S4-OPEN BANKS5-网银 S6-橙e中台
	@NotBlank(message = "接口来源不能为空")
	@Length(max = 5, message = "接口来源长度超过限制")
	private String source;
	//渠道编号
	@NotBlank(message = "渠道编号不能为空")
	@Length(max = 20, message = "渠道编号长度超过限制")
	private String channelCode;
	//客户账号
	private String custAccount;
	//客户名称
	private String custName;
	//1-统一社会信用证 2-组织机构代码证

	private String orgsType;
	//证件号
	private String orgsCode;
	//票据类型1－银票 2－商票
	@NotBlank(message = "票据类型不能为空")
	@Length(max = 20, message = "票据类型长度超过限制")
	private String billType;
	//票据种类1－纸票 2－电子
	@NotBlank(message = "票据种类不能为空")
	@Length(max = 20, message = "票据种类长度超过限制")
	private String billClass;
	//承兑人名称
	@NotBlank(message = "承兑人名称不能为空")
	@Length(max = 120, message = "承兑人名称长度超过限制")
	private String acceptor;
	//承兑人账号 银票必输---其中普通银票：上送0；代理接入的财司票：需上送承兑人账号；商票非必输
	private String acceptorAcctNo;
	//承兑人开户行行号 银票必输
	private String acceptorBankNo;
	//票面金额
	@NotBlank(message = "票面金额不能为空")
	@Length(max = 32, message = "票面金额长度超过限制")
	private String billMoney;
	//到期日 yyyy-mm-dd
	@NotBlank(message = "到期日不能为空")
	@Length(max = 10, message = "到期日长度超过限制")
	private String dueDt;
	//接口处理结果AAAAAAA表示接口调用成功；BBBBBBB表示接口调用失败。
	private String errCode;
	//失败原因
	private String errMsg;
	//创建时间
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
	 * 设置：客户账号
	 */
	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}
	/**
	 * 获取：客户账号
	 */
	public String getCustAccount() {
		return custAccount;
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
	 * 设置：1-统一社会信用证 2-组织机构代码证

	 */
	public void setOrgsType(String orgsType) {
		this.orgsType = orgsType;
	}
	/**
	 * 获取：1-统一社会信用证 2-组织机构代码证

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
	 * 设置：票据类型1－银票 2－商票

	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}
	/**
	 * 获取：票据类型1－银票 2－商票

	 */
	public String getBillType() {
		return billType;
	}
	/**
	 * 设置：票据种类1－纸票 2－电子

	 */
	public void setBillClass(String billClass) {
		this.billClass = billClass;
	}
	/**
	 * 获取：票据种类1－纸票 2－电子

	 */
	public String getBillClass() {
		return billClass;
	}
	/**
	 * 设置：承兑人名称
	 */
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**
	 * 获取：承兑人名称
	 */
	public String getAcceptor() {
		return acceptor;
	}
	/**
	 * 设置：承兑人账号 银票必输---其中普通银票：上送0；代理接入的财司票：需上送承兑人账号；商票非必输

	 */
	public void setAcceptorAcctNo(String acceptorAcctNo) {
		this.acceptorAcctNo = acceptorAcctNo;
	}
	/**
	 * 获取：承兑人账号 银票必输---其中普通银票：上送0；代理接入的财司票：需上送承兑人账号；商票非必输

	 */
	public String getAcceptorAcctNo() {
		return acceptorAcctNo;
	}
	/**
	 * 设置：承兑人开户行行号 银票必输
	 */
	public void setAcceptorBankNo(String acceptorBankNo) {
		this.acceptorBankNo = acceptorBankNo;
	}
	/**
	 * 获取：承兑人开户行行号 银票必输
	 */
	public String getAcceptorBankNo() {
		return acceptorBankNo;
	}
	/**
	 * 设置：票面金额
	 */
	public void setBillMoney(String billMoney) {
		this.billMoney = billMoney;
	}
	/**
	 * 获取：票面金额
	 */
	public String getBillMoney() {
		return billMoney;
	}
	/**
	 * 设置：到期日 yyyy-mm-dd
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	/**
	 * 获取：到期日 yyyy-mm-dd
	 */
	public String getDueDt() {
		return dueDt;
	}
	/**
	 * 设置：接口处理结果AAAAAAA表示接口调用成功；
BBBBBBB表示接口调用失败。

	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	/**
	 * 获取：接口处理结果AAAAAAA表示接口调用成功；
BBBBBBB表示接口调用失败。

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
}

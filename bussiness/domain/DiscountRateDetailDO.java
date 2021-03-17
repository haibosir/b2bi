package com.lxsk.bussiness.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 平安利率查询详情; InnoDB free: 10240 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-03-09 12:37:26
 */
public class DiscountRateDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//贴现利率id
	private Integer discountRateId;
	//贴现报价
	private String suggestRate;
	//实付金额
	private String payMoney;
	//贴现利息
	private String interest;

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
	 * 设置：贴现利率id
	 */
	public void setDiscountRateId(Integer discountRateId) {
		this.discountRateId = discountRateId;
	}
	/**
	 * 获取：贴现利率id
	 */
	public Integer getDiscountRateId() {
		return discountRateId;
	}
	/**
	 * 设置：贴现报价
	 */
	public void setSuggestRate(String suggestRate) {
		this.suggestRate = suggestRate;
	}
	/**
	 * 获取：贴现报价
	 */
	public String getSuggestRate() {
		return suggestRate;
	}
	/**
	 * 设置：实付金额
	 */
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：实付金额
	 */
	public String getPayMoney() {
		return payMoney;
	}
	/**
	 * 设置：贴现利息
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * 获取：贴现利息
	 */
	public String getInterest() {
		return interest;
	}
}

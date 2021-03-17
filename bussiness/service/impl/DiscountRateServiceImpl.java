package com.lxsk.bussiness.service.impl;

import com.lxsk.bussiness.dao.DiscountRateDao;
import com.lxsk.bussiness.domain.DiscountRateDO;
import com.lxsk.bussiness.service.DiscountRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class DiscountRateServiceImpl implements DiscountRateService {
	@Autowired
	private DiscountRateDao discountRateDao;
	
	@Override
	public DiscountRateDO get(Integer id){
		return discountRateDao.get(id);
	}
	
	@Override
	public List<DiscountRateDO> list(Map<String, Object> map){
		return discountRateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return discountRateDao.count(map);
	}
	
	@Override
	public int save(DiscountRateDO discountRate){
		return discountRateDao.save(discountRate);
	}
	
	@Override
	public int update(DiscountRateDO discountRate){
		return discountRateDao.update(discountRate);
	}
	
	@Override
	public int remove(Integer id){
		return discountRateDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return discountRateDao.batchRemove(ids);
	}
	
}

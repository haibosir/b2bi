package com.lxsk.bussiness.service.impl;

import com.lxsk.bussiness.dao.DiscountRateDetailDao;
import com.lxsk.bussiness.domain.DiscountRateDetailDO;
import com.lxsk.bussiness.service.DiscountRateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class DiscountRateDetailServiceImpl implements DiscountRateDetailService {
	@Autowired
	private DiscountRateDetailDao discountRateDetailDao;
	
	@Override
	public DiscountRateDetailDO get(Integer id){
		return discountRateDetailDao.get(id);
	}
	
	@Override
	public List<DiscountRateDetailDO> list(Map<String, Object> map){
		return discountRateDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return discountRateDetailDao.count(map);
	}
	
	@Override
	public int save(DiscountRateDetailDO discountRateDetail){
		return discountRateDetailDao.save(discountRateDetail);
	}
	
	@Override
	public int update(DiscountRateDetailDO discountRateDetail){
		return discountRateDetailDao.update(discountRateDetail);
	}
	
	@Override
	public int remove(Integer id){
		return discountRateDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return discountRateDetailDao.batchRemove(ids);
	}
	
}

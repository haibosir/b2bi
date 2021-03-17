package com.lxsk.bussiness.service.impl;

import com.lxsk.bussiness.dao.CancelOrderDao;
import com.lxsk.bussiness.domain.CancelOrderDO;
import com.lxsk.bussiness.service.CancelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class CancelOrderServiceImpl implements CancelOrderService {
	@Autowired
	private CancelOrderDao cancelOrderDao;
	
	@Override
	public CancelOrderDO get(Integer id){
		return cancelOrderDao.get(id);
	}
	
	@Override
	public List<CancelOrderDO> list(Map<String, Object> map){
		return cancelOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cancelOrderDao.count(map);
	}
	
	@Override
	public int save(CancelOrderDO cancelOrder){
		return cancelOrderDao.save(cancelOrder);
	}
	
	@Override
	public int update(CancelOrderDO cancelOrder){
		return cancelOrderDao.update(cancelOrder);
	}
	
	@Override
	public int remove(Integer id){
		return cancelOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return cancelOrderDao.batchRemove(ids);
	}
	
}

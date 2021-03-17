package com.lxsk.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.dao.CustomerSignResultDao;
import com.lxsk.bussiness.domain.CustomerSignResultDO;
import com.lxsk.bussiness.service.CustomerSignResultService;



@Service
public class CustomerSignResultServiceImpl implements CustomerSignResultService {
	@Autowired
	private CustomerSignResultDao customerSignResultDao;
	
	@Override
	public CustomerSignResultDO get(Integer id){
		return customerSignResultDao.get(id);
	}
	
	@Override
	public List<CustomerSignResultDO> list(Map<String, Object> map){
		return customerSignResultDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerSignResultDao.count(map);
	}
	
	@Override
	public int save(CustomerSignResultDO customerSignResult){
		return customerSignResultDao.save(customerSignResult);
	}
	
	@Override
	public int update(CustomerSignResultDO customerSignResult){
		return customerSignResultDao.update(customerSignResult);
	}
	
	@Override
	public int remove(Integer id){
		return customerSignResultDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return customerSignResultDao.batchRemove(ids);
	}
	
}

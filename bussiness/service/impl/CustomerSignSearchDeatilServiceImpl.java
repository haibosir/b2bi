package com.lxsk.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.lxsk.bussiness.dao.CustomerSignSearchDeatilDao;
import com.lxsk.bussiness.domain.CustomerSignSearchDeatilDO;
import com.lxsk.bussiness.service.CustomerSignSearchDeatilService;



@Service
public class CustomerSignSearchDeatilServiceImpl implements CustomerSignSearchDeatilService {
	@Autowired
	private CustomerSignSearchDeatilDao customerSignSearchDeatilDao;
	
	@Override
	public CustomerSignSearchDeatilDO get(Integer id){
		return customerSignSearchDeatilDao.get(id);
	}
	
	@Override
	public List<CustomerSignSearchDeatilDO> list(Map<String, Object> map){
		return customerSignSearchDeatilDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return customerSignSearchDeatilDao.count(map);
	}
	
	@Override
	public int save(CustomerSignSearchDeatilDO customerSignSearchDeatil){
		return customerSignSearchDeatilDao.save(customerSignSearchDeatil);
	}
	
	@Override
	public int update(CustomerSignSearchDeatilDO customerSignSearchDeatil){
		return customerSignSearchDeatilDao.update(customerSignSearchDeatil);
	}
	
	@Override
	public int remove(Integer id){
		return customerSignSearchDeatilDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return customerSignSearchDeatilDao.batchRemove(ids);
	}
	
}

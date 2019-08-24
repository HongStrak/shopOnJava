package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Addr;
import com.lanqiao.domain.TbAddress;
import com.lanqiao.mapper.TbAddressMapper;
import com.lanqiao.service.IAddrService;


@Service
public class AddrService implements IAddrService {
	@Autowired
	private TbAddressMapper addrmapper;
	@Override
	public int insert(Addr record) {
		// TODO Auto-generated method stub
		return addrmapper.insert(record);
	}
	@Override
	public List<TbAddress> selectAll(Integer uid) {
		// TODO Auto-generated method stub
		return addrmapper.selectAll(uid);
	}
	@Override
	public TbAddress selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return addrmapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKey(Addr record) {
		// TODO Auto-generated method stub
		return addrmapper.updateByPrimaryKey(record);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return addrmapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(Integer uid) {
		addrmapper.update(uid);
		
	}
	@Override
	public void update1(TbAddress record) {
		// TODO Auto-generated method stub
		addrmapper.update1(record);
	}

}

package com.lanqiao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lanqiao.domain.Address;
import com.lanqiao.mapper.UserMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1() {
		/*Address address = new Address();
		address.setUid(1);
		address.setAddress("河南省商丘市民权县城关村");
		address.setIsDefaultAddr("1");
		userMapper.insertAddress(address);*/
		
		List<Address> list = userMapper.selectAddressByUid(1);
		for (Address address : list) {
			System.out.println(address);
			
		}
	}
}

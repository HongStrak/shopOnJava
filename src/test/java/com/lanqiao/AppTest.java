package com.lanqiao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lanqiao.domain.Address;
import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.mapper.ShoppingCartMapper;
import com.lanqiao.mapper.UserMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
	
	@Autowired
	private UserMapper userMapper;
	
    @Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
    
	@Test
	public void test1() {
		List<ShoppingCart> list = shoppingCartMapper.selectShoppingCartByUid(1);
		System.out.println(list);
		
	}
	
	
}

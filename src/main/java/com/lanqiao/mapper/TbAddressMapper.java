package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Addr;
import com.lanqiao.domain.TbAddress;
@Mapper
public interface TbAddressMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(Addr record);

    public TbAddress selectByPrimaryKey(Integer id);

    public List<TbAddress> selectAll(Integer uid);

   public int updateByPrimaryKey(Addr record);
   public void update(Integer uid);
   public void update1(TbAddress record);
}
package com.lanqiao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.TbUser;

@Mapper
public interface TbUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TbUser record);

    public TbUser selectByPrimaryKey(TbUser record);
    public TbUser select(TbUser record);

    List<TbUser> selectAll();

    public int updateByPrimaryKey(TbUser record);
}
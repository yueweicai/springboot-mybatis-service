package com.orilore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.Dept;

@Mapper
public interface DeptMapper {
	public List<Dept> selectAll();
	public Dept selectOne(int id);
	public void insert(Dept bean);
	public void update(Dept bean);
	public void delete(int id);
}

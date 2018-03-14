package com.orilore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orilore.model.Emp;

@Mapper
public interface EmpMapper {
	public List<Emp> selectAll();
	public Emp selectOne(int id);
	public void insert(Emp bean);
	public void update(Emp bean);
	public void delete(int id);
}

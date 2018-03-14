package com.orilore.service;

import java.util.List;

import com.orilore.model.Dept;

public interface IDeptService {
	public void caldept(int id);
	public void save(Dept dept);
	public Dept find(int id);
	public List<Dept> findAll();
}

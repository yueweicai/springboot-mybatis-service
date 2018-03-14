package com.orilore.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orilore.mapper.DeptMapper;
import com.orilore.mapper.EmpMapper;
import com.orilore.model.Dept;
import com.orilore.model.Emp;

@Service
public class DeptService implements IDeptService{
	@Resource
	private DeptMapper dm;
	@Resource
	private EmpMapper em;
	@Override
	/*
	 * ISOLATION 用于控制事物的隔离级别(non-Javadoc)
	 * 分别用于防止脏读、幻读、不可重复读等数据读取问题
	 * Propagation用于控制事物的传播行为
	 * readOnly 用于配置事物的只读状态
	 * timeOut 用于配置事物执行的超时时间
	 * rollbackFor 用于配置事物的回滚原则
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=java.sql.SQLException.class)
	public void caldept(int id) {
		//根据ID查询部门
		Dept dept = this.dm.selectOne(id);
		//获取所属该部门的所有员工
		List<Emp> emps = dept.getEmps();
		for (Emp emp : emps) {
			Dept d = new Dept();
			emp.setDept(d);
			if(emp.getId()==10){
				d.setId(1000);
				emp.setDept(d);
			}
			em.update(emp);
		}
		this.dm.delete(id);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Dept dept) {
		if(dept.getId()!=null){
			this.dm.update(dept);
		}else{
			this.dm.insert(dept);
		}
	}
	@Override
	public Dept find(int id) {
		return this.dm.selectOne(id);
	}
	@Override
	public List<Dept> findAll() {
		return this.dm.selectAll();
	}
}

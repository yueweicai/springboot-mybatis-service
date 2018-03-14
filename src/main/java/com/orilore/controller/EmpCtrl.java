package com.orilore.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orilore.mapper.EmpMapper;
import com.orilore.model.Emp;

@RestController
@RequestMapping("/emp.do")
public class EmpCtrl {
	@Resource
	private EmpMapper mapper;
	@RequestMapping("/save")
	public boolean save(Emp bean){
		try {
			if(bean.getId()>0){
				this.mapper.update(bean);
			}else{
				this.mapper.insert(bean);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		try {
			this.mapper.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/get/{id}")
	public Emp get(@PathVariable("id") int id){
		return this.mapper.selectOne(id);
	}
	@RequestMapping("/query")
	public List<Emp> query(){
		return this.mapper.selectAll();
	}
}

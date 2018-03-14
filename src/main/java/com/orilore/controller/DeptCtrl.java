package com.orilore.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orilore.model.Dept;
import com.orilore.service.IDeptService;

@RestController
@RequestMapping("/dept.do")
public class DeptCtrl {
	@Resource
	private IDeptService service;
	@RequestMapping("/remove/{id}")
	public boolean remove(@PathVariable("id") int id){
		try{
			this.service.caldept(id);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/save")
	public boolean save(Dept bean){
		try{
			this.service.save(bean);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/query")
	public List<Dept> query(){
		return this.service.findAll();
	}
	@RequestMapping("/get/{id}")
	public Dept get(@PathVariable("id") int id){
		return this.service.find(id);
	}
}

package com.mycompany.jpa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.mycompany.jpa.data.MovieCrud;
import com.mycompany.jpa.data.UserCrud;
import com.mycompany.jpa.entity.*;

@Service
public class UserBusiness {
	

	@Autowired
	private UserCrud userCrud;
	
	@Autowired
	private MovieCrud movieCrud;
	
	public String save() {
		UserEntity user = new UserEntity("Porsiya");
		userCrud.save(user);
		System.out.println("user id is: " + user.getUser_Id());
		return "Saved the data" + user.getUser_Id() + "--" + user.getFirst_Name();
	}
	
	public String save(String fname) {
		UserEntity user = new UserEntity(fname);
		userCrud.save(user);
		System.out.println("inside save fname method employee id is: " + user.getUser_Id());
		System.out.println("Find method " + userCrud.findById(1L));
		return "Saved the data" + user.getUser_Id() + "--" + user.getFirst_Name();
	}
	
	public String saveUser(UserEntity user) {
		userCrud.save(user);
		System.out.println("user id is: " + user.getUser_Id());
		return "Saved the data" + user.getUser_Id() + "--" + user.getFirst_Name();
	}
	
	public List findAll() {
		return userCrud.findAll();
	}
	
	public String remove(Long id) {
		userCrud.deleteById(id);
		return "Removed the data";
	}

	//lombok changes
	public String saveMovie(String name) {
		Movie movie= new Movie(name);
		movieCrud.save(movie);
		System.out.println("inside saveDept method dept id is: " + movie.getMovie_id());
		//System.out.println("Find method " + deptCrud.findById(1L));
		return "Saved the data" + movie.getMovie_id() + "--" + movie.getMovie_name();
	}

}

package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController 
{
   @Autowired
  UserRepo userRepo;
   
   @RequestMapping("deleteTask{taskid}/mytokenstarts{token}")
   public boolean deleteTask(@PathVariable int taskid, HttpServletRequest request)
   {
   	try {
			
   		User user=(User) request.getAttribute("user");
   		List<Task> list=user.getTask();
   		
   		for (int i = 0; i <list.size(); i++) 
   		{
			
   			if (list.get(i).getId()==taskid)
   			{
   				list.remove(i);
   				break;
   			}
			}
   		userRepo.save(user);
   		
   		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
   }
	
   @RequestMapping("addTask/mytokenstarts{token}")
   public boolean addTask(@RequestBody Task task, HttpServletRequest request)
   {
	try {
		 User user=(User) request.getAttribute("user");
		 user.getTask().add(task);
		 userRepo.save(user);
		 return true;
		
	} catch (Exception e) 
	{
		e.printStackTrace();
	return false;
	}   
   }
   
   @RequestMapping("myDetails/mytokenstarts{token}")
   public User yourname(HttpServletRequest request)
   {
	   try {
		   User user=(User) request.getAttribute("user");
		   
		   return user;
	} catch (Exception e) 
	   {
		e.printStackTrace();
		return null;
	}
	  
	   
   }
   @RequestMapping("changeworkstatus/{id}/{status}")
   public boolean changeworkstatus (@PathVariable int id, @PathVariable int status ,HttpServletRequest request)
   {
	   try {
		   User user=(User) request.getAttribute("user");
		   List<Task> list=user.getTask();
		   for (int i = 0; i <list.size(); i++) 
		   {
			
			   if (list.get(i).getId()==id)
			   {
				   list.get(i).setStatus(status);
			   }
		}
		   userRepo.save(user);
		   return true;
		   
	} catch (Exception e) {
		e.printStackTrace();
		return false;
		// TODO: handle exception
	}
	   
	   
   }
   @RequestMapping("changeworkdescription/{id}/{desc}")
   public boolean changeworks (@PathVariable int id, @PathVariable String desc ,HttpServletRequest request)
   {
	   try {
		   User user=(User) request.getAttribute("user");
		   List<Task> list=user.getTask();
		   for (int i = 0; i <list.size(); i++) 
		   {
			
			   if (list.get(i).getId()==id)
			   {
				   list.get(i).setWork(desc);
			   }
		}
		   userRepo.save(user);
		   return true;
		   
	} catch (Exception e) {
		e.printStackTrace();
		return false;
		// TODO: handle exception
	}
	   
	   
   }
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


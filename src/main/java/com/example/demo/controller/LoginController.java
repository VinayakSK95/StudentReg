package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginObject;
import com.example.demo.model.ReturnLoginObj;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.security.JwtUtil1;
import com.example.demo.security.UserDetailService;
import com.example.demo.security.UserDetails;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController 
{
    @Autowired
	UserRepo userRepo;
	
    @Autowired
    JwtUtil1 jwtutil;
    
    @RequestMapping("login")
    public ReturnLoginObj abcd(@RequestBody LoginObject obj)//aalele obj
    {
    
    	if (obj!=null && obj.getUserName()!=null && obj.getPassword()!=null)
    	{
    		//this obj!=null comming from angular may angular devloper send this obj as null thats why we have to check the obj first it should not be null
    		int count = userRepo.countByUsername(obj.getUserName());
        	if (count==1)	
        	{
        		User dbobj=userRepo.findByUsername(obj.getUserName());
        		if (obj.getPassword().equals(dbobj.getPassword())==true)
        		{                               //comparing with databse obj
        			
        			UserDetails userDetails =new UserDetailService(dbobj);
        			
        			String token =jwtutil.generateToken(userDetails);
        			return new ReturnLoginObj(1, null, token);
        			
        		}
        		return new ReturnLoginObj(0, "wrongPassword", null);
        		
        	}
        	else if (count==0)
        	
        		return new ReturnLoginObj(0, "usernameWrong", null);
        		else
        			return new ReturnLoginObj(0, "Something wrong with system please contact adminstrate", null);
        	
    	}
    	return new ReturnLoginObj(0, "incomplete info", null);
    	
    	
    }
    
    @RequestMapping("register")
    
    public String register(@RequestBody User user)
    {
    	if (user!=null && user.getName()!=null && user.getUsername()!=null && user.getPassword()!=null)
    	{
    		if (userRepo.countByUsername(user.getUsername())==0)
    		{
    			if (user.getPassword().length()>=4)
    			{
    				userRepo.save(user);
    				return "congrats";
    			}
    			return "min 4 len required for password";
    		}
    		return "duplicate username";
    	}
    	return "Incomplete data";
    	
    }
    
   
    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


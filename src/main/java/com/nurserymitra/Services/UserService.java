package com.nurserymitra.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Users;
import com.nurserymitra.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Service
public class UserService 
{
	@Autowired
	UserRepository u1;
	public Users validateUser(String email, String password) {
        return u1.findByEmailAndPassword(email, password);
    }
	public Users getLoggedInUser(HttpSession session) {
	    Integer userId = (Integer) session.getAttribute("loggedInUserId");
	    if (userId != null) {
	        return getUserById(userId);
	    }
	    return null;
	}
	public Users getUserById(int id) {
	    return u1.findById(id).orElse(null);
	}
	public List<Users> getAllUsers()
	{
		return u1.findAll();
	}

	public void saveUsers(Users users)
	{
		u1.save(users);
	}
}

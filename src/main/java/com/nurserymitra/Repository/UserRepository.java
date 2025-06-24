package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurserymitra.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>
{
	Users findByEmailAndPassword(String email, String password);
	
}

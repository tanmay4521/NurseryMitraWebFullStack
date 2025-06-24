package com.nurserymitra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nurserymitra.Entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>
{
}

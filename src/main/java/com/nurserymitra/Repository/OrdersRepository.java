package com.nurserymitra.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nurserymitra.Entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>
{ 
}

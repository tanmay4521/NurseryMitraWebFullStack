package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurserymitra.Entity.DeliveredOrder;
@Repository
public interface DeliveredOrderRepository extends JpaRepository<DeliveredOrder, Long>
{
}

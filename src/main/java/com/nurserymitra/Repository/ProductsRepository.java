package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nurserymitra.Entity.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>{

}

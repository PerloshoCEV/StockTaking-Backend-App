package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Product;

public interface Product_Repository extends JpaRepository<T_Product, Long>
{

}

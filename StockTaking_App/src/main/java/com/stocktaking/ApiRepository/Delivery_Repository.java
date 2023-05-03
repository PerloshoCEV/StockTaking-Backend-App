package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Delivery;

public interface Delivery_Repository extends JpaRepository<T_Delivery, Long>
{

}

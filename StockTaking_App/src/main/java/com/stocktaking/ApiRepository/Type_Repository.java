package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Type;

public interface Type_Repository extends JpaRepository<T_Type, Long>
{

}

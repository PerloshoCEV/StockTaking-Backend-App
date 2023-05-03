package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Sale;

public interface Sale_Repository extends JpaRepository<T_Sale, Long>
{

}

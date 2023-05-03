package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_Bill;
import com.stocktaking.EntityBBDD.T_Bill;

public interface Bill_Repository extends JpaRepository<T_Bill, EmbKey_Bill>
{

}

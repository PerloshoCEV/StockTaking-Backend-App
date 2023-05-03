package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Supplier;

public interface Supplier_Repository extends JpaRepository<T_Supplier, Long>
{

}

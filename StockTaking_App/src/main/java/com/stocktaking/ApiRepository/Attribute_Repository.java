package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Attribute;

public interface Attribute_Repository extends JpaRepository<T_Attribute, Long>
{

}

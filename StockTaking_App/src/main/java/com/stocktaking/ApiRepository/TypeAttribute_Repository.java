package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_TypeAttribute;
import com.stocktaking.EntityBBDD.T_TypeAttribute;

public interface TypeAttribute_Repository extends JpaRepository<T_TypeAttribute, EmbKey_TypeAttribute>
{

}

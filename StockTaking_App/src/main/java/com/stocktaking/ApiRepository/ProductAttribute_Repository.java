package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_ProductAttribute;
import com.stocktaking.EntityBBDD.T_ProductAttribute;

public interface ProductAttribute_Repository extends JpaRepository<T_ProductAttribute, EmbKey_ProductAttribute>
{
	
}

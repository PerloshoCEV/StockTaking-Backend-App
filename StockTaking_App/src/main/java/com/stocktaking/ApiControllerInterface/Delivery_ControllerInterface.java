package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Delivery;
import com.stocktaking.Entity_DTO.Delivery_Dto;

@RequestMapping("/stocktaking")
public interface Delivery_ControllerInterface extends BaseControllerInterface<T_Delivery, Delivery_Dto> 
{
	
}

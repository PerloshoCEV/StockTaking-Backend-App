package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Client;
import com.stocktaking.Entity_DTO.Client_Dto;

@RequestMapping("/stocktaking")
public interface Client_ControllerInterface extends BaseControllerInterface<T_Client, Client_Dto>
{
	
}

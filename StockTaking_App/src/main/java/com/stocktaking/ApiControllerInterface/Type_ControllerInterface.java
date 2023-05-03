package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Type;
import com.stocktaking.Entity_DTO.Type_Dto;

@RequestMapping("/stocktaking")
public interface Type_ControllerInterface extends BaseControllerInterface<T_Type, Type_Dto>
{

}

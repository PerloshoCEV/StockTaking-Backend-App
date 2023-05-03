package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Attribute;
import com.stocktaking.Entity_DTO.Attribute_Dto;

@RequestMapping("/stocktaking")
public interface Attribute_ControllerInterface extends BaseControllerInterface<T_Attribute, Attribute_Dto>
{

}

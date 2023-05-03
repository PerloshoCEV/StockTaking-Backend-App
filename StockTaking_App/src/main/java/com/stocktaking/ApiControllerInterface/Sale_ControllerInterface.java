package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Sale;
import com.stocktaking.Entity_DTO.Sale_Dto;

@RequestMapping("/stocktaking")
public interface Sale_ControllerInterface extends BaseControllerInterface<T_Sale, Sale_Dto>
{

}

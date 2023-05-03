package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Supplier;
import com.stocktaking.Entity_DTO.Supplier_Dto;

@RequestMapping("/stocktaking")
public interface Supplier_ControllerInterface extends BaseControllerInterface<T_Supplier, Supplier_Dto>
{

}

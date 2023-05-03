package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Product;
import com.stocktaking.Entity_DTO.Product_Dto;

@RequestMapping("/stocktaking")
public interface Product_ControllerInterface extends BaseControllerInterface<T_Product, Product_Dto>
{

}

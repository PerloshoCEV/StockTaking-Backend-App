package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.TypeAttribute_ControllerInterface;
import com.stocktaking.Entity_DTO.TypeAttribute_Dto;
import com.stocktaking.Response.ApiResponse;

@RestController
public class TypeAttribute_Controller implements TypeAttribute_ControllerInterface 
{

	@Override
	@PostMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> create(TypeAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/alltypeattributes")
	public ApiResponse<List<TypeAttribute_Dto>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> readOne(TypeAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> Update(TypeAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> Delete(TypeAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}

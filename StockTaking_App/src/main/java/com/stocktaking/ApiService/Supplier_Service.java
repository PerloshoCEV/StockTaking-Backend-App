package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Supplier_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Supplier;
import com.stocktaking.Entity_DTO.Supplier_Dto;

@Service
public class Supplier_Service implements Base_ServiceInterface<T_Supplier, Supplier_Dto>
{
	@Autowired
	Supplier_Repository repository;
	
	@Override
	public Supplier_Dto createBaseService(T_Supplier newSupplier) 
	{
		T_Supplier supplierToSave = repository.save(newSupplier);
		
		Supplier_Dto supplierDto = new Supplier_Dto(supplierToSave);
		
		return supplierDto;
	}

	@Override
	public List<Supplier_Dto> readBaseAllService() 
	{
		List<T_Supplier> listSuppliers =  repository.findAll();
		List<Supplier_Dto> listSuppliersDto = new ArrayList<Supplier_Dto>();
		
		for (T_Supplier t_Supplier : listSuppliers) 
		{
			Supplier_Dto supplierDto = new Supplier_Dto(t_Supplier);
			listSuppliersDto.add(supplierDto);
		}
		
		return listSuppliersDto;
		
	}

	@Override
	public Supplier_Dto readBaseId(Long id) 
	{
		T_Supplier supplierToRead = repository.getReferenceById(id);
		
		Supplier_Dto supplierDto = new Supplier_Dto(supplierToRead);
		
		return supplierDto;
	}

	@Override
	public Supplier_Dto updateBase(T_Supplier supplier) 
	{
		T_Supplier supplierToUpdate = repository.getReferenceById(supplier.getId());
		supplierToUpdate.setAll
			(
				supplier.getName(), 
				supplier.getEmail(),
				supplier.getAddress(),
				supplier.getDescription()
			);
		supplierToUpdate = repository.save(supplierToUpdate);
		
		Supplier_Dto supplierDto = new Supplier_Dto(supplierToUpdate);
		
		return supplierDto;
		
	}

	@Override
	public Supplier_Dto deleteBaseId(Supplier_Dto supplierToDelete) 
	{
		
		Long id = supplierToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return supplierToDelete;
	}

	@Override
	public Supplier_Dto findBaseByIdService(Long id) 
	{
		Supplier_Dto supplierDto = null;
		Optional<T_Supplier> finder = repository.findById(id);
		if (finder.isPresent())
		{
			supplierDto = new Supplier_Dto(finder.get());
		}
		
		return supplierDto;
	}
}

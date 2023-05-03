package com.stocktaking.ApiServiceInterface;

import java.util.List;

public interface Base_ServiceInterface <T, DTO>
{
	public DTO createBaseService(T newBase);
	
	public List<DTO> readBaseAllService();

	public DTO readBaseId(Long id);

	public DTO updateBase(T entityToModify);

	public DTO deleteBaseId(DTO entityToDelete);

	public DTO findBaseByIdService(Long id);
}

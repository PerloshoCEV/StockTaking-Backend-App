package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Client_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Client;
import com.stocktaking.Entity_DTO.Client_Dto;

@Service
public class Client_Service implements Base_ServiceInterface<T_Client, Client_Dto>
{
	@Autowired
	Client_Repository repository;
	
	@Override
	public Client_Dto createBaseService(T_Client newClient) 
	{
		T_Client clientToSave = repository.save(newClient);
		
		Client_Dto clientDto = new Client_Dto(clientToSave);
		
		return clientDto;
	}

	@Override
	public List<Client_Dto> readBaseAllService() 
	{
		List<T_Client> listClients =  repository.findAll();
		List<Client_Dto> listClientsDto = new ArrayList<Client_Dto>();
		
		for (T_Client t_Client : listClients) 
		{
			Client_Dto clientDto = new Client_Dto(t_Client);
			listClientsDto.add(clientDto);
		}
		
		return listClientsDto;
		
	}

	@Override
	public Client_Dto readBaseId(Long id) 
	{
		T_Client clientToRead = repository.getReferenceById(id);
		
		Client_Dto clientDto = new Client_Dto(clientToRead);
		
		return clientDto;
	}

	@Override
	public Client_Dto updateBase(T_Client client) 
	{
		T_Client clientToUpdate = repository.getReferenceById(client.getId());
		clientToUpdate.setAll
			(
				client.getName(), 
				client.getLastName(),
				client.getSecondLastName(),
				client.getAge()
			);
		clientToUpdate = repository.save(clientToUpdate);
		
		Client_Dto clientDto = new Client_Dto(clientToUpdate);
		
		return clientDto;
		
	}

	@Override
	public Client_Dto deleteBaseId(Client_Dto clientToDelete) 
	{
		
		Long id = clientToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return clientToDelete;
	}

	@Override
	public Client_Dto findBaseByIdService(Long id) 
	{
		Client_Dto clientDto = null;
		Optional<T_Client> finder = repository.findById(id);
		if (finder.isPresent())
		{
			clientDto = new Client_Dto(finder.get());
		}
		
		return clientDto;
	}
}

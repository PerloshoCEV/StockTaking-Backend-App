package com.stocktaking.Response;

import com.stocktaking.Enum.MessageResult;

public class ApiResponse  <T> 
{
	/*
		Variables
	*/
	private T response;
	private Metadata metadata;
	private MessageResult messageResult;
	
	/*
		Constructores
	*/
	public ApiResponse(Metadata metadataToSend)
	{
		response = null;
		metadata = metadataToSend;
		messageResult = MessageResult.DEFAULT;
	}
	
	public ApiResponse(T responseToSend, Metadata metadataToSend)
	{
		response = responseToSend;
		metadata = metadataToSend;
		messageResult = MessageResult.DEFAULT;
	}
	
	/*
		Getters & Setters
	*/
	public T getResponse() 
	{
		return response;
	}
	
	public void setResponse(T response) 
	{
		this.response = response;
	}
	
	public Metadata getMetadata() 
	{
		return metadata;
	}
	
	public void setMetadata(Metadata metadata) 
	{
		this.metadata = metadata;
	}
	
	public MessageResult getMessage() 
	{
		return this.messageResult;
	}
	
	public void setMessage(MessageResult message) 
	{
		this.messageResult = message;
	}
}

package com.stocktaking.Response;

public class Pagination 
{
	/*
		Variables
	*/
	private int currentPage;
	private int currentSize;
	private int totalCount;
	private int totalPages;
	
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	private int previousPagNumber;
	private int nextPageNumber;
	
	/*
		Constructores
	*/
	public Pagination() 
	{
	}
	
	public Pagination
	(
		int currentPage, int currentSize, 
		int totalCount, int totalPages, 
		boolean hasPreviousPage, boolean hasNextPage, 
		int previousPagNumber, int nextPageNumber
	) 
	{
		this.currentPage = currentPage;
		this.currentSize = currentSize;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
		this.previousPagNumber = previousPagNumber;
		this.nextPageNumber = nextPageNumber;
	}
	
	/*
		Getters & Setters
	*/
	public int getCurrentPage() 
	{
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) 
	{
		this.currentPage = currentPage;
	}
	
	public int getCurrentSize() 
	{
		return currentSize;
	}
	
	public void setCurrentSize(int currentSize) 
	{
		this.currentSize = currentSize;
	}
	
	public int getTotalCount() 
	{
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) 
	{
		this.totalCount = totalCount;
	}
	
	public int getTotalPages() 
	{
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) 
	{
		this.totalPages = totalPages;
	}
	
	public boolean isHasPreviousPage() 
	{
		return hasPreviousPage;
	}
	
	public void setHasPreviousPage(boolean hasPreviousPage) 
	{
		this.hasPreviousPage = hasPreviousPage;
	}
	
	public boolean isHasNextPage() 
	{
		return hasNextPage;
	}
	
	public void setHasNextPage(boolean hasNextPage) 
	{
		this.hasNextPage = hasNextPage;
	}
	
	public int getPreviousPagNumber() 
	{
		return previousPagNumber;
	}
	
	public void setPreviousPagNumber(int previousPagNumber) 
	{
		this.previousPagNumber = previousPagNumber;
	}
	
	public int getNextPageNumber() 
	{
		return nextPageNumber;
	}
	
	public void setNextPageNumber(int nextPageNumber) 
	{
		this.nextPageNumber = nextPageNumber;
	}
}

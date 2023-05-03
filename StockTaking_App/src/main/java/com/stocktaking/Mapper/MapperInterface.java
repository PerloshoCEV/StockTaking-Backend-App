package com.stocktaking.Mapper;

/*
Todos los DTO van a implementar esta interface
*/
public interface MapperInterface  <ENTITY>
{
	boolean mapper(ENTITY entity);
}

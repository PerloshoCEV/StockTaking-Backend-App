package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Client;

public interface Client_Repository extends JpaRepository<T_Client, Long>
{

}

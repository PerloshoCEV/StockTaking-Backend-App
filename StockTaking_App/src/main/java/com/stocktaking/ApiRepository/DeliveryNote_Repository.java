package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_DeliveryNote;
import com.stocktaking.EntityBBDD.T_DeliveryNote;

public interface DeliveryNote_Repository extends JpaRepository<T_DeliveryNote, EmbKey_DeliveryNote>
{

}

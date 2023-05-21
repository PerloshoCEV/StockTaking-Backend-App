package com.stocktaking.ApiRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stocktaking.Entity_DTO.DeliveryNote_Dto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class DeliveryNote_Repository 
{
	
	// Pillo la url de la BBDD desde el application.properties
			@Value("${spring.datasource.url}")
		    private String dbUrl; 
			
			// Pillo el username de la BBDD desde el application.properties
			@Value("${spring.datasource.username}")
		    private String dbUsername;

			// Pillo la contraseña de la BBDD desde el application.properties
			@Value("${spring.datasource.password}")
		    private String dbPassword;
		    
			/*
			  Método para la consulta Create:
			  INSERT INTO T_DELIVERYNOTE
			  	(PRODUCT_ID, Atrribute_ID, value)
			  VALUES 
			  	(productId, attributeId, value)
			*/
			public DeliveryNote_Dto create(Long deliveryId, Long productId, Long supplierId, Integer quantity) 
			{
				// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
				// Todas esas configuraciones las pilla directamente del application.properties
				try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
				{
					// El String SQL: Usamos values ? para que se inserten por parámetros 
					// En vez de por concatenación, por seguridad de SQL-injection.
		          String sql = 
		          		"INSERT INTO T_DELIVERYNOTE " +
		          		"(DELIVERY_ID, PRODUCT_ID, SUPPLIER_ID, QUANTITY) " +
		          		"VALUES (?, ?, ?, ?)";
		          
		          PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		          //a continuación, los parámetros:
		          statement.setLong(1, deliveryId);
		          statement.setLong(2, productId);
		          statement.setLong(3, supplierId);
		          statement.setInt(4, quantity);
		          
		          // Ejecutamos el comando, y si el resultado ha dado más de una fila:
		          if (statement.executeUpdate() > 0) 
		          {
		          	// Devolvemos el nuevo registro creado.
		              return new DeliveryNote_Dto(deliveryId, productId, supplierId, quantity);
		          }
		      } 
				catch (Exception e) // Si algo del try falla:
				{
		          e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		      }
		      return null;
		  }


		/*
		Método para la consulta DELETE:
			"DELETE FROM T_DELIVERYNOTE " +
			"WHERE " +
		    "DELIVERY_ID = ? AND " +
		    "PRODUCT_ID = ? AND " +
		    "SUPPLIER_ID = ? AND " +
		    "QUANTITY = ? "
		*/
		public DeliveryNote_Dto delete(Long deliveryId, Long productId, Long supplierId, Integer quantity) 
		{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
			DeliveryNote_Dto entityToDelete = new DeliveryNote_Dto(deliveryId, productId, supplierId, quantity);

		// Si se ha encontrado el registro:
		if (entityToDelete != null) 
		{
			// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
			try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		        String sql = 
		        		"DELETE FROM T_DELIVERYNOTE " +
						"WHERE " +
		    				"DELIVERY_ID = ? AND " +
		    				"PRODUCT_ID = ? AND " +
		    				"SUPPLIER_ID = ? AND " +
		    				"QUANTITY = ? ";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a continuación, los parámetros:
		          statement.setLong(1, deliveryId);
		          statement.setLong(2, productId);
		          statement.setLong(3, supplierId);
		          statement.setInt(4, quantity);
		        
		        statement.executeUpdate();
		        // No hace falta if, ya que estamos dentro de un if que compueba si existe.
		        // devolvemos el registro.
		        return entityToDelete;
		    } 
			catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
		}


		return null;
		}

		/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
		Método para la consultar con DeliveryId:
		"SELECT * " +
		"FROM T_DELIVERYNOTE " +
		"WHERE DELIVERY_ID = ? "
		*/

		public List<DeliveryNote_Dto> findByDeliveryId(Long deliveryId) 
		{
			List<DeliveryNote_Dto> listDeliveryNote_Dto = new ArrayList<DeliveryNote_Dto>();
			
			
			// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
			// Todas esas configuraciones las pilla directamente del application.properties
		    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		    	// El String SQL: Usamos values ? para que se inserten por parámetros 
				// En vez de por concatenación, por seguridad de SQL-injection.
		        String sql = 
		        		"SELECT * " +
		        		"FROM T_DELIVERYNOTE " +
		        		"WHERE DELIVERY_ID = ? ";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a continuación, los parámetros:
		        statement.setLong(1, deliveryId);
		        
		        // Almacenamos el resultado en resultSet
		        ResultSet resultSet = statement.executeQuery();
		        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
		        while (resultSet.next()) 
		        {      
		        	listDeliveryNote_Dto.add(new DeliveryNote_Dto(resultSet.getLong("Delivery_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Supplier_ID"),resultSet.getInt("Quantity")));
		        	
		        }
		    } 
		    catch (Exception e) // Si algo del try falla:
		    {
		        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		    }
		    return listDeliveryNote_Dto;
		}
		
		/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
		Método para la consultar con ProductId:
		"SELECT * " +
		"FROM T_DELIVERYNOTE " +
		"WHERE PRODUCT_ID = ? "
		*/

		public List<DeliveryNote_Dto> findByProductId(Long productId) 
		{
			List<DeliveryNote_Dto> listDeliveryNote_Dto = new ArrayList<DeliveryNote_Dto>();
			
			
			// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
			// Todas esas configuraciones las pilla directamente del application.properties
		    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		    	// El String SQL: Usamos values ? para que se inserten por parámetros 
				// En vez de por concatenación, por seguridad de SQL-injection.
		        String sql = 
		        		"SELECT * " +
		        		"FROM T_DELIVERYNOTE " +
		        		"WHERE PRODUCT_ID = ? ";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a continuación, los parámetros:
		        statement.setLong(1, productId);
		        
		        // Almacenamos el resultado en resultSet
		        ResultSet resultSet = statement.executeQuery();
		        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
		        while (resultSet.next()) 
		        {      
		        	listDeliveryNote_Dto.add(new DeliveryNote_Dto(resultSet.getLong("Delivery_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Supplier_ID"),resultSet.getInt("Quantity")));
		        	
		        }
		    } 
		    catch (Exception e) // Si algo del try falla:
		    {
		        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		    }
		    return listDeliveryNote_Dto;
		}

		

		/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
		Método para la consultar con SupplierId:
		"SELECT * " +
		"FROM T_DELIVERYNOTE " +
		"WHERE SUPPLIER_ID = ? "
		*/

		public List<DeliveryNote_Dto> findBySupplierId(Long supplierId) 
		{
			List<DeliveryNote_Dto> listDeliveryNote_Dto = new ArrayList<DeliveryNote_Dto>();
			
			
			// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
			// Todas esas configuraciones las pilla directamente del application.properties
		    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		    	// El String SQL: Usamos values ? para que se inserten por parámetros 
				// En vez de por concatenación, por seguridad de SQL-injection.
		        String sql = 
		        		"SELECT * " +
		        		"FROM T_DELIVERYNOTE " +
		        		"WHERE SUPPLIER_ID = ? ";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a continuación, los parámetros:
		        statement.setLong(1, supplierId);
		        
		        // Almacenamos el resultado en resultSet
		        ResultSet resultSet = statement.executeQuery();
		        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
		        while (resultSet.next()) 
		        {      
		        	listDeliveryNote_Dto.add(new DeliveryNote_Dto(resultSet.getLong("Delivery_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Supplier_ID"),resultSet.getInt("Quantity")));
		        	
		        }
		    } 
		    catch (Exception e) // Si algo del try falla:
		    {
		        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		    }
		    return listDeliveryNote_Dto;
		}



}

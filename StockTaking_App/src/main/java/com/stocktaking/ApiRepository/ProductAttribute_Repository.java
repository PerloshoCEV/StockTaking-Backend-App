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

import com.stocktaking.Entity_DTO.ProductAttribute_Dto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class ProductAttribute_Repository 
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
		  INSERT INTO T_PRODUCTATTRIBUTE
		  	(PRODUCT_ID, Atrribute_ID, value)
		  VALUES 
		  	(productId, attributeId, value)
		*/
		public ProductAttribute_Dto create(Long productId, Long attributeId, String value) 
		{
			String attributeName ="";
			// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
			// Todas esas configuraciones las pilla directamente del application.properties
			try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
			{
				// El String SQL: Usamos values ? para que se inserten por parámetros 
				// En vez de por concatenación, por seguridad de SQL-injection.
	          String sql = 
	          		"INSERT INTO T_PRODUCTATTRIBUTE " +
	          		"(PRODUCT_ID, ATTRIBUTE_ID, VALUE) " +
	          		"VALUES (?, ?, ?)";
	          
	          PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	          //a continuación, los parámetros:
	          statement.setLong(1, productId);
	          statement.setLong(2, attributeId);
	          statement.setString(3, value);
	          
	          // Ejecutamos el comando, y si el resultado ha dado más de una fila:
	          if (statement.executeUpdate() > 0) 
	          {
	          	// Devolvemos el nuevo registro creado.
	              return new ProductAttribute_Dto(productId, attributeId, attributeName, value);
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
	DELETE FROM T_PRODUCTATTRIBUTE  
	WHERE
	  	PRODUCT_ID = productId AND
	  	ATTRIBUTE_ID = attributeId AND
	  	"VALUE = ? "
	*/
	public ProductAttribute_Dto delete(Long productId, Long attributeId, String value) 
	{
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
		ProductAttribute_Dto entityToDelete = new ProductAttribute_Dto(productId, attributeId, "", value);

	// Si se ha encontrado el registro:
	if (entityToDelete != null) 
	{
		// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	        String sql = 
	        		"DELETE FROM T_PRODUCTATTRIBUTE " +
					"WHERE " +
	    				"PRODUCT_ID = ? AND " +
	    				"ATTRIBUTE_ID = ? AND " +
	    				"VALUE = ? ";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a continuación, los parámetros:
	        statement.setLong(1, productId);
	        statement.setLong(2, attributeId);
	        statement.setString(3, value);
	        
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
	Método para la consultar con ProductId:
	"SELECT * " +
	"FROM T_PRODUCTATTRIBUTE " +
	"WHERE PRODUCT_ID = ? "
	*/

	public List<ProductAttribute_Dto> findByProductId(Long productId) 
	{
		List<ProductAttribute_Dto> listProductAttribute_Dto = new ArrayList<ProductAttribute_Dto>();
		
		
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT "
	        				+ "T1.PRODUCT_ID AS Product_ID, "
	        				+ "T1.ATTRIBUTE_ID AS Attribute_ID, "
	        				+ "T2.NAME AS AttributeName, "
	        				+ "T1.VALUE_ATTR AS Value_ATTR " +
	        		"FROM "
	        			+ "T_PRODUCT_ATTRIBUTE AS T1 "
	        				+ "INNER JOIN "
        				+ "T_ATTRIBUTE AS T2 "
        				+ " ON (T1.ATTRIBUTE_ID = T2.ID) " +
	        		"WHERE T1.PRODUCT_ID = ? ";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a continuación, los parámetros:
	        statement.setLong(1, productId);
	        
	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        while (resultSet.next()) 
	        {      
	        	listProductAttribute_Dto.add(new ProductAttribute_Dto(resultSet.getLong("Product_ID"),resultSet.getLong("Attribute_ID"), resultSet.getString("AttributeName"), resultSet.getString("value_ATTR")));
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return listProductAttribute_Dto;
	}



	/*Método para la consultar con AttributeId:
	"SELECT * " +
	"FROM T_PRODUCTATTRIBUTE " +
	"WHERE ATTRIBUTE_ID = ? "
	*/

	public List<ProductAttribute_Dto> findByAttributeId(Long attributeId) 
	{
		List<ProductAttribute_Dto> listProductAttribute_Dto = new ArrayList<ProductAttribute_Dto>();
		
		
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT "
	        				+ "T1.PRODUCT_ID AS Product_ID, "
	        				+ "T1.ATTRIBUTE_ID AS Attribute_ID, "
	        				+ "T2.NAME AS AttributeName, "
	        				+ "T1.VALUE_ATTR AS Value_ATTR " +
	        		"FROM "
	        			+ "T_PRODUCT_ATTRIBUTE AS T1 "
	        				+ "INNER JOIN "
        				+ "T_ATTRIBUTE AS T2 "
        				+ " ON (T1.ATTRIBUTE_ID = T2.ID) " +
	        		"WHERE T1.ATTRIBUTE_ID = ? ";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a continuación, los parámetros:
	        statement.setLong(1, attributeId);
	        
	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        while (resultSet.next()) 
	        {      
	        	listProductAttribute_Dto.add(new ProductAttribute_Dto(resultSet.getLong("Product_ID"),resultSet.getLong("Attribute_ID"), resultSet.getString("AttributeName"), resultSet.getString("value_ATTR")));
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return listProductAttribute_Dto;
	}
	
}

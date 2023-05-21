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

import com.stocktaking.Entity_DTO.TypeAttribute_Dto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class TypeAttribute_Repository
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
	  INSERT INTO T_TYPEATTRIBUTE  
	  	(TYPE_ID, ATTRIBUTE_ID)
	  VALUES 
	  	(typeId, attributeId)
	*/
	public TypeAttribute_Dto create(Long typeId, Long attributeId) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		{
			// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
			String sql = 
			"INSERT INTO T_TYPEATTRIBUTE " +
			"(TYPE_ID, ATTRIBUTE_ID) " +
			"VALUES (?, ?)";
			  
			PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
			//a continuación, los parámetros:
			statement.setLong(1, typeId);
			statement.setLong(2, attributeId);
		  
			// Ejecutamos el comando, y si el resultado ha dado más de una fila:
			if (statement.executeUpdate() > 0) 
			{
				// Devolvemos el nuevo registro creado.
				return new TypeAttribute_Dto(typeId, attributeId);
			}
		} 
		catch (Exception e) // Si algo del try falla:
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		return null;
	}


	


	/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
	Método para la consultar con TypeId:
	"SELECT * " +
	"FROM T_TYPEATTRIBUTE " +
	"WHERE TYPE_ID = ? "
	*/
	public List<TypeAttribute_Dto> findByTypeId(Long typeId) 
	{
		List<TypeAttribute_Dto> listTypeAttribute_Dto = new ArrayList<TypeAttribute_Dto>();
		
		
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT * " +
	        		"FROM T_TYPEATTRIBUTE " +
	        		"WHERE TYPE_ID = ? ";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a continuación, los parámetros:
	        statement.setLong(1, typeId);
	        
	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        while (resultSet.next()) 
	        {      
	        	listTypeAttribute_Dto.add(new TypeAttribute_Dto(resultSet.getLong("Type_ID"),resultSet.getLong("Attribute_ID")));
	        	
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return listTypeAttribute_Dto;
	}

	/*Método para la consultar con AttributeId:
	"SELECT * " +
	"FROM T_TYPEATTRIBUTE " +
	"WHERE ATTRIBUTE_ID = ? "
	*/
	public List<TypeAttribute_Dto> findByAttributeId(Long attributeId) 
	{
		List<TypeAttribute_Dto> listTypeAttribute_Dto = new ArrayList<TypeAttribute_Dto>();
		
		
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT * " +
	        		"FROM T_TYPEATTRIBUTE " +
	        		"WHERE ATTRIBUTE_ID = ? ";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a continuación, los parámetros:
	        statement.setLong(1, attributeId);
	        
	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        while (resultSet.next()) 
	        {      
	        	listTypeAttribute_Dto.add(new TypeAttribute_Dto(resultSet.getLong("Type_ID"),resultSet.getLong("Attribute_ID")));
	        	
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return listTypeAttribute_Dto;
	}

	/*
	Método para la consultar Todos
	"SELECT * " +
	"FROM T_TYPEATTRIBUTE "
	*/

	public List<TypeAttribute_Dto> findAll() 
	{
		List<TypeAttribute_Dto> listTypeAttribute_Dto = new ArrayList<TypeAttribute_Dto>();
		
		
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT * " +
	        		"FROM T_TYPEATTRIBUTE;";
	        		
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando

	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        while (resultSet.next()) 
	        {      
	        	listTypeAttribute_Dto.add(new TypeAttribute_Dto(resultSet.getLong("Type_ID"),resultSet.getLong("Attribute_ID")));
	        	
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return listTypeAttribute_Dto;
	}
	
	/*
	Método para la consulta DELETE:
	DELETE FROM T_TYPEATTRIBUTE  
	WHERE
	  	TYPE_ID = typeId AND
	  	ATTRIBUTE_ID = attributeId
	*/
	public TypeAttribute_Dto delete(Long typeId, Long attributeId) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
			TypeAttribute_Dto entityToDelete = new TypeAttribute_Dto(typeId, attributeId);
		
		// Si se ha encontrado el registro:
		if (entityToDelete != null) 
		{
			// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
			try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		        String sql = 
		        		"DELETE FROM T_TYPEATTRIBUTE " +
						"WHERE " +
		    				"TYPE_ID = ? AND " +
		    				"ATTRIBUTE_ID = ? ";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a conticuación, los parámetros:
		        statement.setLong(1, typeId);
		        statement.setLong(2, attributeId);
		        
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
}

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

import com.stocktaking.Entity_DTO.Bill_Dto;
import com.stocktaking.Entity_DTO.TypeAttribute_Dto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class Bill_Repository
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
	  INSERT INTO T_BILL
	  	(SALE_ID, PRODUCT_ID, CLIENT_ID, quantity)
	  VALUES 
	  	(productId, attributeId, value)
	*/
	public Bill_Dto create(Long saleId, Long productId, Long clientId, Integer quantity) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		{
			// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
          String sql = 
          		"INSERT INTO T_BILL " +
          		"(SALE_ID, PRODUCT_ID, CLIENT_ID, QUANTITY) " +
          		"VALUES (?, ?, ?, ?)";
          
          PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
          //a continuación, los parámetros:
          statement.setLong(1, saleId);
          statement.setLong(2, productId);
          statement.setLong(3, clientId);
          statement.setInt(4, quantity);
          
          // Ejecutamos el comando, y si el resultado ha dado más de una fila:
          if (statement.executeUpdate() > 0) 
          {
          	// Devolvemos el nuevo registro creado.
              return new Bill_Dto(saleId, productId, clientId, quantity);
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
"DELETE FROM T_BILL " +
				"WHERE " +
    				"SALE_ID = ? AND " +
    				"PRODUCT_ID = ? AND " +
    				"CLIENT_ID = ? AND " +
    				"QUANTITY = ? "
*/
public Bill_Dto delete(Long saleId, Long productId, Long clientId, Integer quantity) 
{
// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
// Todas esas configuraciones las pilla directamente del application.properties
	Bill_Dto entityToDelete = new Bill_Dto(saleId, productId, clientId, quantity);

// Si se ha encontrado el registro:
if (entityToDelete != null) 
{
	// El String SQL: Usamos values ? para que se inserten por parámetros 
	// En vez de por concatenación, por seguridad de SQL-injection.
	try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
        String sql = 
        		"DELETE FROM T_BILL " +
				"WHERE " +
    				"SALE_ID = ? AND " +
    				"PRODUCT_ID = ? AND " +
    				"CLIENT_ID = ? AND " +
    				"QUANTITY = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
        //a continuación, los parámetros:
        statement.setLong(1, saleId);
        statement.setLong(2, productId);
        statement.setLong(3, clientId);
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
Método para la consultar con SaleId:
"SELECT * " +
"FROM T_BILL " +
"WHERE SALE_ID = ? "
*/

public List<Bill_Dto> findBySaleId(Long saleId) 
{
	List<Bill_Dto> listBill_Dto = new ArrayList<Bill_Dto>();
	
	
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
    	// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
        String sql = 
        		"SELECT * " +
        		"FROM T_BILL " +
        		"WHERE SALE_ID = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
        //a continuación, los parámetros:
        statement.setLong(1, saleId);
        
        // Almacenamos el resultado en resultSet
        ResultSet resultSet = statement.executeQuery();
        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
        while (resultSet.next()) 
        {      
        	listBill_Dto.add(new Bill_Dto(resultSet.getLong("Sale_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Client_ID"),resultSet.getInt("quantity")));
        	
        }
    } 
    catch (Exception e) // Si algo del try falla:
    {
        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
    }
    return listBill_Dto;
}

/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
Método para la consultar con ProductId:
"SELECT * " +
"FROM T_BILL " +
"WHERE PRODUCT_ID = ? "
*/

public List<Bill_Dto> findByProductId(Long productId) 
{
	List<Bill_Dto> listBill_Dto = new ArrayList<Bill_Dto>();
	
	
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
    	// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
        String sql = 
        		"SELECT * " +
        		"FROM T_BILL " +
        		"WHERE PRODUCT_ID = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
        //a continuación, los parámetros:
        statement.setLong(1, productId);
        
        // Almacenamos el resultado en resultSet
        ResultSet resultSet = statement.executeQuery();
        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
        while (resultSet.next()) 
        {      
        	listBill_Dto.add(new Bill_Dto(resultSet.getLong("Sale_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Client_ID"),resultSet.getInt("quantity")));
        	
        }
    } 
    catch (Exception e) // Si algo del try falla:
    {
        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
    }
    return listBill_Dto;
}


/*COMO VERIFICAMOS SUE EXISTENCIA Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia)
Método para la consultar con ClientId:
"SELECT * " +
"FROM T_BILL " +
"WHERE CLIENT_ID = ? "
*/

public List<Bill_Dto> findByClientId(Long clientId) 
{
	List<Bill_Dto> listBill_Dto = new ArrayList<Bill_Dto>();
	
	
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
    	// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
        String sql = 
        		"SELECT * " +
        		"FROM T_BILL " +
        		"WHERE CLIENT_ID = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
        //a continuación, los parámetros:
        statement.setLong(1, clientId);
        
        // Almacenamos el resultado en resultSet
        ResultSet resultSet = statement.executeQuery();
        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
        while (resultSet.next()) 
        {      
        	listBill_Dto.add(new Bill_Dto(resultSet.getLong("Sale_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Client_ID"),resultSet.getInt("quantity")));
        	
        }
    } 
    catch (Exception e) // Si algo del try falla:
    {
        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
    }
    return listBill_Dto;
}

/*
Método para la consultar Todos
"SELECT * " +
"FROM T_TYPEATTRIBUTE "
*/
public List<Bill_Dto> findOne(Long saleId, Long productId, Long clientId, Integer quantity) 
{
	List<Bill_Dto> bill_Dto = new ArrayList<Bill_Dto>();
	
	
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
    	// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
        String sql = 
        		"SELECT * " +
        		"FROM T_BILL;" +
        		"WHERE SALE_ID = ? AND PRODUCT_ID = ? AND CLIENT_ID = ? AND QUANTITY = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
        //a continuación, los parámetros:
        statement.setLong(1, saleId);
        statement.setLong(2, productId);
        statement.setLong(3, clientId);
        statement.setLong(4, quantity);

        // Almacenamos el resultado en resultSet
        ResultSet resultSet = statement.executeQuery();
        // Si podemos posicionarnos en e	l siguiente registro, empezando desde el principio (Primer registro)
        while (resultSet.next()) 
        {      
        	bill_Dto.add(new Bill_Dto(resultSet.getLong("Sale_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Client_ID"),resultSet.getInt("Quantity")));
        	
        }
    } 
    catch (Exception e) // Si algo del try falla:
    {
        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
    }
    return bill_Dto;
}


/*
Método para la consultar Todos
"SELECT * " +
"FROM T_BILL "
*/
public List<Bill_Dto> findAll() 
{
	List<Bill_Dto> listBill_Dto = new ArrayList<Bill_Dto>();
	
	
	// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
	// Todas esas configuraciones las pilla directamente del application.properties
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
    {
    	// El String SQL: Usamos values ? para que se inserten por parámetros 
		// En vez de por concatenación, por seguridad de SQL-injection.
        String sql = 
        		"SELECT * " +
        		"FROM T_BILL;";
        		
        
        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando

        // Almacenamos el resultado en resultSet
        ResultSet resultSet = statement.executeQuery();
        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
        while (resultSet.next()) 
        {      
        	listBill_Dto.add(new Bill_Dto(resultSet.getLong("Sale_ID"),resultSet.getLong("Product_ID"),resultSet.getLong("Client_ID"),resultSet.getInt("Quantity")));
        	
        }
    } 
    catch (Exception e) // Si algo del try falla:
    {
        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
    }
    return listBill_Dto;
}
	
}

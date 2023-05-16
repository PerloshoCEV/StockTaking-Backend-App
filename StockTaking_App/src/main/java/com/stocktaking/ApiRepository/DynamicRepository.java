package com.stocktaking.ApiRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stocktaking.Response.AttributeValueResponse;
import com.stocktaking.Response.RegDynamicResponse;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class DynamicRepository 
{
    // Obtener la URL de la base de datos del archivo application.properties
    @Value("${spring.datasource.url}")
    private String dbUrl; 
    
    // Obtener el nombre de usuario de la base de datos del archivo application.properties
    @Value("${spring.datasource.username}")
    private String dbUsername;

    // Obtener la contraseña de la base de datos del archivo application.properties
    @Value("${spring.datasource.password}")
    private String dbPassword;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // Lista de atributos de la tabla T_PRODUCT que queremos seleccionar, con sus valores
    List<AttributeValueResponse> listAttributeValue = new ArrayList<>();
    
    /*
        Método para devolver el DynamicResponse con la tabla de un producto con todos sus campos:
    */
    public RegDynamicResponse getProductById(Long id) 
    {
        RegDynamicResponse result = null;
        try
        {
        	listAttributeValue = new ArrayList<>();
            
            // Añado a listAttributeValue todas las entradas que devuelve getBaseAttributeValue 
            listAttributeValue.addAll(getBaseAttributeValue(id));
            listAttributeValue.addAll(getAddedAttributeValue(id));
            
            result = new RegDynamicResponse(id, listAttributeValue);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
        return result;
    }
    
    /*
        Método para obtener la lista de atributos a añadir al producto:
    */
    private List<AttributeValueResponse> getBaseAttributeValue(Long idProduct) 
    {
        List<AttributeValueResponse> baseAttributeValue = new ArrayList<>();
        
        // Declarar variable resultQuery para capturar el resultado de las consultas.
        Map<String, Object> resultQuery = null;
        // Declarar la variable params 
        Map<String, Object> params = null;
        
        // Declarar String de consulta para conseguir los atributos base de Productos para el idProduct.
        // capturando: (name, description, stock)
        String query = "SELECT p.name, p.description, p.stock " +
                "FROM T_Product p " +
                "WHERE p.id = :idProduct";
        
        // Preparo parems mara mapear:
        params = new HashMap<>();
        params.put("idProduct", idProduct);
        // resultQuery = resultado de la consulta
        resultQuery = jdbcTemplate.queryForMap(query, params);

        // Añadir a baseAttribute:
        // add -> new AttributeValueResponse ("Name", resultQuery.name);
        baseAttributeValue.add(new AttributeValueResponse("Name", (String) resultQuery.get("name")));
        // add -> new AttributeValueResponse ("Description", resultQuery.description);
        baseAttributeValue.add(new AttributeValueResponse("Description", (String) resultQuery.get("description")));
        // add -> new AttributeValueResponse ("stock", resultQuery.stok);
        baseAttributeValue.add(new AttributeValueResponse("stock", resultQuery.get("stock").toString()));
        
        return baseAttributeValue;
    }
    
    private List<AttributeValueResponse> getAddedAttributeValue(Long idProduct) 
    {
    	List<AttributeValueResponse> addedAttributeValues = new ArrayList<>();
    	// Declarar variable resultQuery para capturar el resultado de las consultas.
    	List<Map<String, Object>> results = null;
        // Declarar la variable params 
        Map<String, Object> params = null;
        
        // Declarar String de consulta para conseguir del join de (T_ProductAttribute, T_Attribute), 
        //los datos (Id_Attribute,Nombre de atributo y value) Para el producto idProduct
        String query = "SELECT a.id, a.name, pa.value " +
                "FROM ProductAttribute pa " +
                "JOIN Attribute a ON a.id = pa.attribute_id " +
                "WHERE pa.product_id = :idProduct";
        
        // Preparo parems mara mapear:
        params = new HashMap<>();
        params.put("idProduct", idProduct);
        
        // resultQuery = resultado de la consulta
        results = jdbcTemplate.queryForList(query, params);
        
        // como esta consulta puede tener varias entradas, realizo un bucle de todas las entradas de resultQuery
        for (Map<String, Object> row : results) 
        {
        	// Voy añadiendo en cada iteración, cada entrada en AttributeValueResponse 
        	// add -> AttributeValueResponse (Id_Attribute, Nombre de atributo y value)
            Long attributeId = (Long) row.get("id");
            String attributeName = (String) row.get("name");
            String attributeValue = (String) row.get("value");
            addedAttributeValues.add(new AttributeValueResponse(attributeId, attributeName, attributeValue));
        }
    	return addedAttributeValues;
    }
    

    /*
      Método para generar la tabla con todos los atributos de un producto:
    */
    private RegDynamicResponse generateDynamicTable(Long idProduct, List<AttributeValueResponse> attributeValues) 
    {
        RegDynamicResponse result = null;
        // generar la tabla dinámica aquí
        return result;
    }
}


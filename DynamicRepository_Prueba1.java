@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class DynamicRepository 
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
	
	@Autowired
	private DataSource dataSource;
	
	// Lista de atributos de la tabla T_PRODUCT que queremos seleccionar
    private List<String> productFields = Arrays.asList("ID", "DESCRIPTION", "NAME", "STOCK");
    private List<String> attributeFields = new ArrayList<String>();
	
	/*
		Método para devolver el DynamicResponse con la tabla de un producto con todos sus campos:
	*/
	public DynamicResponse GetProductById (Long id)
	{
		DynamicResponse result = null;
		
		try 
		{
			this.attributeFields = this.getAttributeNames(id);
			
			result = this.generateDynamicTable(id, attributeFields);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return result;			
		
	}
	
	/*
		Método para obtener la lista de atributos a añadir al producto:
	*/
	private List<String> getAttributeNames(Long idProduct) 
	{
	    List<String> attributeFields = new ArrayList<String>();

	 // Consulta SQL para buscar los atributos del producto
	    String attributeQuery = "SELECT DISTINCT a.NAME " +
	                            "FROM T_PRODUCT_ATTRIBUTE pa " +
	                            "JOIN T_ATTRIBUTE a ON pa.ATTRIBUTE_ID = a.ID " +
	                            "WHERE pa.PRODUCT_ID = ?";

	    // Crear instancia de JdbcTemplate con el DataSource que estés usando
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	    // Ejecutar la consulta attributeQuery con el ID del producto como parámetro
	    List<Map<String, Object>> attributes = jdbcTemplate.queryForList(attributeQuery, idProduct);

	    // Iterar por cada mapa en la lista devuelta y obtener el nombre de cada atributo para agregarlo a attributeFields
	    for (Map<String, Object> attribute : attributes) 
	    {
	        attributeFields.add(attribute.get("NAME").toString());
	    }

	    return attributeFields;
	}

	/*
	  Método para generar la tabla con todos los atributos de un producto :

	*/
	private DynamicResponse generateDynamicTable(Long idProduct, List<String> attributeFields) 
	{
	    DynamicResponse result = null;

	    String sql = "SELECT p." + String.join(", p.", this.productFields) +
                ", " + String.join(", ", attributeFields.stream().map(a -> "a." + a + " AS " + a).collect(Collectors.toList())) +
                ", " + String.join(", ", attributeFields.stream().map(a -> "pa." + a + " AS " + a).collect(Collectors.toList())) +
                " FROM T_PRODUCT p " +
                " JOIN T_PRODUCT_ATTRIBUTE pa ON p.ID = pa.PRODUCT_ID " +
                " JOIN T_ATTRIBUTE a ON pa.ATTRIBUTE_ID = a.ID " +
                " WHERE p.ID = ?";

	    // Crear instancia de JdbcTemplate con el DataSource que estés usando
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	    // Ejecutar la consulta SQL dinámica con el ID del producto como parámetro
	    List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql, idProduct);

	    // Crear la lista de nombres de campos para la respuesta
	    List<String> responseFields = new ArrayList<String>();
	    responseFields.addAll(productFields);
	    responseFields.addAll(attributeFields);
	    responseFields.addAll(attributeFields);

	    // Crear la instancia de DynamicResponse con los resultados de la consulta y los nombres de campos
	    result = new DynamicResponse(queryResult, responseFields);

	    return result;
	}
}

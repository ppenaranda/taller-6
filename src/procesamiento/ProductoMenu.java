/**
 * 
 */
package procesamiento;

/**
 * @author kaelt
 *
 */
public class ProductoMenu implements Producto {

	/**
	 * 
	 */
	//Atributos
	private String nombre;
	
	private int precioBase;
	
	
	//constructor
	public ProductoMenu(String name, int basePrice) {
		// TODO Auto-generated constructor stub
		this.precioBase=basePrice;
		this.nombre=name;
		
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

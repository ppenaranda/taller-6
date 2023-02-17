/**
 * 
 */
package procesamiento;

/**
 * @author kaelt
 *
 */
public class Ingrediente {

	/**
	 * 
	 */
	
	private String nombre;
	
	private int costoAdicional;
	
	
	public Ingrediente(String nombre, int precioBase) {
		// TODO Auto-generated constructor stub
		
		this.nombre = nombre;
		this.costoAdicional = precioBase;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecioBase() {
		return costoAdicional;
	}
	
	

}

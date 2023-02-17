package procesamiento;

import java.util.ArrayList;

public class Combo implements Producto{
	
	
	//Atributos
	private int descuento;
	
	private String nombre;
	
	private ArrayList<String> comboNombre;
	
	private ArrayList<Producto> comboReal;
	
	public Combo(String nombre, int descuento, String p1, String p2, String p3) {
		this.nombre = nombre;
		this.descuento = descuento;
		ArrayList<String> elComboNombre = new ArrayList<String>();
		elComboNombre.add(p1);
		elComboNombre.add(p2);
		elComboNombre.add(p3);
		this.comboNombre = elComboNombre;
		this.comboReal = new ArrayList<Producto>();
	}
	
	
	@Override
	public double getPrecio() {
	    double precioNeto = 0;
	    for (Producto producto : comboReal) {
	        precioNeto += producto.getPrecio();
	    }
	    
	    double precioConDescuento = (double) (precioNeto * (1 - descuento/100.0));
	    return precioConDescuento;
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
	
	public ArrayList<String> getComboNombre(){
		return comboNombre;
	}
	
	public void agregarItem(Producto itemCombo) {
		comboReal.add(itemCombo);
	}

}

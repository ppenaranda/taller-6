package procesamiento;

import java.util.ArrayList;

public class Combo implements Producto{
	
	
	//Atributos
	private double descuento;
	
	private String nombre;
	
	private ArrayList<Producto> combo;
	
	public Combo(String nombre, double descuento, Producto p1, Producto p2, Producto p3) {
		this.nombre = nombre;
		this.descuento = descuento;
		ArrayList<Producto> elCombo = new ArrayList<Producto>();
		elCombo.add(p1);
		elCombo.add(p2);
		elCombo.add(p3);
		this.combo = elCombo;
	}
	
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precio;
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
	
	public void agregarItem(Producto itemCombo) {
		
		
	}

}

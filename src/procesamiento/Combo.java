package procesamiento;

import java.util.ArrayList;

public class Combo implements Producto{
	
	
	//Atributos
	private int descuento;
	
	private String nombre;
	
	private ArrayList<String> combo;
	
	public Combo(String nombre, int descuento, String p1, String p2, String p3) {
		this.nombre = nombre;
		this.descuento = descuento;
		ArrayList<String> elCombo = new ArrayList<String>();
		elCombo.add(p1);
		elCombo.add(p2);
		elCombo.add(p3);
		this.combo = elCombo;
	}
	
	
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return descuento;
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

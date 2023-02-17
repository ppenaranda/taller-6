package procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Restaurante {
	
	private ArrayList<ProductoMenu> menuBase;
	
	private ArrayList<Combo> combos;
	
	private ArrayList<Ingrediente> ingredientes;
	
	private HashMap<Integer, Pedido> pedidos;
	
	public Restaurante() {
		this.menuBase = new ArrayList<ProductoMenu>();
		this.combos = new ArrayList<Combo>();
		this.ingredientes = new ArrayList<Ingrediente>();
		this.pedidos = new HashMap<Integer, Pedido>();
		
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido pedido = new Pedido(nombreCliente, direccionCliente);
		pedidos.put(pedido.getIdPedido(), pedido);
		
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	public Pedido getPedidoEnCurso() {
		Pedido pedido = pedidos.get(Pedido.getPedidoNum());
		return pedido;
	}
	
	public ArrayList<ProductoMenu> getMenuBase(){
		return menuBase;
		
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return ingredientes;
	}
	
	public ArrayList<Combo> getCombos(){
		return combos;	
	}
	
	
	public void crearCombos() {
		for (Combo combo: combos) {
			ArrayList<String> comboNombre = combo.getComboNombre();
			for (String productoNombre : comboNombre) {
				for (Producto producto : menuBase) {
					if(productoNombre.equals(producto.getNombre())) {
						combo.agregarItem(producto);
					}
				}
			}
			
		}
		
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		crearCombos();
	}
	
	private void cargarIngredientes(File archivoIngredientes) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int costoAd = Integer.parseInt(partes[1]);
			
			
			Ingrediente ingredienteNuevo = new Ingrediente(nombreIngrediente, costoAd);
			ingredientes.add(ingredienteNuevo);
			linea = br.readLine();
			}
		br.close();
		
			
			
			
		}
		
		
	
		
	
	
	private void cargarMenu(File archivoMenu) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			int precioProducto = Integer.parseInt(partes[1]);
			
			
			ProductoMenu ProductoNuevoMenu = new ProductoMenu(nombreProducto, precioProducto);
			menuBase.add(ProductoNuevoMenu);
			linea = br.readLine();
			}
		br.close();
	
		}
	
	private void cargarCombos(File archivoCombos) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			
			String nombreCombo = partes[0];
			String descuentoStr = partes[1];
			String descuentoArreglado = descuentoStr.replace("%","");
			int costoDisc = Integer.parseInt(descuentoArreglado);
			String nombreP1 = partes[2];
			String nombreP2 = partes[3];
			String nombreP3 = partes[4];
			
			Combo comboNuevo = new Combo(nombreCombo, costoDisc, nombreP1, nombreP2, nombreP3);
			combos.add(comboNuevo);
			linea = br.readLine();
			}
		br.close();
	
		}
	

}

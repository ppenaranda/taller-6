package procesamiento;
import exceptions.*;
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
	// Se inicializa un restaurante al cual se le van a introducir los datos//
	public Restaurante() {
		this.menuBase = new ArrayList<ProductoMenu>();
		this.combos = new ArrayList<Combo>();
		this.ingredientes = new ArrayList<Ingrediente>();
		this.pedidos = new HashMap<Integer, Pedido>();
		
		
	}
	// Indica el inicio de un pedido//
	public void iniciarPedido(String nombreCliente, String direccionCliente) throws PedidoSuperadoException {
	    Pedido pedido = new Pedido(nombreCliente, direccionCliente);
	    if (pedido.getPrecioNetoPedido() > 150000) {
	        throw new PedidoSuperadoException();
	    }
	    pedidos.put(pedido.getIdPedido(), pedido);
	}
	
	public Pedido obtenerPedidoId(int id) {
	    try {
	        Pedido pedido = pedidos.get(id);
	        return pedido;
	    } catch (IndexOutOfBoundsException e) {
	        throw new IllegalArgumentException("No se encontró pedido asignado al ID");
	    }
	}
	
	public void cerrarYGuardarPedido() {
		Pedido pedido = getPedidoEnCurso();
		pedidos.replace(Pedido.getPedidoNum(), pedido);
		String precioTotal = Double.toString(pedido.PrecioTotalPedido());
		String precioNeto = Double.toString(pedido.getPrecioNetoPedido());
		String precioIva = Double.toString(pedido.getPrecioIVAPedido());
		String id = Integer.toString(pedido.getIdPedido());
		System.out.println("El pedido total es:\n");
		ArrayList<Producto> pedidoProductos = pedido.getProductos();
		for (Producto producto : pedidoProductos) {
			System.out.println(producto.getNombre()+ ": $" + Double.toString(producto.getPrecio())+ "\n");
		}
		System.out.println("Valor neto del pedido: $"+ precioNeto + "\n");
		System.out.println("Valor del IVA del 19% del pedido: $"+ precioIva + "\n");
		System.out.println("Valor total del pedido: $"+ precioTotal + "\n");
		System.out.println("ID del pedido: "+ id + "\n");
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
	
	public void agregarComboPedido(int index) throws PedidoSuperadoException {
	    Pedido pedido = getPedidoEnCurso();
	    Combo combo = combos.get(index - 1);
	    pedido.agregarProducto(combo);
	}

	public void agregarProductoPedido(int index) throws PedidoSuperadoException {
	    Pedido pedido = getPedidoEnCurso();
	    ProductoMenu producto = menuBase.get(index - 1);
	    pedido.agregarProducto(producto);
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
	//Se cargan los 3 diferentes archivos desde data//
	//Se crean los combos//
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException, IngredienteRepetidoException, ProductoRepetidoException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		crearCombos();
	}
	
	private void cargarIngredientes(File archivoIngredientes) throws IOException, IngredienteRepetidoException {
	    BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
	    String linea = br.readLine();
	    while (linea != null) {
	        String[] partes = linea.split(";");
	        String nombreIngrediente = partes[0];
	        int costoAd = Integer.parseInt(partes[1]);

	        for (Ingrediente ingrediente : ingredientes) {
	            if (ingrediente.getNombre().equals(nombreIngrediente)) {
	                throw new IngredienteRepetidoException(nombreIngrediente);
	            }
	        }

	        Ingrediente ingredienteNuevo = new Ingrediente(nombreIngrediente, costoAd);
	        ingredientes.add(ingredienteNuevo);
	        linea = br.readLine();
	    }
	    br.close();
	}

	private void cargarMenu(File archivoMenu) throws IOException, ProductoRepetidoException {
	    BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
	    String linea = br.readLine();
	    while (linea != null) {
	        String[] partes = linea.split(";");
	        String nombreProducto = partes[0];
	        int precioProducto = Integer.parseInt(partes[1]);

	        for (ProductoMenu producto : menuBase) {
	            if (producto.getNombre().equals(nombreProducto)) {
	                throw new ProductoRepetidoException(nombreProducto);
	            }
	        }

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

package consola;
import procesamiento.Restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import procesamiento.Combo;
import procesamiento.Ingrediente;
import procesamiento.Pedido;
import procesamiento.Producto;
import procesamiento.ProductoAjustado;
import procesamiento.ProductoMenu;


public class Aplicacion {
	
	private Restaurante restaurante;
	
	private Aplicacion() {
		this.restaurante = new Restaurante();
	}
	
	// Se ejecuta la aplicación y da comienzo a la consola//
	public void ejecutarAplicacion() throws IOException {
		System.out.println("Bienvenido al menú de restaurante\n");
		File fileIngrediente = new File("data/ingredientes.txt");
		File fileMenu = new File("data/menu.txt");
		File fileCombo = new File("data/combos.txt");
		restaurante.cargarInformacionRestaurante(fileIngrediente,fileMenu, fileCombo);
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				System.out.println("");
				if (opcion_seleccionada == 1) {
					ejecutarIniciarPedido();
					boolean continuar1 = true;
					while (continuar1)
					{
						try
						{
							mostrarMenuPedido();
							int opcion_seleccionada1 = Integer.parseInt(input("Por favor seleccione una opción"));
							if (opcion_seleccionada1 == 1) {
								
							boolean continuar2 = true;
							while (continuar2) 
							{
								try
								{
									mostrarMenuElementos();
									int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
									if (opcion_seleccionada2 == 1) {
										mostrarCombos();
										int comboOpcion = Integer.parseInt(input("Por favor seleccione un combo"));
										restaurante.agregarComboPedido(comboOpcion);
									}
									else if (opcion_seleccionada2 == 2) {
										mostrarProductos();
										int prodOpcion = Integer.parseInt(input("Por favor seleccione un producto"));
										restaurante.agregarProductoPedido(prodOpcion);
									}
									else if (opcion_seleccionada2 == 3) {
										System.out.print("Lo sentimos, esta opción aún no está habilitada\n");
									}
									else if (opcion_seleccionada2 == 4) {
										continuar2 = false;
									}
									
								}
								catch (NumberFormatException e)
								{
									System.out.println("Debe seleccionar uno de los números de las opciones.");
								}
							}
							
							}
							
							if (opcion_seleccionada1 == 2) {
								ejecutarCerrarYGuardarPedido();
								continuar1 = false;
							}
						}
						
						catch (NumberFormatException e)
						{
							System.out.println("Debe seleccionar uno de los números de las opciones.");
						}
					}	
						
					
					
				}
				else if (opcion_seleccionada == 2)
				{
					int id = Integer.parseInt(input("Ingrese id del pedido a consultar"));
					ejecutarObtenerPedidoId(id);

				}
				else if (opcion_seleccionada == 3)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public void mostrarMenu() {
		System.out.println("1. Iniciar pedido");
		System.out.println("2. Consultar pedido por ID");
		System.out.println("3. Salir");
	}
	
	public void mostrarMenuPedido() {
		System.out.println("1. Agregar elemento al pedido");
		System.out.println("2. Cerrar pedido");
	}
	
	public void mostrarMenuElementos() {
		System.out.println("1. Agregar combo");
		System.out.println("2. Agregar producto del menú");
		System.out.println("3. Agregar ingrediente");
		System.out.println("4. No agregar más elementos al pedido");
		
	}
	//Muestra la lista de los combos del restaurante//
	public void mostrarCombos() {
		ArrayList<Combo> combos = restaurante.getCombos();
		int pos = 0;
		for (Combo combo: combos) {
			pos++;
			String position = Integer.toString(pos);
			String comboNombre = combo.getNombre();
			String comboValor = Double.toString(combo.getPrecio());
			System.out.println("-----------------------------");
			System.out.println(position+". Combo: "+comboNombre);
			System.out.println("Valor: "+comboValor);
			System.out.println("-----------------------------");
			}
		}
	// Muestra la lista de los productos del restaurante//	
	public void mostrarProductos() {
		ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
		int pos = 0;
		for (ProductoMenu prod: menu) {
			pos++;
			String position = Integer.toString(pos);
			String prodNombre = prod.getNombre();
			String prodValor = Double.toString(prod.getPrecio());
			System.out.println("-----------------------------");
			System.out.println(position+". Producto: "+prodNombre);
			System.out.println("Valor: "+prodValor);
			System.out.println("-----------------------------");
			}
	}
	//
	public void mostrarIngerdientes() {
		ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
		int pos = 0;
		for (Ingrediente ingrediente: ingredientes) {
			pos++;
			String position = Integer.toString(pos);
			String ingredienteNombre = ingrediente.getNombre();
			String ingredienteValor = Double.toString(ingrediente.getPrecioBase());
			System.out.println("-----------------------------");
			System.out.println(position+". Ingrediente: "+ingredienteNombre);
			System.out.println("Valor: "+ingredienteValor);
			System.out.println("-----------------------------");
			}
	}
	// Se encarga de obtener y mostrar información sobre un pedido específico identificado por su ID.//
	public void ejecutarObtenerPedidoId(int index) {
	    try {
	        Pedido pedido = restaurante.obtenerPedidoId(index);
	        if (pedido != null) {
	        	String nombre = pedido.getNombreCliente();
	        	String direccion = pedido.getDireccionCliente();
	        	double valorTotal = pedido.PrecioTotalPedido();
	        	ArrayList<Producto> pedidoProductos = pedido.getProductos();
	    		for (Producto producto : pedidoProductos) {
	    			System.out.println(producto.getNombre()+"\n");
	    		}
	            System.out.println("Creador del pedido: " + nombre + "\n");
	            System.out.println("Dirección del pedido: "+ direccion + "\n");
	            System.out.println("Valor total del pedido con IVA incluido: " + valorTotal + "\n");
	            System.out.println("ID del pedido: "+ Integer.toString(index) + "\n");
	        } else {
	            System.out.println("No se encontró el pedido\n");
	        }
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al obtener el pedido: " + e.getMessage());
	    }
	}
	public void ejecutarIniciarPedido() {
		String nombre = input("Ingrese su nombre por favor ");
		String direccion = input("Ingrese su dirección por favor ");
		restaurante.iniciarPedido(nombre, direccion);
	}
	public void ejecutarCerrarYGuardarPedido() {
		restaurante.cerrarYGuardarPedido();
	}
	
	
	public void ejecutarOpcion(int opcionSeleccionada) {
		
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		
		

	}

}

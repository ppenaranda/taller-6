package consola;
import procesamiento.Restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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
				if (opcion_seleccionada == 1) {
					boolean continuar1 = true;
					while (continuar1)
					{
						try
						{
							mostrarMenuPedido();
						}
						
						catch (NumberFormatException e)
						{
							System.out.println("Debe seleccionar uno de los números de las opciones.");
						}
					}	
						
					
					
				}
				else if (opcion_seleccionada == 2)
				{

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
	}
	
	public void mostrarMenuPedido() {
		System.out.println("1. Agregar elemento al pedido");
		System.out.println("2. Cerrar pedido");
	}
	
	public void mostrarMenuElementos() {
		System.out.println("1. Agregar combo");
		System.out.println("2. Agregar producto del menú");
		System.out.println("1. Agregar ingrediente");
		
	}
	public void ejecutarIniciarPedido() {
		
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

package consola;
import procesamiento.Restaurante;

import java.io.File;
import java.io.IOException;

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
		mostrarMenu();
		
	}
	
	public void mostrarMenu() {
		System.out.println("1. Iniciar pedido");
		System.out.println("2. Consultar pedido por ID");
		System.out.println("hola");
	}
	
	
	public void ejecutarOpcion(int opcionSeleccionada) {
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		
		

	}

}

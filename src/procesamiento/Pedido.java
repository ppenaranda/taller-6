package procesamiento;

import java.util.ArrayList;

public class Pedido {
	private static int numeroPedidos = 0;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> pedidoProductos;
	
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.pedidoProductos = new ArrayList<Producto>();
		numeroPedidos++;
		this.idPedido = numeroPedidos;
	}
	
	public int getIdPedido() {
		return idPedido;
		
	}
	public void agregarProducto(Producto nuevoItem) {
		pedidoProductos.add(nuevoItem);
	}
	public static int getPedidoNum() {
		return numeroPedidos;
	}
	
	
	
	
	//private int getPrecioNetoPedido() {
	
	//}
	
	///private int PrecioTotalPedido() {
		
	///}
	
	//private int getPrecioIVAPedido() {
		
	//}
	
	//private String generarTextoFactura() {
		
	//}
	
	//public 	void guardarFactura(File archivo) {
		
	//}
}

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
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
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
	
	
	public ArrayList<Producto> getProductos(){
		return pedidoProductos;
	}
	
	public double getPrecioNetoPedido() {
		double precioNeto = 0;
		for (Producto producto: pedidoProductos) {
			precioNeto += producto.getPrecio();
		}
		return precioNeto;
	}
	
	public double PrecioTotalPedido() {
		double precioNeto = getPrecioNetoPedido();
		double iva = getPrecioIVAPedido();
		return precioNeto + iva;
	}
	
	public double getPrecioIVAPedido() {
		double precioNeto = getPrecioNetoPedido();
		double iva = (double) (precioNeto*0.19);
		return iva;
	}
	
	
	//public 	void guardarFactura(File archivo) {
		
	//}
}

package procesamiento;

public class Pedido {
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	
	public int getIdPedido() {
		return idPedido;
		
	}
	public void agregarProducto(Producto nuevoItem) {
		
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

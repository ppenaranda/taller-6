package exceptions;

public class ProductoRepetidoException extends HamburguesaException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoRepetidoException(String producto) {
        super("El producto '" + producto + "' está repetido.");
    }
}

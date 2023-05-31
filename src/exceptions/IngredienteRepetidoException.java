package exceptions;

public class IngredienteRepetidoException extends HamburguesaException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IngredienteRepetidoException(String ingrediente) {
        super("El ingrediente '" + ingrediente + "' está repetido.");
    }
}
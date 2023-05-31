package exceptions;

public class PedidoSuperadoException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PedidoSuperadoException() {
        super("El pedido ha superado el valor máximo permitido de 150.000 pesos.");
    }
}
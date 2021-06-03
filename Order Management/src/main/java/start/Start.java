package start;

import presentation.ClientView;
import presentation.Controller;
import presentation.OrderView;
import presentation.ProductView;

/**
 * Clasa care contine metoda MAIN.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class Start {
    /**
     * Metoda MAIN contine instantieri ale claselor responsabil de interfata aplicatiei si instantierea controller-ului.
     *
     * @param args Parametrul specific metodei MAIN.
     */
    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();
        Controller controller = new Controller(clientView, productView, orderView);
        clientView.setVisible(true);
        productView.setVisible(true);
        orderView.setVisible(true);
    }

}

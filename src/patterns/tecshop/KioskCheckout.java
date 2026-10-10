package tecshop;

// In-store kiosk checkout. Copied from WebCheckout and adjusted.
public class KioskCheckout {
    private final CheckoutService service = new CheckoutService("local", "SINPE Movil");

    public void buy(Cart cart, String customer, String city) {
        service.buy(cart, customer, city);
    }
}

package tecshop;

// Online store checkout.
public class WebCheckout {
    private final CheckoutService service = new CheckoutService("correos", "credit card");

    public void buy(Cart cart, String customer, String city) {
        service.buy(cart, customer, city);
    }
}

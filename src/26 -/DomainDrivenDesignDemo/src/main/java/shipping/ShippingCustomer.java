package shipping;

public class ShippingCustomer {

    private Long id;
    private String deliveryAddress;

    public ShippingCustomer(Long id,
                            String deliveryAddress) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
    }
}
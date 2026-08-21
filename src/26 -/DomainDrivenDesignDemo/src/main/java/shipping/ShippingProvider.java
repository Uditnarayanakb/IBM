package shipping;

import billing.ShippingService;

public class ShippingProvider
        implements ShippingService {

    @Override
    public void shipCustomer(String customerName) {

        System.out.println(
                "Shipping order for "
                        + customerName
        );
    }
}
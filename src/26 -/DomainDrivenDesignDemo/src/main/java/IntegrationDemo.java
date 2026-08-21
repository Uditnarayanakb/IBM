import acl.CustomerTranslator;
import billing.BillingCustomer;
import billing.ShippingService;
import legacy.LegacyCustomerRecord;
import shipping.ShippingProvider;

public class IntegrationDemo {

    public static void main(String[] args) {

        // Billing ↔ Shipping Integration

        BillingCustomer customer =
                new BillingCustomer(
                        101L,
                        "John",
                        "Bangalore"
                );

        ShippingService service =
                new ShippingProvider();

        service.shipCustomer(
                customer.getName()
        );

        System.out.println();

        // Anti-Corruption Layer

        LegacyCustomerRecord legacy =
                new LegacyCustomerRecord(
                        "500",
                        "Old Customer"
                );

        CustomerTranslator acl =
                new CustomerTranslator();

        BillingCustomer modernCustomer =
                acl.convert(legacy);

        System.out.println(
                "Legacy customer converted successfully"
        );

        System.out.println(
                "Customer Name: "
                        + modernCustomer.getName()
        );
    }
}
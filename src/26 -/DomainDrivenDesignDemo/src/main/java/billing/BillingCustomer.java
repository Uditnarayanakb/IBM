package billing;

public class BillingCustomer {

    private Long id;
    private String name;
    private String billingAddress;

    public BillingCustomer(Long id,
                           String name,
                           String billingAddress) {
        this.id = id;
        this.name = name;
        this.billingAddress = billingAddress;
    }

    public String getName() {
        return name;
    }
}

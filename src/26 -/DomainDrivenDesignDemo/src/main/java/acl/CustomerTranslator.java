package acl;

import billing.BillingCustomer;
import legacy.LegacyCustomerRecord;

public class CustomerTranslator {

    public BillingCustomer convert(
            LegacyCustomerRecord legacy) {

        return new BillingCustomer(
                Long.parseLong(
                        legacy.getCustomerCode()
                ),
                legacy.getFullName(),
                "Unknown Address"
        );
    }
}
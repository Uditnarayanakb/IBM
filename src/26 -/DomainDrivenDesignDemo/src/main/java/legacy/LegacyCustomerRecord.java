package legacy;

public class LegacyCustomerRecord {

    private String customerCode;
    private String fullName;

    public LegacyCustomerRecord(String customerCode,
                                String fullName) {

        this.customerCode = customerCode;
        this.fullName = fullName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getFullName() {
        return fullName;
    }
}
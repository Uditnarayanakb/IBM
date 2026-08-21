package order;

import java.math.BigDecimal;

public class OrderLine {

    private String product;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderLine(String product,
                     int quantity,
                     BigDecimal unitPrice) {

        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineTotal() {
        return unitPrice.multiply(
                BigDecimal.valueOf(quantity)
        );
    }
}
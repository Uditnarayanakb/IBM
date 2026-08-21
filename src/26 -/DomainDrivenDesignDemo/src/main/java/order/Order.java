package order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long orderId;

    private List<OrderLine> lines =
            new ArrayList<>();

    private Money total =
            new Money(BigDecimal.ZERO, "USD");

    public Order(Long orderId) {
        this.orderId = orderId;
    }

    public void addOrderLine(OrderLine line) {
        lines.add(line);
        recalculateTotal();
    }

    private void recalculateTotal() {

        BigDecimal sum = BigDecimal.ZERO;

        for (OrderLine line : lines) {
            sum = sum.add(line.getLineTotal());
        }

        total = new Money(sum, "USD");
    }

    public Money getTotal() {
        return total;
    }
}
package order;

import java.math.BigDecimal;

public class OrderTest {

    public static void main(String[] args) {

        Order order = new Order(1L);

        order.addOrderLine(
                new OrderLine(
                        "Laptop",
                        2,
                        new BigDecimal("500")
                )
        );

        order.addOrderLine(
                new OrderLine(
                        "Mouse",
                        1,
                        new BigDecimal("50")
                )
        );

        System.out.println(
                "Order Total = "
                        + order.getTotal()
        );

        Money money1 =
                new Money(
                        new BigDecimal("100"),
                        "USD"
                );

        Money money2 =
                new Money(
                        new BigDecimal("100"),
                        "USD"
                );

        System.out.println(
                "Money Equal? "
                        + money1.equals(money2)
        );
    }
}
import React from "react";
import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import { Provider } from "react-redux";
import { configureStore } from "./store";
import App from "./App";

describe("BalanceControls integration", () => {
  test("deposit button increases balance and withdraw respects overdraft prevention", async () => {
    const store = configureStore({ balance: 10 });
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );

    // initial balance
    expect(screen.getByText(/Current Balance :/)).toHaveTextContent("₹10");

    // clicking withdraw ₹200 should be ignored because balance < 200
    const withdrawBtn = screen.getByRole("button", { name: /Withdraw ₹200/ });
    await userEvent.click(withdrawBtn);
    expect(screen.getByText(/Current Balance :/)).toHaveTextContent("₹10");

    // clicking deposit ₹500 should increase balance
    const depositBtn = screen.getByRole("button", { name: /Deposit ₹500/ });
    await userEvent.click(depositBtn);
    expect(screen.getByText(/Current Balance :/)).toHaveTextContent("₹510");

    // now withdraw ₹200 should succeed
    await userEvent.click(withdrawBtn);
    expect(screen.getByText(/Current Balance :/)).toHaveTextContent("₹310");
  });
});

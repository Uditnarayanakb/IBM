import { configureStore } from "./store";

describe("bankReducer/store behavior", () => {
  test("deposit increases balance when payload is valid", () => {
    const store = configureStore();
    expect(store.getState().balance).toBe(10);
    store.dispatch({ type: "DEPOSIT", payload: 50 });
    expect(store.getState().balance).toBe(60);
  });

  test("withdraw decreases balance when funds are sufficient", () => {
    const store = configureStore({ balance: 100 });
    store.dispatch({ type: "WITHDRAW", payload: 40 });
    expect(store.getState().balance).toBe(60);
  });

  test("withdraw is ignored when funds are insufficient (overdraft prevented)", () => {
    const store = configureStore({ balance: 100 });
    store.dispatch({ type: "WITHDRAW", payload: 200 });
    expect(store.getState().balance).toBe(100);
  });

  test("invalid (non-numeric or negative) deposit is ignored", () => {
    const store = configureStore({ balance: 20 });
    store.dispatch({ type: "DEPOSIT", payload: "abc" });
    expect(store.getState().balance).toBe(20);
    store.dispatch({ type: "DEPOSIT", payload: -10 });
    expect(store.getState().balance).toBe(20);
  });

  test("unknown actions leave state unchanged", () => {
    const store = configureStore({ balance: 5 });
    store.dispatch({ type: "UNKNOWN_ACTION", payload: 1000 });
    expect(store.getState().balance).toBe(5);
  });
});

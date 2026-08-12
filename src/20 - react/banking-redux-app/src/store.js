import { legacy_createStore as createStore } from "redux";

const initialState = {
  balance: 10
};

export function bankReducer(state = initialState, action) {
  switch (action.type) {
    case "DEPOSIT": {
      const amount = action.payload;
      if (typeof amount !== "number" || isNaN(amount) || amount <= 0) return state;
      return {
        ...state,
        balance: state.balance + amount
      };
    }

    case "WITHDRAW": {
      const amount = action.payload;
      if (typeof amount !== "number" || isNaN(amount) || amount <= 0) return state;
      // prevent overdraft
      if (amount > state.balance) return state;
      return {
        ...state,
        balance: state.balance - amount
      };
    }

    default:
      return state;
  }
}

export function configureStore(preloadedState) {
  return createStore(bankReducer, preloadedState);
}

// default store for app runtime
const store = configureStore();

export default store;
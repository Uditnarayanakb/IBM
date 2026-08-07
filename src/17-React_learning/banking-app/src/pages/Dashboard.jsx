import {
  useReducer,
  useEffect,
  useMemo
} from "react";

import Account from "../components/Account";
import TransactionForm from "../components/TransactionForm";
import TransactionHistory from "../components/TransactionHistory";
import { BankContext } from "../components/BankContext";
import "../components/Accounts.css";

const initialState = {
  balance: 500,
  transactions: [],
};

function reducer(state, action) {
  switch (action.type) {
    case "DEPOSIT":
      return {
        balance: state.balance + action.amount,
        transactions: [
          ...state.transactions,
          {
            type: "Deposit",
            amount: action.amount,
            remainingBalance:
              state.balance + action.amount,
          },
        ],
      };

    case "WITHDRAW":
      return {
        balance: state.balance - action.amount,
        transactions: [
          ...state.transactions,
          {
            type: "Withdraw",
            amount: action.amount,
            remainingBalance:
              state.balance - action.amount,
          },
        ],
      };

    default:
      return state;
  }
}

function Dashboard() {
  const [state, dispatch] =
    useReducer(reducer, initialState);   // reducer 

  useEffect(() => {
    document.title =
      `UN Bank | ₹${state.balance}`;
  }, [state.balance]);

  const totalTransactions = useMemo(() => {
    return state.transactions.length;
  }, [state.transactions]);

  return (
    <BankContext.Provider
      value={{ bankName: "UN Bank" }}
    >
      <div className="container">
        <div className="card">

          <Account
            balance={state.balance}
            transactions={totalTransactions}
          />

          <TransactionForm
            balance={state.balance}
            dispatch={dispatch}
          />

          <TransactionHistory
            transactions={state.transactions}
          />

        </div>
      </div>
    </BankContext.Provider>
  );
}

export default Dashboard;
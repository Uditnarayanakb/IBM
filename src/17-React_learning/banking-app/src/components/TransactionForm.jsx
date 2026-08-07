import {
  useState,
  useRef,
  useCallback,
  useId
} from "react";

function TransactionForm({
  balance,
  dispatch,
}) {
  const [amount, setAmount] =
    useState("");

  const inputRef = useRef(null);

  const amountId = useId();

  const depositMoney =
    useCallback(() => {

      const value =
        Number(amount);

      if (value <= 0) {
        alert("Enter Valid Amount");
        return;
      }

      dispatch({
        type: "DEPOSIT",
        amount: value,
      });

      setAmount("");

      inputRef.current.focus();

    }, [amount, dispatch]);

  const withdrawMoney =
    useCallback(() => {

      const value =
        Number(amount);

      if (value <= 0) {
        alert("Enter Valid Amount");
        return;
      }

      if (value > balance) {
        alert("Insufficient Balance");
        return;
      }

      dispatch({
        type: "WITHDRAW",
        amount: value,
      });

      setAmount("");

      inputRef.current.focus();

    }, [amount, balance, dispatch]);

  return (
    <>
      <label htmlFor={amountId}>
        Enter Amount
      </label>

      <input
        id={amountId}
        ref={inputRef}
        type="number"
        className="input"
        value={amount}
        onChange={(e) =>
          setAmount(e.target.value)
        }
      />

      <div className="button-group">

        <button
          className="button"
          onClick={depositMoney}
        >
          Deposit
        </button>

        <button
          className="button"
          onClick={withdrawMoney}
        >
          Withdraw
        </button>

      </div>

      <hr className="divider" />
    </>
  );
}

export default TransactionForm;
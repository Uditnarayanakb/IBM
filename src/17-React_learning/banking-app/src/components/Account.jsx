import { useContext } from "react";
import { BankContext } from "./BankContext";

function Account({
  balance,
  transactions,
}) {
  const { bankName } =
    useContext(BankContext);

  return (
    <>
      <h1 className="title">
        ✦ {bankName}
      </h1>

      <h2 className="balance">
        Current Balance ₹{balance}
      </h2>

      <h3 className="history-count">
        Total Transactions:
        {" "}
        {transactions}
      </h3>

      {balance < 100 ? (
        <h3 className="low-balance">
          ⚠ Low Balance Alert
        </h3>
      ) : (
        <h3 className="healthy">
          ✅ Balance Healthy
        </h3>
      )}
    </>
  );
}

export default Account;
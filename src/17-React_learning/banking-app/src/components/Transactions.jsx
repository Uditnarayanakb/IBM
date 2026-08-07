import { useState } from "react";

function Transactions() {

  const [count, setCount] = useState(2);

  return (
    <div>

      <h2>Transactions</h2>

      <p>Total Transactions: {count}</p>

      <button
        onClick={() =>
          setCount(count + 1)
        }
      >
        Add Transaction
      </button>

    </div>
  );
}

export default Transactions;
import { useDispatch } from "react-redux";

function BalanceControls() {

  const dispatch = useDispatch();

  return (
    <div>

      <button
        onClick={() =>
          dispatch({
            type: "DEPOSIT",
            payload: 500
          })
        }
      >
        Deposit ₹500
      </button>

      <br />
      <br />

      <button
        onClick={() =>
          dispatch({
            type: "WITHDRAW",
            payload: 200
          })
        }
      >
        Withdraw ₹200
      </button>

    </div>
  );
}

export default BalanceControls;
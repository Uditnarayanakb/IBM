import { useSelector } from "react-redux";
import BalanceControls from "./components/BalanceControls";

function App() {

  const balance = useSelector(
    state => state.balance
  );

  return (
    <div style={{ padding: "20px" }}>

      <h1>Banking Application</h1>

      <h2>
        Current Balance : ₹{balance}
      </h2>

      <BalanceControls />

    </div>
  );
}

export default App;
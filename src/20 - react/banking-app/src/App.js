import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import Accounts from "./pages/Accounts";
import About from "./pages/About";

function App() {
  return (
    <Router>
      <div>
        <h1>Banking Application</h1>
        <nav>
          <ul style={{ listStyle: "none", padding: 0, display: "flex", gap: "1rem" }}>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/accounts">Accounts</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/accounts" element={<Accounts />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
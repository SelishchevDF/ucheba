import './App.css';
import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <div>
          <Link to="/index">Главная страница</Link>
          <br />
          <Link to="/about">О нас</Link>
          <Routes>
            <Route path="/index" element={<HomePage />} />
            <Route path="/about" element={<AboutPage />} />
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;

import "./App.css";
import ThemeSwitcher from "./components/ThemeSwitcher";
import { useSelector } from "react-redux";

function App() {
  const theme = useSelector((state) => state.theme); // Получаем текущую тему из Redux

  return (
    <div className={`App ${theme}-theme`}>
      <ThemeSwitcher />
    </div>
  )
}

export default App;

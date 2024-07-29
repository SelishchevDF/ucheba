import { useSelector, useDispatch } from "react-redux";
import { toggleTheme } from "../redux/themeActions";

const ThemeSwitcher = () => {
  const theme = useSelector((state) => state.theme);
  const dispatch = useDispatch();

  return (
    <div>
      Текущая - {theme}
      <button
        onClick={() => dispatch(toggleTheme())}
      >
        Переключить
      </button>
    </div>
  );
};

export default ThemeSwitcher;
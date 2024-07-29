import { TOGGLE_THEME } from "./themeActions";

const initial = {
  theme: "light",
};

function themeReducer (state = initial, action) {
  switch (action.type) {
    case TOGGLE_THEME:
      return {
        ...state,
        theme: state.theme === "light" ? "dark" : "light",
      };
    default:
      return state;
  }
};

export default themeReducer;
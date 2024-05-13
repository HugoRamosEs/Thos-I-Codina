import styles from "./MainMenu.module.scss"

import { NavLink, useLocation } from "react-router-dom";

function MainMenu() {
  const location = useLocation();

  return (
    <>
      <nav className={styles.main_menu}>
        <ul>
          <li><NavLink to="/" className={location.pathname === "/" ? styles.active : ""}>HOME</NavLink></li>
          <li><NavLink to="/videochat" className={location.pathname === "/videochat" ? styles.active : ""}>VIDEOCHAT</NavLink></li>
        </ul>
      </nav>
    </>
  );
}

export default MainMenu

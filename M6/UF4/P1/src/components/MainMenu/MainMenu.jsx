import styles from "./MainMenu.module.scss"
import { NavLink, useLocation } from "react-router-dom";

function MainMenu() {
  const location = useLocation();

  return (
    <>
      <nav className={styles.main_menu}>
        <ul>
          <li><NavLink to="/" className={location.pathname === "/" ? styles.active : ""}>HOME</NavLink></li>
          <li><NavLink to="/map" className={location.pathname === "/map" ? styles.active : ""}>MAP</NavLink></li>
        </ul>
      </nav>
    </>
  );
}

export default MainMenu
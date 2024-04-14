import styles from './MainMenu.module.scss'
import LoginContext from '../../context/LoginContext';
import Logout from '../Logout/Logout';
import { NavLink, useLocation } from "react-router-dom";
import { useContext, useEffect } from 'react';

function MainMenu() {
  const location = useLocation();
  const { login, setLogin } = useContext(LoginContext);

  useEffect(() => {
    function loadUser() {
      const user = localStorage.getItem("user");
      if (user) {
        setLogin(JSON.parse(user));
      }
    }
    
    loadUser();
  }, [setLogin]);

  return (
    <>
      <nav className={styles.mm_nav}>
        <ul>
          <li><NavLink to="/" className={location.pathname === "/" ? styles.active : ""}>HOME</NavLink></li>
          {Object.keys(login).length === 0 ? (
            <>
              <li><NavLink to="/user/login" className={location.pathname === "/user/login" ? styles.active : ""}>LOGIN</NavLink></li>
              <li><NavLink to="/user/register" className={location.pathname === "/user/register" ? styles.active : ""}>REGISTER</NavLink></li>
            </>
          ) : (
            <>
              <li><NavLink to="/user/profile" className={location.pathname === "/user/profile" ? styles.active : ""}>PROFILE</NavLink></li>
              {/* <li><NavLink to="/user/logout" className={location.pathname === "/user/logout" ? styles.active : ""}>LOGOUT</NavLink></li> */}
              <li><Logout/></li>
              <li><NavLink to="/user/notes" className={location.pathname === "/user/notes" ? styles.active : ""}>NOTES</NavLink></li>
            </>
          )}
        </ul>
      </nav>
    </>
  );
}

export default MainMenu
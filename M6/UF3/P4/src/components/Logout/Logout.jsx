import LoginContext from "../../context/LoginContext";
import styles from "./Logout.module.scss";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";

function Logout() {
  const { setLogin } = useContext(LoginContext);
  const navigate = useNavigate();

  function handleLogout(e) {
    e.preventDefault();
  
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8081/users/logout", {
          method: "GET",
        });
  
        if (!response.ok) {
          const errorMessage = await response.json();
          throw new Error(errorMessage.error);
        }
  
        setLogin({});
        localStorage.removeItem("user");
        navigate("/");
      } catch (error) {
        console.log("Error: ", error);
      }
    };
  
    fetchData();
  }

  return (
    <>
      <button onClick={handleLogout} type="submit" className={styles.logout}>LOGOUT</button>
    </>
  );
}

export default Logout;

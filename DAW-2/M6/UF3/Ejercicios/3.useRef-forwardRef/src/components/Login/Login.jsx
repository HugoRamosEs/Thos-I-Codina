import styles from './Login.module.scss';
import LoginContext from '../../context/LoginContext';
import { Link, Navigate } from 'react-router-dom';
import { useContext, useState } from 'react';

function Login() {
  const { setLogin } = useContext(LoginContext);
  const [ error, setError ] = useState("");
  const [ redirect, setRedirect ] = useState(false);
  const [ frmErrors, setFrmErrors ] = useState({});

  function saveLogin(user) {
    localStorage.setItem("user", JSON.stringify(user));
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    const errors = {};
    const frmData = {};

    const inputs = document.querySelectorAll('input[type="text"], input[type="password"], input[type="email"], textarea');
    inputs.forEach(input => {
      const name = input.name;
      const value = input.value.trim();
      if (!value) {
          errors[name] = `${name.charAt(0).toUpperCase() + name.substring(1)} is required`;
      } else {
          frmData[name] = value;
      }
    });

    if (Object.keys(errors).length === 0) {
      const validEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(frmData.email);
      const validPassword = frmData.password.length >= 8 && /[A-Z]/.test(frmData.password) && /[!@#$%^&*(),.?":{}|<>]/.test(frmData.password);
        
      if (!validEmail) {
        errors.email = "Invalid email format";
      }
      if (!validPassword) {
        errors.password = "Invalid password format";
      }
    }

    setFrmErrors(errors);

    if (Object.keys(errors).length === 0) {
      handleLogin(frmData);
    }
  };

  function handleLogin(dades) {
    console.log(dades);
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8081/users/login", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(dades),
          credentials: "include",
        });

        if (!response.ok) {
          const errorMessage = await response.json();
          throw new Error(errorMessage.error);
        }

        const user = await response.json();
        console.log(user);
        setLogin(user);
        saveLogin(user);
        setRedirect(true);
      } catch (error) {
        console.log("Error: ", error);
        setError(error);
      }
    };

    fetchData();
  }

  
  if (redirect) {
    return <Navigate to="/user/profile" />;
  }

  return (
    <>
      <div className={styles.main_login}>
        <h2>Log In</h2>
        <form method="post" onSubmit={handleSubmit}>
          <input type="text" id="email" name="email" placeholder="Email" />
          {frmErrors.email && (<span className={styles.error_message}>{frmErrors.email}</span>)}
          <input type="password" id="password" name="password" placeholder="Password" />
          {frmErrors.password && (<span className={styles.error_message}>{frmErrors.password}</span>)}
          <button type="submit" id="submit" name="submit">Log in</button>
        </form>
        <div className={styles.error_login}>
          <span>{error.toString()}</span>
        </div>
        <div className={styles.link_login}>
          <p>Don&apos;t have an account?</p>
          <Link to="/user/register">Register now</Link>
        </div>
      </div>
    </>
  );
}

export default Login;

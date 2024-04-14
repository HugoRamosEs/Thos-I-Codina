import styles from './Register.module.scss'
import { Link, Navigate } from "react-router-dom";
import { useState } from "react";

function Register() {
  const [ error, setError ] = useState("");
  const [ redirect, setRedirect ] = useState(false);
  const [ frmErrors, setFrmErrors ] = useState({});
  const [ termsChecked, setTermsChecked ] = useState(false);

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
        if (name !== "repeat_Password"){
          frmData[name] = value;
        }
      }
    });

    if (!termsChecked) {
      errors.terms = "You must accept the terms and conditions";
    }

    if (Object.keys(errors).length === 0) {
      const validEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(frmData.email);
      const validPassword = frmData.password.length >= 8 && /[A-Z]/.test(frmData.password) && /[!@#$%^&*(),.?":{}|<>]/.test(frmData.password);
      const repeat_Password = document.getElementById("repeat_Password").value;
        
      if (!validEmail) {
        errors.email = "Invalid email format";
      }
      if (!validPassword) {
        errors.password = "Invalid password format";
      }
      if (frmData.password !== repeat_Password) {
        errors.repeat_Password = "The passwords do not match";
      }
    }

    setFrmErrors(errors);

    if (Object.keys(errors).length === 0) {
      handleRegister(frmData);
    }
  };

  function handleRegister(dades) {
    console.log(dades);
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8081/users/register", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(dades),
        });
  
        if (!response.ok) {
          const errorMessage = await response.json();
          throw new Error(errorMessage.error);
        }
  
        const res = await response.text();
        console.log(res);
        setRedirect(true);
      } catch (error) {
        console.log("Error: ", error);
        setError(error);
      }
    };
  
    fetchData();
  }

  if (redirect) {
    return <Navigate to="/user/login" />;
  }

  return (
    <>
      <div className={styles.main_register}>
        <h2>Create a new account</h2>
        <form method="post" onSubmit={handleSubmit}>
          <input type="text" id="name" name="name" placeholder="First Name (Required)" />
          {frmErrors.name && (<span className={styles.error_message}>{frmErrors.name}</span>)}
          <input type="text" id="surname" name="surname" placeholder="Last Name (Required)" />
          {frmErrors.surname && (<span className={styles.error_message}>{frmErrors.surname}</span>)}
          <input type="text" id="email" name="email" placeholder="Email (Required)" />
          {frmErrors.email && (<span className={styles.error_message}>{frmErrors.email}</span>)}
          <input type="password" id="password" name="password" placeholder="Password (Required)" />
          {frmErrors.password && (<span className={styles.error_message}>{frmErrors.password}</span>)}
          <input type="password" id="repeat_Password" name="repeat_Password" placeholder="Repeat Password (Required)" />
          {frmErrors.repeat_Password && (<span className={styles.error_message}>{frmErrors.repeat_Password}</span>)}
          <div className="rCheckbox">
            <input type="checkbox" id="terms" name="terms" defaultChecked={termsChecked} onChange={(e) => setTermsChecked(e.target.checked)} />
            <label htmlFor="terms">Terms & Conditions</label>
          </div>
          {frmErrors.terms && (<span className={styles.error_message}>{frmErrors.terms}</span>)}
          <button type="submit" id="submit" name="submit">Create a new account</button>
        </form>
        <div className={styles.error_register}>
          <span className={styles.error_register}>{error.toString()}</span>
        </div>
        <div className={styles.link_register}>
          <p>Already a member?</p>
          <Link to="/user/login">Log in</Link>
        </div>
      </div>
    </>
  )
}

export default Register
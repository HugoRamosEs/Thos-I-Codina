import { createContext, useState } from 'react';

const LoginContext = createContext(null);

const LoginProvider = ({ children }) => {
  // const [login, setLogin] = useState([]);
  const [login, setLogin] = useState({});

  return (
    <LoginContext.Provider value = {{login, setLogin}}>
        {children}
    </LoginContext.Provider>
  );
};

export { LoginProvider }
export default LoginContext;
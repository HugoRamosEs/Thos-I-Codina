import { createContext, useState} from 'react';

const CartContext = createContext(null);

const CartProvider = ({ children }) => {
  const [isHidden, setIsHidden] = useState(true);

  return (
    <CartContext.Provider value = {{isHidden, setIsHidden}}>
        {children}
    </CartContext.Provider>
  );
};

export { CartProvider }
export default CartContext;
import { useContext } from "react";
import styles from "./ButtonCart.module.scss"
import ProductContext  from "../../../context/ProductContext";
import CartContext from "../../../context/CartContext";

function ButtonCart() {
  const { cart } = useContext(ProductContext);
  const { isHidden, setIsHidden } = useContext(CartContext);

  const form = (num) => {
    return num < 10 ? `0${num}` : num;
  };

  const handleCartVisibility = () => {
    setIsHidden(!isHidden);
  };

  return (
    cart.length === 0 ? null : (
      <div className={styles.btn_carrito}>
        <button onClick={handleCartVisibility} className={styles.carrito_img}>
          <img src="carrito.png" alt="carrito.png" />
          <span>{form(cart.length)}</span>
        </button>
      </div>
    )
  );
}

export default ButtonCart;


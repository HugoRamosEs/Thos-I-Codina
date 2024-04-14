import { useContext } from "react";
import ProductContext  from "../../context/ProductContext";
import styles from "./MainMenu.module.scss";

function MainMenu() {
  const { cart, setCart } = useContext(ProductContext);

  const formatNumber = (num) => {
    return num < 10 ? `0${num}` : num;
  };

  const clearCart = () => {
    setCart([]);
    localStorage.removeItem("cart");
  };

  return (
    <div id="main-menu">
        <nav className={styles.navbar}>
            <ul>
                <li><a href="">HOME</a></li>
                <li><a href="">SOBRE NOSALTRES</a></li>
                <li><a href="">PRODUCTES</a></li>
                <li><a href="">PRÀCTICA 4</a></li>
                <li><a href="">CONTACTE</a></li>
            </ul>
        </nav>
        <div className={styles.carrito}>
          <button onClick={clearCart}>Netejar Carretó</button>
          <button className={styles.carrito_img}>
            <img src="carrito.png" alt="carrito.png"></img>
            <span>{formatNumber(cart.length)}</span>
          </button>
        </div>
    </div>
  )
}

export default MainMenu
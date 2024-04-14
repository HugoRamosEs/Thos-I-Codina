import { useContext, useState, useEffect } from "react";
import ProductContext from "../../context/ProductContext";
import ProductCart from "../Products/ProductCart/ProductCart";
import styles from "../Cart/Cart.module.scss";
import Button from "../Buttons/Button/Button";
import CartContext from "../../context/CartContext";

function Cart() {
  const { cart, setCart } = useContext(ProductContext);
  const { isHidden, setIsHidden } = useContext(CartContext);
  const [total, setTotal] = useState(0);

  const handleInputs = (e) => {
    if (e.target.tagName === "INPUT") {
      const p_id = e.target.getAttribute("id");
  
      if (p_id) {
        const updatedCart = cart.map((item) => {
          if (item.pid === p_id) {
            const quantitat = parseInt(e.target.value);
            return {
              ...item,
              quantitat,
              import: (item.preu * quantitat).toFixed(2)
            };
          }
          return item;
        });

        setCart(updatedCart);
        localStorage.setItem("cart", JSON.stringify(updatedCart));
        totalPrice(updatedCart);
      }
    }
  };
  
  const totalPrice = (cart) => {
    let total = 0;
    cart.forEach((item) => {
      total = total + (item.preu * item.quantitat);
    });
    setTotal(total);
  };

  const handleButtons = (e) => {
    if (e.target.tagName === "BUTTON") {
      const b_id = e.target.getAttribute("b_id");
      if (b_id) {
        if (b_id === "b_buidar_carretó") {
          setCart([]);
          localStorage.removeItem("cart");
          setIsHidden(true);
        } else if (b_id === "b_seguir_comprant") {
          setIsHidden(true);
        }
      }
    }
  };

  useEffect(() => {
    totalPrice(cart);
  }, [cart]);

  return (
    <>
      <table onClick={handleButtons} onChange={handleInputs} className={`${styles.cart_table} ${isHidden ? styles.hidden : ""}`}>
        <thead>
          <tr>
            <th>Ref.</th>
            <th>Imatge</th>
            <th>Descripció</th>
            <th>Quantitat</th>
            <th>Preu</th>
            <th>Import</th>
          </tr>
        </thead>
        <tbody>
          {cart.map((item) => (
            <ProductCart key={item.pid} item={item}/>
          ))}
         <tr>
          <td><Button key="btn-c1" text="Seguir Comprant"></Button></td>
          <td><Button key="btn-c2" text="Buidar Carretó"></Button></td>
          <td className={styles.total} colSpan={4}>Total: {total.toFixed(2)}</td>
        </tr>
        </tbody>
      </table>
    </>
  );
}

export default Cart;

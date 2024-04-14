import { memo } from "react";
import styles from "./Product.module.scss";

const Product = memo(function Product({ item }) {
  return (
    <>
      <div key={item.pid} id={item.pid} className={styles.item}>
        <div className={styles.item_content}>
          <div className={styles.item_titles}>
            <h3>{item.marca}</h3>
            <h4>{item.model}</h4>
          </div>
          <div className={styles.item_img}>
            <img src={`/img/${item.imatge}`} alt={item.imatge} />
          </div>
          <p>
            {item.processador}/{item.ram}/HD{item.emmagatzematge}/
            {item.polzades}&quot;
          </p>
          <div className={styles.card_link}>
            <a href="">Veure detalls</a>
          </div>
          <p className={styles.card_prize}>Preu: {item.preu}€</p>
          <button p_id={item.pid}>Comprar</button>
        </div>
      </div>
    </>
  );
});

export default Product;

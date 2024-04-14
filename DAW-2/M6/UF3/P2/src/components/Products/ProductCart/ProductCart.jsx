import { memo } from "react";
import styles from "../../Cart/Cart.module.scss";

const ProductCart = memo(function ProductCart({ item }) {
  const item_import = item.import || item.preu;
  
  return (
    <>
        <tr key={item.pid} className={styles.cart_tbody_tr}>
            <td>{item.pid}</td>
            <td><img src={`/img/${item.imatge}`} alt={item.imatge}/></td>
            <td>{item.processador}/{item.ram}/HD{item.emmagatzematge}/{item.polzades}</td>
            <td><input type="number" id={item.pid} name={item.pid} min="0" defaultValue={item.quantitat} /></td>
            <td>{item.preu}</td>
            <td>{item_import}</td>
        </tr>
    </>
  );
});

export default ProductCart;
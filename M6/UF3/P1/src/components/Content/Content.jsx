import { useEffect, useState, useContext } from "react";
import styles from "./Content.module.scss";
import ProductContext from "../../context/ProductContext";
import FilterContext from "../../context/FilterContext";

function Content() {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(9);
  const { cart, setCart } = useContext(ProductContext);
  const { filter } = useContext(FilterContext);

  const handleCartItems = (item) => {
    const isInCart = cart.some(cartItem => cartItem.pid === item.pid);
    if (!isInCart) {
      const updatedCart = [...cart, item];
      setCart(updatedCart);
      localStorage.setItem("cart", JSON.stringify(updatedCart));
    }
  };

  const generatePagination = (data, itemsPerPage, currentPage, paginate) => {
    const pages = Math.ceil(data.length / itemsPerPage);
    const paginationButtons = [];
    for (let i = 1; i <= pages; i++) {
      paginationButtons.push(
        <button key={i} onClick={() => paginate(i)} className={currentPage === i ? styles.button_active : ""}>{i}</button>
      );
    }
    return paginationButtons;
  };

  const paginate = (num) => {
    setCurrentPage(num);
  };

  useEffect(() => {
    const storedCart = localStorage.getItem("cart");
    if (storedCart) {
      setCart(JSON.parse(storedCart));
    }
  }, [setCart]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:9080/p3.php", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(filter),
        });
        const cataleg = await response.json();
        console.log(cataleg);
        setCurrentPage(1);
        setData(cataleg);
      } catch (error) {
        console.log("Error a la connexió", error);
      }
    };
    fetchData();
  }, [filter]);

  const lastItem = currentPage * itemsPerPage;
  const firstItem = lastItem - itemsPerPage;
  const items = data.slice(firstItem, lastItem);

  return (
    <>
      {items && items.length > 0 ? (
        <>
          {items.map((item) => (
            <div key={item.pid} className={styles.item}>
              <div className={styles.item_content}>
                <div className={styles.item_titles}>
                  <h3>{item.marca}</h3>
                  <h4>{item.model}</h4>
                </div>
                <div className={styles.item_img}><img src={`/img/${item.imatge}`} alt={item.imatge}/></div>
                <p>
                  {item.processador}/{item.ram}/HD{item.emmagatzematge}/
                  {item.polzades}&quot;
                </p>
                <div className={styles.card_link}><a href="">Veure detalls</a></div>
                <p className={styles.card_prize}>Preu: {item.preu}€</p>
                <button onClick={() => handleCartItems(item)}>Comprar</button>
              </div>
            </div>
          ))}
          <div className={styles.pagination}>
            {generatePagination(data, itemsPerPage, currentPage, paginate)}
          </div>
        </>
      ) : (
        <p className={styles.no_items}>No hi han elements disponibles.</p>
      )}
    </>
  );
}

export default Content;

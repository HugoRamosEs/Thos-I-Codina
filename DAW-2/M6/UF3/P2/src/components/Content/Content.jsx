import { useEffect, useState, useContext } from "react";
import styles from "./Content.module.scss";
import ProductContext from "../../context/ProductContext";
import FilterContext from "../../context/FilterContext";
import Product from "../Products/Product/Product";

function Content() {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(9);
  const { cart, setCart } = useContext(ProductContext);
  const { filter } = useContext(FilterContext);

  const handleCartItems = (e) => {
    if (e.target.tagName === "BUTTON") {
      const p_id = e.target.getAttribute("p_id");
      if (p_id) {
        const p_inCart = cart.some((cartItem) => cartItem.pid === p_id);
        const p_toAdd = data.find((item) => item.pid === p_id);
  
        if (p_toAdd && !p_inCart) {
          p_toAdd.quantitat = 1;
          const updatedCart = [...cart, p_toAdd];
          setCart(updatedCart);
          localStorage.setItem("cart", JSON.stringify(updatedCart));
        }
      }
    }
  };

  const pagination = (data, itemsPerPage, currentPage, setCurrentPage) => {
    const pages = Math.ceil(data.length / itemsPerPage);
    const paginationButtons = [];
    const paginate = (num) => {
      setCurrentPage(num);
    };

    for (let i = 1; i <= pages; i++) {
        paginationButtons.push(
            <button key={i} onClick={() => paginate(i)} className={currentPage === i ? styles.button_active : ""}>{i}</button>
        );
    }
    return paginationButtons;
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:9080/p3.php", {
          method: "POST",
          //headers: { "Content-Type": "application/json" },
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

  useEffect(() => {
    const storedCart = localStorage.getItem("cart");
    if (storedCart) {
      setCart(JSON.parse(storedCart));
    }
  }, [setCart]);

  const lastItem = currentPage * itemsPerPage;
  const firstItem = lastItem - itemsPerPage;
  const items = data.slice(firstItem, lastItem);

  return (
    <>
      <div id="content" onClick={handleCartItems}>
        {items && items.length > 0 ? (
            <>
              {items.map((item) => (
                <Product key={item.pid} item={item}/>
              ))}
              <div className={styles.pagination}>
                {pagination(data, itemsPerPage, currentPage, setCurrentPage)}
              </div>
            </>
          ) : (
            <p className={styles.no_items}>No hi han elements disponibles.</p>
          )}
      </div>
    </>
  );
}

export default Content;

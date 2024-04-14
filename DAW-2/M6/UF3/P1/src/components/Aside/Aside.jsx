import { useEffect, useState, useContext } from "react";
import styles from "./Aside.module.scss";
import FilterContext from "../../context/FilterContext";

function Aside() {
  const [data, setData] = useState([]);
  const [showAllFilters, setShowAllFilters] = useState([]);
  const { filter, setFilter } = useContext(FilterContext);

  const handleFilter = (e, type) => {
    const value = e.target.value;
    const checked = e.target.checked;

    setFilter(() => {
      let updatedFilter = { ...filter };
      if (checked) {
        if (!updatedFilter[type]) {
          updatedFilter[type] = [];
        }
        if (!updatedFilter[type].includes(value)) {
          updatedFilter[type].push(value);
        }
      }else {
        updatedFilter[type] = updatedFilter[type].filter(
          (item) => item !== value
        );
        if (updatedFilter[type].length === 0) {
          delete updatedFilter[type];
        }
      }
      console.log(updatedFilter);
      return updatedFilter;
    });
  };

  const clearFilter = () => {
    setFilter([]);
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach((checkbox) => {
      checkbox.checked = false;
    });
  };

  const handleShowAll = (type) => {
    setShowAllFilters((prevShowAllFilters) => ({
      ...prevShowAllFilters,
      [type]: !prevShowAllFilters[type],
    }));
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:9080/p3filtres.php");
        const filtres = await response.json();
        console.log(filtres);
        setData(filtres);
      } catch (error) {
        console.log("Error a la connexió", error);
      }
    };
    fetchData();
  }, []);

  return (
    <>
    <div className={styles.aside_filtre}>
      <button onClick={clearFilter}>Netejar Filtres</button>
    </div>
      {Object.keys(data).map((type) => (
        <div className={styles.filter} key={type}>
          <h3>{type.toUpperCase()}</h3>
          {data[type].map((item, index) => (
            <div key={index} className={`${styles.filter_in} ${!showAllFilters[type] && index >= 3 ? styles.filter_hidden : ""}`}>
              {Object.keys(item).map(
                (subType) =>
                  subType !== `${type.charAt(0)}id` && subType !== "polid" && subType !== "procid" && (showAllFilters[type] || index < 3) && (
                    <label key={subType}>
                      <div>
                        <input type="checkbox" value={item[subType]} onChange={(e) => handleFilter(e, type)} checked={filter[type] ? filter[type].includes(item[subType]) : false}/>
                        {item[subType]}
                      </div>
                    </label>
                  )
              )}
              {index === 2 && (
                <div className={styles.button}>
                  {showAllFilters[type] ? (
                    <button onClick={() => handleShowAll(type)}>Menys</button>
                  ) : (
                    data[type].length > 3 && (
                      <button onClick={() => handleShowAll(type)}>Més</button>
                    )
                  )}
                </div>
              )}
            </div>
          ))}
        </div>
      ))}
    </>
  );
}

export default Aside;

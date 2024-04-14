import { useEffect, useState, useContext } from "react";
import styles from "./Aside.module.scss";
import FilterContext from "../../context/FilterContext";
import Button from "../Buttons/Button/Button";
import Filter from "../Filter/Filter";

function Aside() {
  console.log("aside");
  const [data, setData] = useState([]);
  const [showAllFilters, setShowAllFilters] = useState([]);
  const { filter, setFilter } = useContext(FilterContext);

  const handleFilters = (e) => {
    if (e.target.tagName === "INPUT" && e.target.type === "checkbox") {
      const type = e.target.getAttribute("data-type");
      const value = e.target.value;
      const checked = e.target.checked;
  
      setFilter(() => {
        let updatedFilter = { ...filter };
        if (checked) {
          updatedFilter[type] = [...(updatedFilter[type] || []), value];
        } else {
          updatedFilter[type] = (updatedFilter[type] || []).filter(
            (item) => item !== value
          );
          if (updatedFilter[type].length === 0) {
            delete updatedFilter[type];
          }
        }
        console.log(updatedFilter);
        localStorage.setItem("filter", JSON.stringify(updatedFilter));
        return updatedFilter;
      });
    }
  };

  const handleClearFilters = (e) => {
    if (e.target.tagName === "BUTTON" && e.target.textContent === "Netejar Filtres") {
      setFilter({});
      const checkboxes = document.querySelectorAll('input[type="checkbox"]');
      checkboxes.forEach((checkbox) => {
        checkbox.checked = false;
      });
      localStorage.removeItem("filter");
    }
  }
  
  const handleShowAll = (type, e) => {
    if (e.target.tagName === "BUTTON") {
      setShowAllFilters((prevShowAllFilters) => ({
        ...prevShowAllFilters,
        [type]: !prevShowAllFilters[type],
      }));
    }
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

  useEffect(() => {
    const storedFilter = localStorage.getItem("filter");
    if (storedFilter) {
      setFilter(JSON.parse(storedFilter));
    }
  }, [setFilter]);

  return (
    <div onClick={handleClearFilters} onChange={handleFilters}>
      <Button key="btn-a1" text={"Netejar Filtres"}></Button>
      {Object.keys(data).map((type) => (
        <div className={styles.filter} key={type}>
          <h3>{type.toUpperCase()}</h3>
          {data[type].map((item, index) => {
            const showAll = showAllFilters[type] || index < 3;
            const subType = Object.keys(item).find((subType) => subType !== `${type.charAt(0)}id` && subType !== "polid" && subType !== "procid");
            const filterCheck = filter[type] ? filter[type].includes(item[subType]) : false;
            
            return (
              <div key={index} className={`${styles.filter_in} ${!showAllFilters[type] && index >= 3 ? styles.filter_hidden : ""}`}>
                <Filter key={item[subType]} item={item} type={type} subType={subType} filterCheck={filterCheck} showAll={showAll} />
                {index === 2 && (
                  <div className={styles.button} onClick={(e) => handleShowAll(type, e)}>
                    {showAllFilters[type] ? (
                      <Button key={`btn-menys_${type}`} text={"Menys"}></Button>
                    ) : (
                      data[type].length > 3 && (
                        <Button key={`btn-mes_${type}`} text={"Més"}></Button>
                      )
                    )}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      ))}
    </div>
  );
}

export default Aside;

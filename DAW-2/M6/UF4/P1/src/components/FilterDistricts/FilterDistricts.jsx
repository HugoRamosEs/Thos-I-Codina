import styles from "./FilterDistricts.module.scss";
import DistrictsContext from "../../contexts/DistrictsContext";
import FilterDistrictsContext from "../../contexts/FilterDistrictsContext";

import { useContext } from "react";

function FilterDistricts() {
  const { districts } = useContext(DistrictsContext);
  const { filterDistricts, setFilterDistricts } = useContext(FilterDistrictsContext);

  const handleFilterDistricts = (e) => {
    const value  = parseInt(e.target.value, 10);
    if (e.target.checked) {
      setFilterDistricts([...filterDistricts, value]);
    } else {
      setFilterDistricts(filterDistricts.filter((district) => district !== value));
    }
  }

  const clearFilters = () => {
    document.querySelectorAll('input[type="checkbox"]').forEach((checkbox) => {
      checkbox.checked = false;
    });
    setFilterDistricts([]);
  }

  return (
    <>
      <div className={styles.districts} onChange={handleFilterDistricts}>
        <div className={styles.districts_title}>
          <h2>Districts</h2>
          {filterDistricts.length > 0 ? (
            <button onClick={clearFilters}>Clear</button>
          ) : null}
        </div>
        <div className={styles.districts_list}>
          {districts && districts.features.map((feature) => (
            <div key={feature.properties.C_Distri} className={styles.district}>
              <input type="checkbox" id={feature.properties.C_Distri} name={feature.properties.N_Distri} value={feature.properties.C_Distri} />
              <label htmlFor={feature.properties.C_Distri}>{feature.properties.N_Distri}</label>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default FilterDistricts;

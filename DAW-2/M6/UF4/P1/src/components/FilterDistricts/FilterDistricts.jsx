import styles from "./FilterDistricts.module.scss";
import DistrictsContext from "../../contexts/DistrictsContext";

import { useContext, useState } from "react";

function FilterDistricts() {
  const { districts } = useContext(DistrictsContext);
  const [ filterDistricts, setFilterDistricts ] = useState([]);

  console.log(districts);
  return (
    <>
      <div className={styles.districts}>
        <h2>Districts</h2>
        <div className={styles.districts_list}>
          {districts && districts.features.map((feature) => (
            <div key={feature.properties.C_Distri}>
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

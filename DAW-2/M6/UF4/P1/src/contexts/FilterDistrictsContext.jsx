import { createContext, useState } from "react";

const FilterDistrictsContext = createContext(null);

const FilterDistrictsProvider = ({children}) => {
    const [ filterDistricts, setFilterDistricts ] = useState([]);
    return (
        <FilterDistrictsContext.Provider value = {{filterDistricts, setFilterDistricts}}>
            {children}
        </FilterDistrictsContext.Provider>
    )
}

export { FilterDistrictsProvider }
export default FilterDistrictsContext;
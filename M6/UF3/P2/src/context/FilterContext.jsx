import { createContext, useState } from 'react';

const FilterContext = createContext(null);

const FilterProvider = ({children}) => {
    // const [filter, setFilter] = useState(null);
    const [filter, setFilter] = useState([]);
    return (
        <FilterContext.Provider value = {{filter, setFilter}}>
            {children}
        </FilterContext.Provider>
    )
}

export { FilterProvider }
export default FilterContext;
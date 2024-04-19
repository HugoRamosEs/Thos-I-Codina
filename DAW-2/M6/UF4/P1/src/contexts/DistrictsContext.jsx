import { createContext, useState } from "react";

const DistrictsContext = createContext(null);

const DistrictsProvider = ({children}) => {
    const [ districts, setDistricts ] = useState(null);
    return (
        <DistrictsContext.Provider value = {{districts, setDistricts}}>
            {children}
        </DistrictsContext.Provider>
    )
}

export { DistrictsProvider }
export default DistrictsContext;
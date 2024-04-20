import L from "leaflet";
import "leaflet.heat";
import "leaflet.heat/dist/leaflet-heat.js";
import FilterDistrictsContext from "../../contexts/FilterDistrictsContext";

import { useEffect, useRef, useContext } from "react";
import { useMap } from "react-leaflet";

function HeatMap({ options }) {
  const heatLayerRef = useRef(null);
  const map = useMap();
  const { filterDistricts } = useContext(FilterDistrictsContext);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost/UF3_M6/P1/CSV_DB.php", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(filterDistricts),
        });
        const data = await response.json();
        const latlngs = data.map(item => [item.LATITUD, item.LONGITUD, 1]);
        if (heatLayerRef.current) {
          heatLayerRef.current.setLatLngs(latlngs);
        } else {
          heatLayerRef.current = L.heatLayer(latlngs, options).addTo(map);
        }
      } catch (error) {
        console.error("Error: " + error);
      }
    };

    fetchData();
  }, [map, options, filterDistricts]);

  useEffect(() => {
    if (heatLayerRef.current) {
      heatLayerRef.current.setOptions(options);
    }
  }, [options]);

  return null;
}

export default HeatMap;

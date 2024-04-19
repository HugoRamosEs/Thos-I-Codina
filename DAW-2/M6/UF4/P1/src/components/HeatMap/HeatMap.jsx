import L from "leaflet";
import "leaflet.heat";
import "leaflet.heat/dist/leaflet-heat.js";

import { useState, useEffect, useRef } from "react";
import { useMap } from "react-leaflet";

function HeatMap({ options }) {
  const [dataHeatMap, setDataHeatMap] = useState([]);
  const heatLayerRef = useRef(null);
  const map = useMap();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost/UF3_M6/P1/CSV_DB.php", {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });
        const dataHeatMap = await response.json();
        setDataHeatMap(dataHeatMap);
      } catch (error) {
        console.error("Error: " + error);
      }
    };
    fetchData();
  }, []);

  useEffect(() => {
    if (dataHeatMap.length > 0 && !heatLayerRef.current) {
      const latlngs = dataHeatMap.map(item => [item.LATITUD, item.LONGITUD, 1]);
      heatLayerRef.current = L.heatLayer(latlngs, options).addTo(map);
    }
  }, [dataHeatMap, options, map]);

  useEffect(() => {
    if (heatLayerRef.current) {
      heatLayerRef.current.setOptions(options);
    }
  }, [options]);

  return null;
}

export default HeatMap;

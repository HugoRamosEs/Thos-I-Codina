import "leaflet/dist/leaflet.css";
import styles from "./Map.module.scss";

import { MapContainer, TileLayer, Marker, Popup, GeoJSON } from "react-leaflet";
import { useState, useEffect } from "react";

function Map() {
  const [ position ] = useState([41.3851, 2.1734]);
  const [ data, setData ] = useState([]);
  const [ title, setTitle ] = useState("");
  const [ district_id, setDistrict_id ] = useState(null);

  const handleHover = (feature, layer) => {
    if (feature.properties && feature.properties.N_Distri) {
      layer.on({
        mouseover: () => {
          setTitle(feature.properties.N_Distri);
          setDistrict_id(feature.properties.C_Distri);
        },
        mouseout: () => {
          setTitle("");
          setDistrict_id(null);
        },
        click: () => {
          window.open(feature.properties.WEB_1);
        }
      });
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("districtes_geo.json", {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });
        const data = await response.json();
        console.log(data);
        setData(data);
      } catch (error) {
        console.error("Error: " + error);
      }
    }
    fetchData();
  }, []);

  return (
    <>
      <div className={styles.main_map}>
        <h2>{title}</h2>
        <MapContainer className={styles.leaflet_container} center={[41.3851, 2.1734]} zoom={12} scrollWheelZoom={false}>
          <TileLayer attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
          <Marker position={position}>
            <Popup>
              A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
          </Marker>
          {data && (<GeoJSON key={data.type} data={data} style={(feature) => ({
            color: "#868387",
            weight: 2,
            fillColor: feature.properties.C_Distri === district_id ? feature.properties.color : "#c1c1c1",
            fillOpacity: feature.properties.C_Distri === district_id ? 0.7 : 0.5,
            dashArray: "4, 4"
          })}
          onEachFeature={handleHover} />)}
        </MapContainer>
      </div>
    </>
  );
}

export default Map;

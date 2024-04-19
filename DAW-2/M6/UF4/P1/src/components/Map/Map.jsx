import "leaflet/dist/leaflet.css";
import styles from "./Map.module.scss";
import HeatMap from "../HeatMap/HeatMap";

import { MapContainer, TileLayer, Marker, Popup, GeoJSON } from "react-leaflet";
import { useState, useEffect, useRef } from "react";

function Map() {
  const [ position ] = useState([41.3851, 2.1734]);
  const [ data, setData ] = useState([]);
  const [ district_id, setDistrict_id ] = useState(null);
  const [ options, setOptions ] = useState({
    radius: 25,
    max: 1,
    blur: 15
  });
  const titleRef = useRef("Barcelona");

  const handleHover = (feature, layer) => {
    if (feature.properties && feature.properties.N_Distri) {
      layer.on({
        mouseover: () => {
          titleRef.current.textContent = feature.properties.N_Distri;
          setDistrict_id(feature.properties.C_Distri);
        },
        mouseout: () => {
          titleRef.current.textContent = "Barcelona";
          setDistrict_id(null);
        },
        click: () => {
          window.open(feature.properties.WEB_1);
        }
      });
    }
  };

  const handleConf = (e) => {
    setOptions({
      ...options,
      [e.target.name]: parseFloat(e.target.value)
    });

    console.log(options);
  }

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

    // element={!auth ? <Login />) : (<Navigate replace to="/profile" />)}; --> Examen
  return (
    <>
      <div className={styles.map}>
        <h2 ref={titleRef}>Barcelona</h2>
        

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
          <HeatMap options={options}/>
        </MapContainer>
      </div>

      <div className={styles.opcions}>
        <h2>Options</h2>
        
        <div className={styles.sliders} onChange={handleConf}>
          <label htmlFor="radius">Radi</label>
          <input type="range" id="radius" name="radius" min="1" max="50" className={styles.slider} defaultValue={options.radius} />
          <label htmlFor="max">Intesitat</label>
          <input type="range" id="max" name="max" min="0.1" max="1" step="0.1" className={`${styles.slider} ${styles.inverted}`} defaultValue={options.max} />
          <label htmlFor="blur">Opacitat</label>
          <input type="range" id="blur" name="blur" min="1" max="30" className={styles.slider} defaultValue={options.blur} />  
        </div>
      </div>
    </>
  );
}

export default Map;

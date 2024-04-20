import "leaflet/dist/leaflet.css";
import styles from "./Map.module.scss";
import HeatMap from "../HeatMap/HeatMap";
import DistrictsContext from "../../contexts/DistrictsContext";
import FilterDistricts from "../FilterDistricts/FilterDistricts";
import LeafletImage from "leaflet-image";

import { MapContainer, TileLayer, Marker, Popup, GeoJSON } from "react-leaflet";
import { useState, useEffect, useRef, useContext } from "react";
import { saveAs } from "file-saver";


function Map() {
  const center = [41.390205, 2.154007];
  const { districts, setDistricts } = useContext(DistrictsContext);
  const [ district_id, setDistrict_id ] = useState(null);
  const [ options, setOptions ] = useState({
    radius: 25,
    max: 1,
    blur: 15,
    gradient: {1: 'red', 0.9: 'lime', 0.4: 'blue'},
  });
  const titleRef = useRef("Barcelona");
  const downloadRef = useRef("");
  const [ downloadSucces, setDownloadSucces] = useState(true);
  const mapRef = useRef(null);

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

  const handleExportHeatMap = async () => {
    if (mapRef.current) {
      try {
        LeafletImage(mapRef.current, function(err, baseCanvas) {
          if (err) {
            throw new Error(err);
          }

          const combinedCanvas = document.createElement("canvas");
          const ctx = combinedCanvas.getContext("2d");
          combinedCanvas.width = baseCanvas.width;
          combinedCanvas.height = baseCanvas.height;

          ctx.drawImage(baseCanvas, 0, 0);
          
          const heatMapImage = document.querySelector(".leaflet-heatmap-layer canvas");
          if (heatMapImage) {
            ctx.drawImage(heatMapImage, 0, 0);
          }

          combinedCanvas.toBlob(function(blob) {
            saveAs(blob, "heat-map.png");
          }, "image/png");

          if (downloadRef.current) {
            downloadRef.current.textContent = "Downloaded successfully!";
            setDownloadSucces(true);
            setTimeout(() => {
              if (downloadRef.current) {
                downloadRef.current.textContent = "";
              }
            }, 4000);
          }
        });
      } catch (error) {
        console.error("Error exporting map:", error);
        if (downloadRef.current) {
          downloadRef.current.textContent = "There was an error with your download...";
          setDownloadSucces(false);
          setTimeout(() => {
            if (downloadRef.current) {
              downloadRef.current.textContent = "";
            }
          }, 4000);
        }
      }
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("districtes_geo.json", {
          method: "GET",
          headers: { "Content-Type": "application/json" },
        });
        const districts = await response.json();
        console.log(districts);
        setDistricts(districts);
      } catch (error) {
        console.error("Error: " + error);
      }
    }
    fetchData();
  }, [setDistricts]);

  return (
    <>
      <div className={styles.map}>
        <h2 ref={titleRef}>Barcelona</h2>
        <MapContainer ref={mapRef} className={styles.leaflet_container} center={[41.3851, 2.1734]} zoom={12} scrollWheelZoom={false}>
          <TileLayer attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                     url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
          <Marker position={center}>
            <Popup>
              A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
          </Marker>
          {districts && (<GeoJSON key={districts.type} data={districts} style={(feature) => ({
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

      <div className={styles.lateral}>
        <div className={styles.opcions}>
          <h2>Options</h2>
          <div className={styles.sliders} onChange={handleConf}>
            <div className={styles.slider_flex}>
              <label htmlFor="radius">Radius</label>
              <input type="range" id="radius" name="radius" min="1" max="50" className={styles.slider} defaultValue={options.radius} />
            </div>
            <div className={styles.slider_flex}> 
              <label htmlFor="max">Intensity</label>
              <input type="range" id="max" name="max" min="0.1" max="1" step="0.1" className={`${styles.slider} ${styles.inverted}`} defaultValue={options.max} />
            </div>
            <div className={styles.slider_flex}>
              <label htmlFor="blur">Blur</label>
              <input type="range" id="blur" name="blur" min="1" max="30" className={styles.slider} defaultValue={options.blur} />  
            </div>
          </div>
        </div>

        <FilterDistricts />

        <div className={styles.exportar}>
          <h2>Export</h2>
          <button onClick={handleExportHeatMap}>Download</button>
          <p ref={downloadRef} style={{ color: downloadSucces ? 'green' : 'red' }}></p>
        </div>
      </div>
    </>
  );
}

export default Map;

import Header from "./components/Header/Header";
import MainContent from "./components/MainContent/MainContent";
import Map from "./components/Map/Map";
import Error404 from "./components/Error404/Error404";
import Footer from "./components/Footer/Footer";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.scss";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <Router>
        <div className="content">
          <Header />
          <main>
            <Routes>
              <Route path="/" element={<MainContent />} />
              <Route path="/map" element={<Map />} />
              <Route path="*" element={<Error404 />} />
            </Routes>
          </main>
          <Footer />
        </div>
      </Router>
    </>
  );
}

export default App;

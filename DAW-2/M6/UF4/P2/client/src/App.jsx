import "bootstrap/dist/css/bootstrap.min.css";
import "./App.scss";
import Header from "./components/Header/Header";
import MainContent from "./components/MainContent/MainContent";
import Video from "./components/Video/Video";
import Error404 from "./components/Error404/Error404";
import Footer from "./components/Footer/Footer";

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
              <Route path="/video" element={<Video />} />
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

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.scss";
import Header from "./components/Header/Header";
import MainContent from "./components/MainContent/MainContent";
import MainVideoChat from "./components/MainVideoChat/MainVideoChat";
import Error404 from "./components/Error404/Error404";
import Footer from "./components/Footer/Footer";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { VideoProvider } from "./contexts/VideoContext";

function App() {
  return (
    <>
      <Router>
        <VideoProvider>
          <div className="content">
            <Header />
            <main>
              <Routes>
                <Route path="/" element={<MainContent />} />
                <Route path="/videochat" element={<MainVideoChat />} />
                <Route path="*" element={<Error404 />} />
              </Routes>
            </main>
            <Footer />
          </div>
        </VideoProvider>
      </Router>
    </>
  );
}

export default App;

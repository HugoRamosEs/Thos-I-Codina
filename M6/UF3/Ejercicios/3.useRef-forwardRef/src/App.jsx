import "./App.scss";
import Header from "./components/Header/Header";
import MainContent from "./components/MainContent/MainContent";
import Login from "./components/Login/Login";
import Register from "./components/Register/Register";
import Error404 from "./components/Error404/Error404";
import Footer from "./components/Footer/Footer";
import Profile from "./components/Profile/Profile";
import Notes from "./components/Notes/Notes/Notes";
// import Logout from "./components/Logout/Logout";
import { HashRouter as Router, Routes, Route } from "react-router-dom";
import { LoginProvider } from "./context/LoginContext";


function App() {
  return (
    <>
      <LoginProvider>
        <Router>
          <div className="content">
            <Header />
            <main>
              <Routes>
                <Route path="/" element={<MainContent />} />
                <Route path="/user/login" element={<Login />} />
                <Route path="/user/register" element={<Register />} />
                <Route path="/user/profile" element={<Profile />} />
                {/* <Route path="/user/logout" element={<Logout />} /> */}
                <Route path="/user/notes" element={<Notes />} />
                <Route path="*" element={<Error404 />} />
              </Routes>
            </main>
            <Footer />
          </div>
        </Router>
      </LoginProvider>
    </>
  );
}

export default App;

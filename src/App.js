import logo from "./logo.svg";
import "./App.css";
import ViewCardComponent from "./components/ViewCardComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import AddCardComponent from "./components/AddCardComponent";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import UpdateCard from "./components/UpdateCard.js";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route path="/" element={<ViewCardComponent />}></Route>
            <Route path="/allCards" element={<ViewCardComponent />}></Route>
            <Route path="/addCard" element={<AddCardComponent />}></Route>
            <Route path="/updateCard" element={<UpdateCard />}></Route>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;

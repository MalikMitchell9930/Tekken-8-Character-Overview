import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import SiteNavbar from './layout/SiteNavbar';
import Background from './layout/Background';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from './pages/HomePage';
import ViewCharacter from './characters/ViewCharacter';
import AddCharacter from './characters/AddCharacter';
import AddCharacterMove from './characters/AddCharacterMove';
import EditCharacter from './characters/EditCharacter';
import EditCharacterMove from './characters/EditCharacterMove';


function App() {
  return (
    <div className="App">
      <Router>
        <SiteNavbar />
        <div className='bg'>
        <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route exact path="/addCharacter" element={<AddCharacter />} />
        <Route exact path="/editCharacter/:id" element={<EditCharacter />} />
        <Route exact path="/viewCharacter/:id" element={<ViewCharacter />} />
        <Route exact path="/addCharacterMove" element={<AddCharacterMove />} />
        <Route exact path="/editCharacterMove" element={<EditCharacterMove />} />
        </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;

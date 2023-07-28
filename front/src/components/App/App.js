import './App.css';

import {Routes, Route, Link} from "react-router-dom";

import Info from "../../pages/info";
import RegForm from "../../pages/RegForm";
import Header from "../Header";

function App() {
    return <>
        <Header/>
        <Routes>
            <Route path='/aaa' element={<Info/>} />
            <Route path='/' element={<RegForm/>} />
        </Routes>
    </>
}

export default App;

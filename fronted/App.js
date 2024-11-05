import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Signin } from "./pages/Signin";
import { Top } from "./pages/Top";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={`/`} element={<Signin />} />
        <Route path={`/top/`} element={<Top />}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Header from './components/Header'
import Home from './pages/Home'
import Votacao from './pages/Votacao'
import './App.css'

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/votacao" element={<Votacao />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
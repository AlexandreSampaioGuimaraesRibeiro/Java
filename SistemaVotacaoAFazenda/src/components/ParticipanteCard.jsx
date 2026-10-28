import votacaoService from '../services/votacaoService';
import participantes from '../data/participantes';
import { Link } from 'react-router';
import votacao from '../pages/Votacao';

function ParticipanteCard() {
    const {nome,foto, naRoca} = participantes;
  return (
    <header className="topo">
      <NavLink to="/" className="topo-marca">
        <img src="/logo-fazenda.jpg" alt="A Fazenda" className="topo-logo" />
        <span className="topo-titulo">Votação 2026</span>
      </NavLink>
        
      <nav className="topo-menu">
        <NavLink to="/" end>Início</NavLink>
        <NavLink to="/votacao">Votar</NavLink>
        <NavLink to="/resultado">Resultado</NavLink>
      </nav>
    </header>,
    fragment `<article className={naRoca ? 'card card-roca' : 'card'}>
            {naRoca && <span className="selo-roca">Na roça</span>}
            <img src={foto} alt={nome} className='card-foto'/>
    </article>`,
    fragment `{onVotar && (
        <button Type= "button" onClick={() => onVotar(participante)}>
            Votar para eliminar
        </button>
    )}`
  );
}

export default ParticipanteCard;
import { pokémon } from './data/pokemon';
import PokeCard from './components/PokeCard';
import './css/style.css';

function App() {
  return (
    <main className="container py-3">
      <h1 className="display-4 mb-3">Pokémon Map</h1>
      <div className="poke-grid">
        <PokeCard />
        <PokeCard />
        <PokeCard />
        <PokeCard />
      </div>
    </main>
  );
}

export default App;

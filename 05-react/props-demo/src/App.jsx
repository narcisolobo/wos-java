import MuppetCard from './components/MuppetCard';
import { muppets } from './data/muppets';
import './css/style.css';

function App() {
  return (
    <main className="container py-3">
      <h1 className="display-4 mb-3">Muppet Map</h1>
      <div className="muppet-grid">
        {muppets.map((muppet) => (
          <MuppetCard
            name={muppet.name}
            id={muppet.id}
            description={muppet.description}
          />
        ))}
      </div>
    </main>
  );
}

export default App;

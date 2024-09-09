import { Fragment } from 'react';
import Navbar from './components/Navbar';
import Main from './components/Main';
import Aside from './components/Aside';

function App() {
  return (
    <Fragment>
      <Navbar />
      <div className="container">
        <div className="row">
          <div className="col-8">
            <Main />
          </div>
          <div className="col-4">
            <Aside />
          </div>
        </div>
      </div>
    </Fragment>
  );
}

export default App;

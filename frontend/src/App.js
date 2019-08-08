import React from "react";
import { 
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

import Home from './components/Home';
import Error from './Error';


const App = () => (
  <Router>
    <div>
      <Route exact path="/" component={Home} />
      <Route path="/error" component={Error} />
    </div>
  </Router>
);

export default App;

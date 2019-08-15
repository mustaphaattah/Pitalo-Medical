import React from "react";
import { 
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

import Home from './components/Home';
import Patients from './components/Patient/Patients';
import PatientDetail from './components/Patient/PatientDetail';
import Staff from './components/Staff/Staff';
import Error from './Error';


const App = () => (
  <Router>
    <div>
      <Route exact path="/" component={Home} />
      <Route path="/error" component={Error} />
      <Route path="/patients" component={Patients} />
      <Route path="/patient/:id/details" component={PatientDetail} />
      <Route path="/staff" component={Staff} />
      
      <Route path="/login" component={Login} />
    </div>
  </Router>
);

export default App;

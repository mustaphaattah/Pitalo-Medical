import React from "react";
import { 
  BrowserRouter as Router,
  Route
} from 'react-router-dom';

import Home from './components/Home';
import Login from './components/Login';
import NurseLogin from './components/NurseLogin';
import DoctorLogin from './components/Doctor/DoctorLogin';
import DoctorVisitation from './components/Doctor/DoctorVisitation';
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
      
      <Route exact path="/login" component={Login} />
      <Route path="/login/nurses" component={NurseLogin} />
      <Route path="/login/doctors" component={DoctorLogin} />

      <Route path="/doctor/:id/visitations" component={DoctorVisitation} />
    </div>
  </Router>
);

export default App;

import { combineReducers } from 'redux';
import patientReducer from './patientReducer';
import visitationReducer from './visitationReducer';
import nurseReducer from './nurseReducer';
import doctorReducer from './doctorReducer';


export default combineReducers({
  patients: patientReducer,
  visitations: visitationReducer,
  doctors: doctorReducer,
  nurses: nurseReducer
});
import { combineReducers } from 'redux';
import patientReducer from './patientReducer';
import visitationReducer from './visitationReducer';


export default combineReducers({
  patients: patientReducer,
  visitations: visitationReducer
});
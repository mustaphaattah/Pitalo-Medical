import axios from 'axios';
import {
  FETCH_PATIENTS,
  FETCH_PATIENT 
} from './types';
import {
  fetchPatients
} from './urls';



export const getPatients = () => async (dispatch) => {
  const res = await axios.get(fetchPatients);
  dispatch({ type: FETCH_PATIENTS, payload: res.data });
}
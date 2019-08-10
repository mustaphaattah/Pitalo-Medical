import axios from 'axios';
import {
  FETCH_PATIENTS,
  FETCH_PATIENT 
} from './types';



export const getPatients = () => async (dispatch) => {
  const res = await axios.get('/api/patients');
  dispatch({ type: FETCH_PATIENTS, payload: res.data });
}

export const getPatient = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`/api/patient/${id}`);
    dispatch({ type: FETCH_PATIENT, payload: res.data });
  } catch (error) {
    history.push('/error');
    console.log(error);
  }
}
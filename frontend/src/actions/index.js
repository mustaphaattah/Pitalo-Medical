import axios from 'axios';
import {
  FETCH_PATIENTS,
  FETCH_PATIENT,
  FETCH_PATIENT_VISITATIONS 
} from './types';



export const getPatients = () => async (dispatch) => {
  const res = await axios.get('/api/patients');
  dispatch({ type: FETCH_PATIENTS, payload: res.data });
}

export const getPatient = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`/api/patients/${id}`);
    dispatch({ type: FETCH_PATIENT, payload: res.data });
  } catch (error) {
    history.push('/error');
  }
}

export const getPatientVisitations = (id) => async (dispatch) => {
  const res = await axios.get(`/api/patients/${id}/visitations`);
  dispatch({ type: FETCH_PATIENT_VISITATIONS, payload: res.data });
}
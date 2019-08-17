import axios from 'axios';
import {
  FETCH_PATIENTS,
  FETCH_PATIENT,
  FETCH_VISITATIONS, 
  FETCH_NURSES,
  FETCH_NURSE,
  FETCH_DOCTOR,
  FETCH_DOCTORS,
  LOGIN,
  LOGOUT
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
  dispatch({ type: FETCH_VISITATIONS, payload: res.data });
}

export const getNurses = () => async (dispatch) => {
  const res = await axios.get('/api/nurses');
  dispatch({ type: FETCH_NURSES, payload: res.data });
}

export const getNurse = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`/api/nurses/${id}`);
    dispatch({ type: FETCH_NURSE, payload: res.data });
  } catch(error) {
    history.push('/error');
  }
}

export const getDoctors= () => async (dispatch) => {
  const res = await axios.get('/api/doctors');
  dispatch({ type: FETCH_DOCTORS, payload: res.data });
}

export const getDoctor = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`/api/doctors/${id}`);
    dispatch({ type: FETCH_DOCTOR, payload: res.data });
  } catch(error) {
    history.push('/error');
  }
}

export const getDoctorVisitations = (id) => async (dispatch) => {
  const res = await axios.get(`/api/doctors/${id}/visitations`);
  dispatch({ type: FETCH_VISITATIONS, payload: res.data });
}

export const login = () => (dispatch) => {
  dispatch({ type: LOGIN, payload: true });
}

export const logout = () => (dispatch) => {
  dispatch({ type: LOGOUT, payload: false });
}
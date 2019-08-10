import {
  FETCH_PATIENTS,
  FETCH_PATIENT
} from '../actions/types';

const initialState = {
  patients: [],
  patient: {}
}

export default function (state = initialState, action) {
  switch(action.type) {
    case FETCH_PATIENTS:
      return {
        ...state,
        patients: action.payload
      };

    case FETCH_PATIENT:
      return {
        ...state,
        patient: action.payload
      };

    default:
      return state;
  }
}
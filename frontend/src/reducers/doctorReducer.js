import {
  FETCH_DOCTOR,
  FETCH_DOCTORS
} from '../actions/types';

const initialState = {
  doctors: [],
  doctor: {}
}

export default function (state = initialState, action) {
  switch(action.type) {
    case FETCH_DOCTORS:
      return {
        ...state,
        doctors: action.payload
      };

    case FETCH_DOCTOR:
      return {
        ...state,
        doctor: action.payload
      };

    default:
      return state;
  }
}
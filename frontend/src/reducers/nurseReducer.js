import {
  FETCH_NURSE,
  FETCH_NURSES
} from '../actions/types';

const initialState = {
  nurses: [],
  nurse: {}
}

export default function (state = initialState, action) {
  switch(action.type) {
    case FETCH_NURSES:
      return {
        ...state,
        nurses: action.payload
      };

    case FETCH_NURSE:
      return {
        ...state,
        nurse: action.payload
      };

    default:
      return state;
  }
}
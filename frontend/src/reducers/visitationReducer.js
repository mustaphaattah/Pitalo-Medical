import {
  FETCH_VISITATIONS
} from '../actions/types';


const initialState = {
  visitations: [],
  visitation: {}
}

export default function(state = initialState, action) {
  switch(action.type) {
    case FETCH_VISITATIONS: 
      return {
        ...state,
        visitations: action.payload
      };
    default:
      return state;
  }
}
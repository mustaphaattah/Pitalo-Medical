import React from 'react';
import { withRouter } from 'react-router-dom';
import sprite from "./components/assets/sprite.svg";

function Error(props) {
  return (
    <div className="h-screen w-full bg-red-200">
      <h2 className="text-6xl font-bold text-center pt-24 text-red-900">Sorry, we can't diagnose this one...</h2>
      <svg className="h-64 w-64 block mt-12 m-auto">
        <use xlinkHref={`${sprite}#skull`} />
      </svg>
      <button onClick={() => props.history.push('/patients')} className="block m-auto mt-16 bg-red-900 text-white py-4 px-12 text-xl">
        Go back
      </button>
    </div>
  )
}

export default withRouter(Error);

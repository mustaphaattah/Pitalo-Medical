import React, { Component } from 'react';
import { connect } from 'react-redux';
import { NavLink } from 'react-router-dom';

import sprite from "./assets/sprite.svg";
import Header from './Header';

class Login extends Component {
  render() {
    return (
      <div className="w-screen min-h-screen bg-gray-200">
        <Header />
        <svg className="h-64 w-64 m-auto mt-32 mb-10">
          <use xlinkHref={`${sprite}#hospital`} />
        </svg>
        <h2 className="text-center text-gray-700 text-4xl font-bold">Welcome to Pitalo Medical</h2>
        <NavLink to="/login/nurses" className="block mt-12 text-gray-700 bg-white px-8 py-4 text-center text-xl font-semibold shadow-md hover:shadow-xl w-1/3 m-auto">
          Continue as Nurse
        </NavLink>
        <NavLink to="/login/doctors" className="block mt-8 text-gray-700 bg-white px-8 py-4 text-center text-xl font-semibold shadow-md hover:shadow-xl w-1/3 m-auto">
          Continue as Doctor
        </NavLink>
      </div>
    )
  }
}

export default connect(

)(Login);

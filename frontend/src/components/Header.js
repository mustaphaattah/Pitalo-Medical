import React from 'react';
import { NavLink } from 'react-router-dom';
import { connect } from 'react-redux';

import { logout } from '../actions';
import sprite from "./assets/sprite.svg";


function Header(props) {
  return (
    <div className="py-6 px-16 shadow-lg bg-white">
      <nav className="flex justify-between">
        <div className="flex items-center">
          <svg className="h-8 w-8">
            <use xlinkHref={`${sprite}#medicine`} />
          </svg>
          <NavLink to="/" onClick={() => props.logout()} className="text-2xl font-bold pl-3 text-gray-700">
            Pitalo Medical
          </NavLink>
        </div>
        <div className="text-lg text-gray-600 font-semibold flex items-center">
          <NavLink to="/patients" onClick={() => props.logout()} className="ml-12 hover:underline">
            Patients
          </NavLink>
          <NavLink to="/staff" onClick={() => props.logout()} className="ml-12 hover:underline">
            Staff
          </NavLink>
          {
            (props.loggedIn)
              ? (
                <React.Fragment>
                  <svg className="h-10 w-10 ml-12 rounded-full bg-gray-200">
                    <use xlinkHref={`${sprite}#${props.sex === 'Male' ? 'doctor-1' : 'doctor'}`} />
                  </svg>
                  <span className="ml-2">{props.name}</span>
                  <NavLink to="/login" onClick={() => props.logout()} className="ml-12 flex items-center">
                    <svg className="h-6 w-6 fill-gray">
                      <use xlinkHref={`${sprite}#logout`} />
                    </svg>
                    <span className="ml-2">Logout</span>
                  </NavLink>
                </React.Fragment>
              )
              : <Link text="Login" to="/login" />             
          }

        </div>
      </nav>
    </div>
  )
}

const Link = (props) => (
  <NavLink to={`${props.to}`} className="ml-16 bg-red-600 hover:bg-red-800 text-white px-8 py-2">
    {props.text}
  </NavLink>
);


const mapStateToProps = ({ loggedIn }) => ({ loggedIn });
export default connect(
  mapStateToProps,
  { logout }
)(Header);

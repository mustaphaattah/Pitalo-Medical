import React from 'react';
import { NavLink } from 'react-router-dom';
import { connect } from 'react-redux';
import { login, logout } from '../actions';
import sprite from "./assets/sprite.svg";


function Header(props) {
  return (
    <div className="py-4 px-16 shadow-lg bg-white">
      <nav className="flex justify-between items-baseline">
        <div className="flex items-center">
          <svg className="h-8 w-8">
            <use xlinkHref={`${sprite}#medicine`} />
          </svg>
          <NavLink to="/" className="text-2xl font-bold pl-3 text-gray-700">
            Pitalo Medical
          </NavLink>
        </div>
        <div className="text-lg text-gray-600 font-semibold">
          <NavLink to="/patients" className="ml-16 hover:underline">
            Patients
          </NavLink>
          <NavLink to="/staff" className="ml-16 hover:underline">
            Staff
          </NavLink>
          {
            (props.loggedIn)
              ? <Link text="Logout" to="/login" func={props.logout} />
              : <Link text="Login" to="/login" func={props.login} />             
          }

        </div>
      </nav>
    </div>
  )
}

const Link = (props) => (
  <NavLink to={`${props.to}`} onClick={() => props.func()} className="ml-16 bg-red-600 hover:bg-red-800 text-white px-8 py-2">
    {props.text}
  </NavLink>
);


const mapStateToProps = ({ loggedIn }) => ({ loggedIn });
export default connect(
  mapStateToProps,
  { login, logout }
)(Header);

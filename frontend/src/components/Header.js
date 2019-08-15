import React from 'react';
import { NavLink } from 'react-router-dom';
import sprite from "./assets/sprite.svg";


export default function Header() {
  return (
    <div className="py-4 px-16 shadow-lg bg-white">
      <nav className="flex justify-between items-baseline">
        <div className="flex items-center">
          <svg className="h-8 w-8">
            <use xlinkHref={`${sprite}#medicine`} />
          </svg>
          <NavLink to="/" className="text-2xl font-bold pl-3">
            Pitalo Medical
          </NavLink>
        </div>
        <div className="text-lg">
          <NavLink to="/patients" className="pl-16 uppercase font-semibold">
            Patients
          </NavLink>
          <NavLink to="/staff" className="pl-16 uppercase font-semibold">
            Staff
          </NavLink>
        </div>
      </nav>
    </div>
  )
}

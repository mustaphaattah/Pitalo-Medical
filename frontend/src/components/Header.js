import React from 'react';
import { NavLink } from 'react-router-dom';
import sprite from "./assets/sprite.svg";


export default function Header() {
  return (
    <div className="py-6 px-16 shadow-lg bg-white">
      <nav className="flex justify-between items-baseline">
        <div className="flex items-center">
          <svg className="h-12 w-12">
            <use xlinkHref={`${sprite}#medicine`} />
          </svg>
          <NavLink to="/" className="text-4xl font-bold pl-3">
            Pitalo Medical
          </NavLink>
        </div>
        <div>
          <NavLink to="/patients" className="pl-16 text-xl uppercase font-semibold">
            Patients
          </NavLink>
          <NavLink to="/" className="pl-16 text-xl uppercase font-semibold">
            Staff
          </NavLink>
        </div>
      </nav>
    </div>
  )
}

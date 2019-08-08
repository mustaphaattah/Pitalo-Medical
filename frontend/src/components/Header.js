import React from 'react';
import { NavLink } from 'react-router-dom';
import sprite from "./assets/sprite.svg";


export default function Header() {
  return (
    <div className="py-8 px-16 shadow-lg bg-white">
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
          <NavLink to="/" className="pl-16 text-lg">
            Patients
          </NavLink>
          <NavLink to="/" className="pl-16 text-lg">
            Staff
          </NavLink>
        </div>
      </nav>
    </div>
  )
}

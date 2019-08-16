import React from 'react';
import { NavLink } from 'react-router-dom';

import { doctorIcon } from '../../utils/doctor-icon';
import sprite from '../assets/sprite.svg';

export default function DoctorItem({ doctor }) {
  return (
    <NavLink to="/" className="flex bg-white w-4/12 mt-6 shadow-md hover:shadow-lg py-4 px-6 m-auto">
      <svg className="h-12 w-12 mr-6">
        <use xlinkHref={`${sprite}#${doctorIcon(doctor.specialty.name)}`} />
      </svg>
      <div className="flex flex-col pl-6 border-l-2 border-gray-400 text-gray-600">
        <span className="font-bold">Dr. {doctor.firstName} {doctor.middleName} {doctor.lastName}</span>
        <span className="font-normal">{doctor.specialty.name}</span>
      </div> 
    </NavLink>
  )
}

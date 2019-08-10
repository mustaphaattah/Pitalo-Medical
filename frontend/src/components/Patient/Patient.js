import React from 'react';
import { NavLink } from 'react-router-dom';

export default function Patient({ patient }) {

  return (
    <div className="flex py-3 border-b-2 border-gray-300 w-10/12 m-auto  text-gray-600">
      <div className="flex-1">
        <span>{patient.firstName} </span>
        <span>{patient.middleName} </span>
        <span>{patient.lastName}</span>
      </div>

      <div className="flex-1">
        <span>{patient.sex}</span>
      </div>

      <div className="flex-1">
        <span>{patient.phoneNumber}</span>
      </div>

      <div className="flex-1">
        <span>{patient.occupation}</span>
      </div>

      <div className="flex-1 text-right">
        <span>{patient.healthNumber}</span>
      </div>

      <div className="flex-1 text-right underline">
        <NavLink to={`/patient/${patient.id}/details`}>View Details</NavLink>
      </div>
    </div>
  )
}

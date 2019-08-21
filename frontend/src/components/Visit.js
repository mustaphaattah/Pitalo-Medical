import React from 'react';
import { NavLink } from 'react-router-dom';
import { timeFormat, dateFormat } from '../utils/date';


export default function Visit({ visit }) {
  const { patient, visitationType } = visit;
  return (
    <NavLink to="/" className="flex bg-white px-6 py-6 items-center shadow mb-3 w-9/12 text-gray-600 hover:shadow-lg m-auto">
      <span className="flex-1">
        {patient.firstName} {patient.middleName} {patient.lastName}
      </span>
      <span className="flex-1">
        {visitationType.type}
      </span>
      <span className="flex-1">
        {dateFormat(visit.time)}
      </span>
      <span className="flex-1 text-right">
        {timeFormat(visit.time)}
      </span>
      <span className={`flex-1 text-center ml-24 rounded-full font-medium py-1 px-6 ${statusColor(visit.status)}`}>
        {visit.status}
      </span>
    </NavLink>
  )
}

const statusColor = (status) => {
  switch(status) {
    case 'Completed':
      return 'bg-green-200 text-green-800';
    case 'Cancelled':
      return 'bg-red-200 text-red-800';
    default: 
      return 'bg-yellow-200 text-yellow-800';
  }
}
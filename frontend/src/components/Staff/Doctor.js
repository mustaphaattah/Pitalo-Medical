import React from 'react';


export default function Doctor({ doctor }) {

  return (
    <div className="flex py-2 border-b-2 border-gray-300 w-10/12 m-auto text-gray-600">
      <div className="flex-1">
        <span>{doctor.firstName} </span>
        <span>{doctor.middleName} </span>
        <span>{doctor.lastName}</span>
      </div>

      <div className="flex-1">
        <span>{doctor.sex}</span>
      </div>

      <div className="flex-1">
        <span>{doctor.specialty.name}</span>
      </div>

      <div className="flex-1">
        <span>{doctor.email}</span>
      </div>
    </div>
  )
}

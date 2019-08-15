import React from 'react';


export default function Nurse({ nurse }) {

  return (
    <div className="flex py-2 border-b-2 border-gray-300 w-10/12 m-auto text-gray-600">
      <div className="flex-1">
        <span>{nurse.firstName} </span>
        <span>{nurse.middleName} </span>
        <span>{nurse.lastName}</span>
      </div>

      <div className="flex-1">
        <span>{nurse.sex}</span>
      </div>

      <div className="flex-1">
        <span>Registered Nurse</span>
      </div>

      <div className="flex-1">
        <span>{nurse.email}</span>
      </div>
    </div>
  )
}
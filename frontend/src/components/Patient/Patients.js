import React, { Component } from 'react'
import Header from '../Header';

class Patients extends Component {

  componentDidMount() {

  }
  
  render() {
    return (
      <div className="w-screen h-screen bg-gray-100">
        <Header />
        <h2 className="text-center text-4xl text-gray-800 uppercase p-10 font-semibold">Patients</h2>
      </div>
    );
  }

}

export default Patients;
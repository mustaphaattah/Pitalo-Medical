import React, { Component } from 'react';
import { connect } from 'react-redux';
import Patient from './Patient';
import { getPatients } from '../../actions';
import Header from '../Header';

class Patients extends Component {

  componentDidMount() {
    this.props.getPatients();
  }

  render() {
    const patients = this.props.patients;
    return (
      <div className="w-screen min-h-screen bg-gray-100">
        <Header />
        <h2 className="text-center text-2xl text-gray-700 uppercase p-10 font-semibold">Patients</h2>
        <div className="flex pt-3 pb-6 border-b-2 border-gray-300 w-10/12 m-auto text-xl text-gray-600 font-semibold">
          <div className="flex-1">Full Name</div>
          <div className="flex-1">Sex</div>
          <div className="flex-1">Phone Number</div>
          <div className="flex-1">Occupation</div>
          <div className="flex-1 text-right">Health Number</div>
        </div>
        {
          patients.map(patient => <Patient patient={patient} key={patient.id} />)
        }
      </div>
    );
  }

}

const mapStateToProps = ({ patients }) => patients;

export default connect(
  mapStateToProps,
  { getPatients }
)(Patients);
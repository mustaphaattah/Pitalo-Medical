import React, { Component } from 'react';
import { connect } from 'react-redux';

import Header from '../Header';
import { getDoctors, getNurses } from '../../actions';
import Footer from '../Footer';
import Doctor from './Doctor';
import Nurse from './Nurse';


class Staff extends Component {
  
  componentDidMount() {
    this.props.getDoctors();
    this.props.getNurses();
  }

  render() {
    const { doctors } = this.props.doctors;
    const { nurses } = this.props.nurses;
    return (
      <div className="flex flex-col w-screen min-h-screen bg-gray-100">
        <Header />
        <h2 className="text-center text-2xl text-gray-700 uppercase p-10 font-semibold">Staff</h2>
        <div className="flex pt-3 pb-6 border-b-2 border-gray-300 w-10/12 m-auto text-xl text-gray-600 font-semibold">
          <div className="flex-1">Full Name</div>
          <div className="flex-1">Sex</div>
          <div className="flex-1">Specialty</div>
          <div className="flex-1">Email</div>
        </div>
        { nurses.map(nurse => <Nurse key={nurse.id} nurse={nurse} />)}
        { doctors.map(doctor => <Doctor key={doctor.id} doctor={doctor} />) }
        <Footer />
      </div>
    )
  }
}


const mapStateToProps = ({ nurses, doctors }) => ({ nurses, doctors });
export default connect(
  mapStateToProps,
  { getDoctors, getNurses }
)(Staff);

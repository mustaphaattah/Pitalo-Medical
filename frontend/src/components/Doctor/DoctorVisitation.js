import React, { Component } from 'react';
import { connect } from 'react-redux';

import { getDoctor, getDoctorVisitations, login } from '../../actions';
import Header from '../Header';
import Visit from '../Visit';


class DoctorVisitation extends Component {

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.login();
    this.props.getDoctor(id, this.props.history);
    this.props.getDoctorVisitations(id)
  }

  render() {
    const { visitations } = this.props.visitations;
    const {
      sex,
      firstName,
      lastName,
      middleName
    } = this.props.doctors.doctor;
    const fullName = `Dr. ${firstName} ${middleName || ''} ${lastName}`;

    return (
      <div className="w-screen min-h-screen bg-gray-200">
        <Header sex={sex} name={fullName}/>

        <h2 className="m-6 font-bold text-2xl text-center text-gray-700">Visits</h2>
        <div className="flex pt-3 px-6 pb-6 border-b-2 border-gray-300 w-9/12 m-auto text-xl text-gray-600 font-semibold">
          <div className="flex-1">Full Name</div>
          <div className="flex-1">Type</div>
          <div className="flex-1">Date</div>
          <div className="flex-1">Time</div>
          <div className="flex-1">Status</div>
        </div>
        {
          visitations.map(visit => <Visit visit={visit} key={visit.id} />)
        }
      </div>
    )
  }
}

const mapStateToProps = ({ doctors, visitations }) => ({ doctors, visitations })
export default connect(
  mapStateToProps,
  { getDoctor, getDoctorVisitations, login }
)(DoctorVisitation);

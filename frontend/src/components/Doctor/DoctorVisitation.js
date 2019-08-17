import React, { Component } from 'react';
import { connect } from 'react-redux';

import { getDoctor, getDoctorVisitations, login } from '../../actions';
import Header from '../Header';


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
        <Header sex={sex} name={fullName} />
      </div>
    )
  }
}

const mapStateToProps = ({ doctors, visitations }) => ({ doctors, visitations })
export default connect(
  mapStateToProps,
  { getDoctor, getDoctorVisitations, login }
)(DoctorVisitation);

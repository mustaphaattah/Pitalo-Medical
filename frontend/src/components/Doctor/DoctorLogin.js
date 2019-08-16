import React, { Component } from 'react';
import { connect } from 'react-redux';

import DoctorItem from './DoctorItem';
import Header from '../Header';
import { getDoctors } from '../../actions';


class DoctorLogin extends Component {
  
  componentDidMount() {
    this.props.getDoctors();
  }

  render() {
    const { doctors } = this.props.doctors;
    return (
      <div className="w-screen min-h-screen bg-gray-200">
        <Header />
        <h3 className="font-bold text-center text-3xl pt-10 text-gray-700 pb-6">Pick a doctor</h3>
        {
          doctors.map(doctor => <DoctorItem key={doctor.id} doctor={doctor} />)
        }
      </div>
    )
  }
}

const mapStateToProps = ({ doctors }) => ({ doctors });
export default connect( 
  mapStateToProps,
  { getDoctors }
)(DoctorLogin);

import React, { Component } from 'react';
import { connect } from 'react-redux';

import Header from '../Header';


class DoctorVisitation extends Component {
  render() {
    return (
      <div className="">
        <Header />
      </div>
    )
  }
}

const mapStateToProps = ({ doctors, visitations }) => ({ doctors, visitations })
export default connect(
  mapStateToProps,
  null
)(DoctorVisitation);

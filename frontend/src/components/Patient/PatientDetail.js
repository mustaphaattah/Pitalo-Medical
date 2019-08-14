import React, { Component } from "react";
import { connect } from "react-redux";
import { getPatientVisitations, getPatient } from "../../actions";
import Header from "../Header";
import { dateFormat } from "../../utils/date";
import { formatAddress } from "../../utils/address";
import { getBloodType } from '../../utils/bloodTypes';
import { historyList } from "../../utils/medicalHistory";

class PatientDetail extends Component {
  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getPatientVisitations(id);
    this.props.getPatient(id, this.props.history);
  }

  render() {
    const { visitations, patients } = this.props;
    const { patient } = patients;
    const { insurance, medicalHistory } = patient;
    console.log(patient);
    return (
      <div className="w-screen min-h-full bg-gray-100">
        <Header />
        <h2 className="text-center text-2xl text-gray-600 uppercase p-10 font-semibold">
          Patient Details
        </h2>

        <div className="w-7/12 m-auto text-gray-600">
          <div className="flex border-b-4 pb-4">
            <div className="w-1/2 font-bold text-xl">Personal Information</div>

            <div className="w-1/2">
              <div className="text-lg">
                <span className="font-medium">Full Name: </span>
                <span className="text-base">
                  {patient.firstName} {patient.middleName} {patient.lastName}
                </span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Sex: </span>
                <span className="text-base">{patient.sex}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Occupation: </span>
                <span className="text-base">{patient.occupation}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Email: </span>
                <span className="text-base">
                  {patient.email || "-"}
                </span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Phone number: </span>
                <span className="text-base">{patient.phoneNumber}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Health number: </span>
                <span className="text-base">{patient.healthNumber}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Registration Date: </span>
                <span className="text-base">
                  {dateFormat(patient.registrationDate)}
                </span>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Address: </span>
                <div className="text-base">
                  {formatAddress(patient.address)}
                </div>
              </div>
            </div>
          </div>

          <div className="flex border-b-4 py-4">
            <div className="w-1/2 font-bold text-xl">Insurance</div>

            <div className="w-1/2">
              <div className="text-lg">
                <span className="font-semibold">Provider: </span>
                <span className="text-base">{insurance ? insurance.provider : ''}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Group Number: </span>
                <span className="text-base">{insurance ? insurance.groupNumber : ''}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Policy Number: </span>
                <span className="text-base">{insurance ? insurance.policyNumber : ''}</span>
              </div>
              <div className="text-lg">
                <span className="font-semibold">Expiry Date: </span>
                <span className="text-base">{insurance ? dateFormat(insurance.expiryDate) : ''}</span>
              </div>
            </div>
          </div>

          <div className="flex border-b-4 py-4">
            <div className="w-1/2 font-bold text-xl">Medical History</div>

            <div className="w-1/2">
              <div className="text-lg">
                <span className="font-semibold">Blood Type: </span>
                <span className="text-base">{medicalHistory ? getBloodType(medicalHistory.bloodType) : ''}</span>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Allergies: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.allergies) : ''}
                </div>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">LifeStyle: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.lifeStyle) : ''}
                </div>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Illnesses: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.illnesses) : ''}
                </div>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Injuries: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.injuries) : ''}
                </div>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Surgeries: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.surgeries) : ''}
                </div>
              </div>
              <div className="text-lg flex">
                <span className="font-semibold pr-2">Medications: </span>
                <div className="text-base">
                  {medicalHistory ? historyList(medicalHistory.medications) : ''}
                </div>
              </div>
            </div>
          </div>

          <div className="flex border-b-4 py-4">
            <div className="w-1/2 font-bold text-xl">Emergency Contacts</div>
          </div>

        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ visitations, patients }) => ({
  visitations,
  patients
});
export default connect(
  mapStateToProps,
  { getPatientVisitations, getPatient }
)(PatientDetail);

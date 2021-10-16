import React, { Component } from "react";
import { Link } from "react-router-dom";
import { withRouter } from "react-router";
import AdminHeaderdropdown from './AdminHeaderDropDown.js';

import AuthenticationService from "../../api/AuthenticationService.js";
export const patientId = AuthenticationService.getId();
class HeaderComponent extends Component {
  render() {
    const isUserLoggerIn = AuthenticationService.isUserLoggedIn();
    const patientId = AuthenticationService.getId();
    let isReceptionist = false;
    let isPatient = false;
    let isDoctor = false;
    let isPharmacist = false;
    let isWardCharge = false;
    let isLabInCharge = false;
    let isAdmin = false;

    if (AuthenticationService.getRole() === "RECEPTIONIST")
      isReceptionist = true;
    if (AuthenticationService.getRole() === "PATIENT") isPatient = true;
    if (AuthenticationService.getRole() === "DOCTOR") isDoctor = true;
    if (AuthenticationService.getRole() === "PHARMACIST") isPharmacist = true;
    if (AuthenticationService.getRole() === "WARDINCHARGE") isWardCharge = true;
    if (AuthenticationService.getRole() === "LABINCHARGE") isLabInCharge = true;
    if (AuthenticationService.getRole() === "ADMIN") isAdmin = true;

    return (
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div className="navbar-brand">e-Hospital</div>
          <ul className="navbar-nav">
            {/* For Patient */}
            {isPatient && (
              <li>
                <Link
                  className="nav-link"
                  to={{ pathname: `/patient/${patientId}` }}
                >
                  {" "}
                  MyDetails
                </Link>
              </li>
            )}
            {isPatient && (
              <li>
                <Link
                  className="nav-link"
                  to={{ pathname: `/patientprescription/${patientId}` }}
                >
                  View Prescription
                </Link>
              </li>
            )}
            {isPatient && (
              <li>
                <Link
                  className="nav-link"
                  to={{ pathname: `/patientappoinment/${patientId}` }}
                >
                  {" "}
                  View Appointment
                </Link>
              </li>
            )}
            {isPatient && (
              <li>
                <Link
                  className="nav-link"
                  to={{ pathname: `/patientreport/${patientId}` }}
                >
                  View Report
                </Link>
              </li>
            )}
            {/* For Receptionist */}
            {isReceptionist && (
              <li>
                <Link className="nav-link" to="/patientsearch">
                  {" "}
                  Search Patient
                </Link>
              </li>
            )}
            {isReceptionist && (
              <li>
                <Link className="nav-link" to="/patient/list/show">
                  Patient List
                </Link>
              </li>
            )}
            {isReceptionist && (
              <li>
                <Link className="nav-link" to="/patient/create/form">
                  {" "}
                  Create Patient
                </Link>
              </li>
            )}
            {isReceptionist && (
              <li>
                <Link className="nav-link" to="/patient/appointment/form">
                  {" "}
                  Book Appointment
                </Link>
              </li>
            )}

            {/* For Doctor */}
            {isDoctor && (
              <li>
                <Link className="nav-link" to="/addPrescription">
                  Add Prescription
                </Link>
              </li>
            )}
            {isDoctor && (
              <li>
                <Link className="nav-link" to="/viewMedicine">
                  View Medicines
                </Link>
              </li>
            )}
            {isDoctor && (
              <li>
                <Link className="nav-link" to="/viewPrescription">
                  View Prescription
                </Link>
              </li>
            )}
            {isDoctor && (
              <li>
                <Link className="nav-link" to="/getPatientReportByPatientID">
                  View Patient Report
                </Link>
              </li>
            )}
            {/* For Pharmacist */}
            {isPharmacist && (
              <li>
                <Link className="nav-link" to="/addMedicine">
                  Add Medicine
                </Link>
              </li>
            )}
            {isPharmacist && (
              <li>
                <Link className="nav-link" to="/medicine">
                  List Medicine
                </Link>
              </li>
            )}
            

            {/* For Ward-Incharge */}
            {isWardCharge && (
              <li>
                <Link className="nav-link" to="/beds">
                  Check Beds Availability
                </Link>
              </li>
            )}
            {isWardCharge && (
              <li>
                <Link className="nav-link" to="/bedinventory">
                  Bed-Inventory
                </Link>
              </li>
            )}
           
            {isWardCharge && (
              <li>
                <Link className="nav-link" to="/allocatedBeds">
                  Check Allocated Bed List to Patients
                </Link>
              </li>
            )}
            {/* For Admin */}
            {isAdmin && (
              <li>
                <Link className="nav-link" to="/add-employee">
                  New Employee Registration
                </Link>
              </li>
            )}
            {isAdmin && (
              <li>
                <Link className="nav-link" to="/employees">
                  Employees List
                 
                </Link>
              </li>
            )}
            {isAdmin && (
              <li>
                <Link className="nav-link" to="/add-department">
                  New Department Creation
                </Link>
              </li>
            )}
            {isAdmin && (
              <li>
                <Link className="nav-link" to="/departments">
                  Department List
                </Link>
              </li>
            )}
            {isAdmin && (
              <li>
                <AdminHeaderdropdown/>
              </li>
            )}
           
            

            {/* For LabInCharge */}
            {isLabInCharge && (
              <li>
                <Link className="nav-link" to="/reports">
                  Report Facilities
                </Link>
              </li>
            )}
            {isLabInCharge && (
              <li>
                <Link className="nav-link" to="/addNewBasicReport">
                  Add New Report Facility
                </Link>
              </li>
            )}
            {isLabInCharge && (
              <li>
                <Link className="nav-link" to="/uploadPatientReport">
                  Upload Patient Report
                </Link>
              </li>
            )}
            {isLabInCharge && (
              <li>
                <Link className="nav-link" to="/getPatientReportByPatientID">
                  Get Patient Report
                </Link>
              </li>
            )}
          </ul>

          <ul className="navbar-nav navbar-collapse justify-content-end">
            {isUserLoggerIn && (
              <li>
                {" "}
                <Link
                  className="nav-link"
                  to="/logout"
                  onClick={AuthenticationService.logout}
                >
                  {" "}
                  Logout{" "}
                </Link>
              </li>
            )}
          </ul>
        </nav>
      </header>
    );
  }
}

export default withRouter(HeaderComponent);

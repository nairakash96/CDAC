import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import HomeComponent from "./Generic/HomeComponent.jsx";
import AuthenticatedRoute from "./Generic/AuthenticatedRoute.jsx";
import HeaderComponent from "./Generic/HeaderComponent.jsx";
import FooterComponent from "./Generic/FooterComponent.jsx";
import EmployeeLoginComponent from "./Generic/EmployeeLoginComponent.jsx";
import PatientLoginComponent from "./Generic/PatientLoginComponent.jsx";
import LogoutComponent from "./Generic/LogoutComponent.jsx";
import ErrorComponent from "./Generic/ErrorComponent.jsx";

import CreatPatientComponent from "./Receptionist/CreatPatientComponent.jsx";
import PatientSearchComponent from "./Receptionist/PatientSearchComponent.jsx";
import UpdatePatientComponent from "./Receptionist/UpdatePatientComponent.jsx";
import PatientListComponent from "./Receptionist/PatientListComponent.jsx";
import ReceptionistComponent from "./Receptionist/ReceptionistComponent.jsx";
import AppointmentComponent from "./Receptionist/AppointmentComponent.jsx";

import PatientComponent from "./Patient/PatientComponent.jsx";
import ListAppointmentComponent from "./Patient/ListAppointmentComponent.jsx";
import ListPrescriptionComponent from "./Patient/ListPrescritionComponent.jsx";
import ListReportComponent from "./Patient/ListReportComponent.jsx";

import AddPrescription from "./Doctor/AddPrescription.jsx";
import ViewMedicine from "./Doctor/ViewMedicine.jsx";
import ViewPrescription from "./Doctor/ViewPrescription.jsx";
import DoctorComponent from "./Doctor/DoctorComponent.jsx";
import ViewPrescriptionDoctor from "./Doctor/ViewPrescriptionDoctor.jsx";

import AllocateBedToPatient from "./WardIncharge/AllocateBedToPatient.jsx";
import ListAvailableBeds from "./WardIncharge/ListAvailableBeds.jsx";
import ListAllocatedBeds from "./WardIncharge/ListAllocatedBeds.jsx";
import ListAllBeds from "./WardIncharge/ListAllBeds.jsx";
import WardInchargeComponent from "./WardIncharge/WardInchargeComponent"

import ListMedicineComponent from "./Pharmacist/ListMedicineComponent.jsx";
import UpdateMedicineComponent from "./Pharmacist/UpdateMedicineComponent.jsx";
import AddMedicineComponent from "./Pharmacist/AddMedicineComponent.jsx";
import AdminComponent from "./Admin/AdminComponent"
import EmployeesListComponent from "./employee/EmployeesListComponent";
import updateEmployeeComponent from "./employee/updateEmployeeComponent";
import AddDepartmentComponent from "./department/AddDepartmentComponent";
import DepartmentListComponent from "./department/DepartmentListComponent";
import LabInchargeComponent from "./LabInCharge/LabInchargeComponent"
import GetPatientReportByPatientID from "./LabInCharge/GetPatientReportByPatientID";
import UploadPatientReport from "./LabInCharge/UploadPatientReport";
import ListBasicReportDetails from "./LabInCharge/ListBasicReportDetails";
import AddNewBasicReport from "./LabInCharge/AddNewBasicReport";
import PharmacistComponent from "./Pharmacist/PharmacistComponent.jsx";
import AddEmployeeComponent from "./employee/AddEmployeeComponent.js";
class HospitalApp extends Component {
  render() {
    return (
      <div>
        <Router>
          <HeaderComponent />
          <Switch>
            {/* Generic-Sayali */}
            <Route exact path="/" component={HomeComponent} />
            <Route exact path="/login" component={EmployeeLoginComponent} />
            <Route
              exact
              path="/patientlogin"
              component={PatientLoginComponent}
            />
            <AuthenticatedRoute
              exact
              path="/logout"
              component={LogoutComponent}
            />

            {/* Patient-Sayali */}
            <AuthenticatedRoute
              exact
              path="/patient/:id"
              component={PatientComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patientappoinment/:pid"
              component={ListAppointmentComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patientprescription/:pid"
              component={ListPrescriptionComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patientreport/:pid"
              component={ListReportComponent}
            />

            {/* Receptionist-Sayali */}
            <AuthenticatedRoute
              exact
              path="/patient/create/form"
              component={CreatPatientComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patient/:id/update"
              component={UpdatePatientComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patient/list/show"
              component={PatientListComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patientsearch"
              component={PatientSearchComponent}
            />
            <AuthenticatedRoute
              exact
              path="/receptionist"
              component={ReceptionistComponent}
            />
            <AuthenticatedRoute
              exact
              path="/patient/appointment/form"
              component={AppointmentComponent}
            />

            {/* Doctor-akash */}
            <AuthenticatedRoute
              exact
              path="/doctor"
              component={DoctorComponent}
            />
            <AuthenticatedRoute
              exact
              path="/addPrescription"
              component={AddPrescription}
            />
            <AuthenticatedRoute
              exact
              path="/viewMedicine"
              component={ViewMedicine}
            />
            <AuthenticatedRoute
              exact
              path="/viewPrescription"
              component={ViewPrescriptionDoctor}
            />
            <AuthenticatedRoute
              exact
              path="/viewAllPrescription"
              component={ViewPrescription}
            />

            {/* Pharmacist-chaitali */}
            <AuthenticatedRoute
              path="/pharmacist"
              exact
              component={PharmacistComponent}
            />
            <AuthenticatedRoute
              path="/medicine"
              exact
              component={ListMedicineComponent}
            />
            <AuthenticatedRoute
              path="/addMedicine"
              exact
              component={AddMedicineComponent}
            />
            <AuthenticatedRoute
              path="/updateMedicine"
              exact
              component={UpdateMedicineComponent}
            />

            {/* Ward incharge-chaitali */}
            <AuthenticatedRoute
              path="/wardInCharge"
              exact
              component={WardInchargeComponent}
            />
            <AuthenticatedRoute
              path="/beds"
              exact
              component={ListAvailableBeds}
            />
            <AuthenticatedRoute
              path="/bedinventory"
              exact
              component={ListAllBeds}
            />
            <AuthenticatedRoute
              path="/allocateBedToPatient"
              exact
              component={AllocateBedToPatient}
            />
            <AuthenticatedRoute
              path="/allocatedBeds"
              exact
              component={ListAllocatedBeds}
            />

            {/* Admin-atul */}
            <AuthenticatedRoute
              path="/admin"
              exact
              component={AdminComponent}
            />
            <AuthenticatedRoute
              path="/employees"
              exact
              component={EmployeesListComponent}
            />
            <AuthenticatedRoute
              path="/add-employee"
              exact
              component={AddEmployeeComponent}
            />
            <AuthenticatedRoute
              path="/edit-employee"
              exact
              component={updateEmployeeComponent}
            />
            <AuthenticatedRoute
              path="/add-department"
              exact
              component={AddDepartmentComponent}
            />
            <AuthenticatedRoute
              path="/departments"
              exact
              component={DepartmentListComponent}
            />

            {/* LabIncharge-chaitali */}
            
              <AuthenticatedRoute
              path="/labInCharge"
              exact
              component={LabInchargeComponent}
            />
              <AuthenticatedRoute
              path="/reports"
              exact
              component={ListBasicReportDetails}
            />
            <AuthenticatedRoute
              path="/addNewBasicReport"
              exact
              component={AddNewBasicReport}
            />
            <AuthenticatedRoute
              path="/uploadPatientReport"
              exact
              component={UploadPatientReport}
            />
            <AuthenticatedRoute
              path="/getPatientReportByPatientID"
              exact
              component={GetPatientReportByPatientID}
            />
            {/** <Route component={ErrorComponent} />*/}
          </Switch>
          <FooterComponent />
        </Router>
      </div>
    );
  }
}
export default HospitalApp;

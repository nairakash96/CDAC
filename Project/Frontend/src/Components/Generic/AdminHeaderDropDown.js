import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Dropdown from 'react-bootstrap/Dropdown';
  
export default function App() {
  return (
    <div>
      <Dropdown style={{backgroundColor:"#343a40"}}>
        <Dropdown.Toggle variant="" style={{color:"#ffffff80"}}>
            Additional Features
        </Dropdown.Toggle>
        <Dropdown.Menu>
          <Dropdown.Item href="/viewAllPrescription">
            View Prescriptions
          </Dropdown.Item>
          <Dropdown.Item href="/medicine">
            View Medicines
          </Dropdown.Item>
          <Dropdown.Item href="/reports">
            View Basic Reports
          </Dropdown.Item>
          <Dropdown.Item href="/getPatientReportByPatientID">
            View Patient Reports
          </Dropdown.Item>

          <Dropdown.Item href="/patient/create/form">
            Patient Registration
          </Dropdown.Item>

        
          <Dropdown.Item href="/patient/:id/update">
            Update Patient
          </Dropdown.Item>
          <Dropdown.Item href="/patient/list/show">
            Patients List
          </Dropdown.Item>
          <Dropdown.Item href="/patientsearch">
           Search Patient Detail
          </Dropdown.Item>

         

          <Dropdown.Item href=" /patient/appointment/form">
           Book Appointment for Patient
          </Dropdown.Item>
          <Dropdown.Item href=" /addMedicine">
           Add New Medicine Details
          </Dropdown.Item>
          <Dropdown.Item href=" /updateMedicine">
          Update Medicine Details
          </Dropdown.Item>


          <Dropdown.Item href=" /beds">
         List Available Beds
          </Dropdown.Item>
          <Dropdown.Item href=" /bedinventory">
          Bed Inventory
          </Dropdown.Item>
          <Dropdown.Item href=" /allocatedBeds">
          List Allocated Beds 
          </Dropdown.Item>
          <Dropdown.Item href=" /allocateBedToPatient">
           Allocate Bed to Patient
          </Dropdown.Item>


          <Dropdown.Item href=" /addNewBasicReport">
           Add New Basic Report
          </Dropdown.Item>
          <Dropdown.Item href=" /uploadPatientReport">
          Update Patient Report
          </Dropdown.Item>


        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}
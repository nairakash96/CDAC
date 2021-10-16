import React, { Component } from 'react'
import ReceptionistService from "../../api/ReceptionistService.js"

class PatientListComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            patients: [],
            message: ""
        }

        this.deletePatientClicked = this.deletePatientClicked.bind(this)
        this.updatePatientClicked = this.updatePatientClicked.bind(this)
        this.refreshPatients = this.refreshPatients.bind(this)

    }

    componentDidMount() {
        this.refreshPatients()
    }

    refreshPatients() {
        ReceptionistService.retriveAllPatients()
            .then(
                response => {
                    this.setState({ patients: response.data })
                }
            )
    }

    render() {
        return (
            <div>

                {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
                <div className="container py-4">
                    <h1 >Patient List</h1><br></br>
                    <table className="table">
                        <thead className="thead-dark">
                            <tr>
                                {/* <th>ID</th> */}
                                <th>Patient Name</th>
                                <th>Patient Email</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Bill</th>
                                <th>Type</th>
                                <th>Update</th>
                                <th>Delete</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.patients.map(
                                    patient =>
                                        <tr key={patient.id}>
                                            <td>{patient.patientName}</td>
                                            <td>{patient.patientEmail}</td>
                                            <td>{patient.age}</td>
                                            <td>{patient.gender}</td>
                                            <td>{patient.totalBillAmount}</td>
                                            <td>{patient.patientType}</td>
                                            <td><button className="btn btn-success" onClick={() => this.updatePatientClicked(patient.id)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deletePatientClicked(patient.id)}>Delete</button></td>
                                        </tr>
                                )}
                        </tbody>
                    </table>
                </div>
            </div >
        )
    }

    deletePatientClicked(id) {
        console.log("deletePatientClicked");
        ReceptionistService.deletePatient(id)
            .then(
                response => {
                    this.setState({ message: `Deleted Successfully` })
                    this.refreshPatients()
                    setTimeout(() => {
                        this.setState({ message: "" });
                    }, 2000);
                }
            )
    }
    updatePatientClicked(id) {

        this.props.history.push(`/patient/${id}/update`)

    }
}

export default PatientListComponent
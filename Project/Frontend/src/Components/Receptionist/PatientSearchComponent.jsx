import React, { Component } from 'react'
import ReceptionistService from "../../api/ReceptionistService.js"
import swal from "sweetalert";

class PatientSearchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            setText: "",
            description: '',
            patient: {
                id: '',
                patientName: '',
                patientEmail: '',
                age: '',
                gender: '',
                patientType: '',
                totalBillAmount: ""
            },
            showPatient: false,
            showError: false
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.onChange = this.onChange.bind(this)


    }


    onSubmit = evt => {
        evt.preventDefault();
        if (this.state.setText === "") {
            swal({
                title: "Please Enter Something",
                icon: "error",
                button: "OK",
            });
        } else {
            ReceptionistService.getPatient(this.state.setText)
                .then(
                    response =>
                        this.setState({
                            description: response.data.message,
                            patient: {
                                id: response.data.id,
                                patientName: response.data.patientName,
                                patientEmail: response.data.patientEmail,
                                age: response.data.age,
                                gender: response.data.gender,
                                patientType: response.data.patientType,
                                totalBillAmount: response.data.totalBillAmount
                            },
                            showPatient: true,
                            showError: false
                        })
                )
                .catch(() =>
                    this.setState({
                        showPatient: false,
                        showError: true,
                        description: "Invalid Id"
                    }))
            console.log(this.state.patient);


        }
    };

    onChange = (evt) => {
        this.setState({
            setText: evt.target.value
        });
    }

    deleteClicked(id) {
        console.log("deletePatientClicked");
        ReceptionistService.deletePatient(id)
            .then(
                response => {
                    this.setState({
                        description: `Deleted Successfully`,
                        showPatient: false,
                        showError: true
                    })

                    setTimeout(() => {
                        this.setState({
                            description: "",
                            showError: false,
                            setText: ""
                        });
                    }, 2000);
                }
            )
    }
    updateClicked(id) {

        this.props.history.push(`/patient/${id}/update`)

    }
    render() {
        return (

            <div>
                {this.state.showError && <div className="alert alert-warning">{this.state.description}</div>}
                <div className="addMedicineForm">
                    <div>
                        <form onSubmit={this.onSubmit}>
                            <h4 className="modal-title">Get Patient Details</h4>
                            <div className="form-group">
                                <input
                                    type="text"
                                    name="text"
                                    placeholder="search patient.."
                                    value={this.state.setText}
                                    onChange={this.onChange}
                                    className="form-control"
                                ></input>
                            </div>
                            <div>
                                <button type="submit" className="btn btn-success">
                                    Search Patient
                                </button>
                            </div>
                        </form>
                    </div>
                </div>





                {
                    this.state.showPatient && <>
                        <div class="container p-3 mb-2 col-4 bg-dark text-white">
                            <h2>Patient Details</h2>
                        </div>
                        <div class="container card p-card col-lg-4 bg-light text-dark">
                            <p class="card-text">ID: {this.state.patient.id}</p>
                            <p class="card-text">Name: {this.state.patient.patientName}</p>
                            <p class="card-text">Email: {this.state.patient.patientEmail}</p>
                            <p class="card-text">Gender: {this.state.patient.gender}</p>
                            <p class="card-text">Age: {this.state.patient.age}</p>
                            <p class="card-text">Type: {this.state.patient.patientType}</p>
                            <p class="card-text">Bill: {this.state.patient.totalBillAmount}</p>
                        </div>
                        <br></br>
                        <div class="col-xs ">
                            <button className="btn btn-success col-1 mx" onClick={() => this.updateClicked(this.state.patient.id)}> Update</button>
                            <button className="btn btn-success col-1 mx" onClick={() => this.deleteClicked(this.state.patient.id)}> Delete</button>
                        </div></>
                }
            </div >
        )
    }
}

export default PatientSearchComponent

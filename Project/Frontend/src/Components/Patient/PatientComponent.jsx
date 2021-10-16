import React, { Component } from 'react'
import ReceptionistService from "../../api/ReceptionistService.js"
import swal from "sweetalert";

class PatientComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            description: '',
            patient: {
                id: '',
                patientName: '',
                patientEmail: '',
                age: '',
                password: "",
                gender: '',
                patientType: '',
                totalBillAmount: 0
            }
        }
        this.payClicked = this.payClicked.bind(this)
    }

    componentDidMount() {

        ReceptionistService.getPatient(this.state.id)
            .then(
                response =>
                    this.setState({
                        description: response.data.message,
                        patient: {
                            id: response.data.id,
                            patientName: response.data.patientName,
                            patientEmail: response.data.patientEmail,
                            age: response.data.age,
                            password: response.data.password,
                            gender: response.data.gender,
                            patientType: response.data.patientType,
                            totalBillAmount: response.data.totalBillAmount
                        }
                    })
            )
        console.log(this.state.patient);
    }

    payClicked() {
        let patient = this.state.patient
        this.setState({

            patient: {
                id: patient.id,
                patientName: patient.patientName,
                patientEmail: patient.patientEmail,
                age: patient.age,
                password: patient.password,
                gender: patient.gender,
                patientType: patient.patientType,
                totalBillAmount: 0
            }
        })

        ReceptionistService.putPatient(this.state.patient.id,
            this.state.patient.patientName,
            this.state.patient.patientEmail,
            this.state.patient.password,
            this.state.patient.patientType,
            this.state.patient.gender,
            this.state.patient.age,
            0).then(
                () => {

                    swal({
                        title: "Payment Successfull",
                        icon: "success",
                        button: "OK",
                    });
                })
            .catch(
                () => {
                    swal({
                        title: "Failed to pay",
                        icon: "error",
                        button: "OK",
                    });
                }
            )
    }

    render() {

        return (
            <>

                <div>
                    <br></br><br></br><br></br> <br></br>
                </div>
                <div class="container p-3 mb-2  col-4 bg-dark text-white">
                    <h2>Patient Details</h2>
                </div>
                <div class="container card p-card col-lg-4 bg-light text-dark border-style">
                    <p class="card-text">ID: {this.state.patient.id}</p>
                    <p class="card-text">Name: {this.state.patient.patientName}</p>
                    <p class="card-text">Email: {this.state.patient.patientEmail}</p>
                    <p class="card-text">Gender: {this.state.patient.gender}</p>
                    <p class="card-text">Age: {this.state.patient.age}</p>
                    <p class="card-text">Type: {this.state.patient.patientType}</p>
                    <p class="card-text" style={{ fontSize: "19px" }}>Total Bill Amount: {this.state.patient.totalBillAmount}
                        <button className="btn btn-info btnsmall w-25 h-50 " style={{ marginLeft: "35px" }} onClick={this.payClicked} >Pay</button></p>

                </div>
            </>
        )
    }
}

export default PatientComponent
import React, { Component } from 'react';
import DoctorApiService from '../../api/DoctorApiService';
import swal from "sweetalert";

import '../Pharmacist/AddMedicineComponent.css'
class AddPrescription extends Component {
    constructor(props) {
        super(props);
        this.state = {
            docId: 0,
            patientId: 0,
            prec: '',
            diag: '',
            precDate: '',
            message: null,
            validationMessage: ''

        }
        this.savePrescription = this.savePrescription.bind(this);
    }



    savePrescription = (e) => {
        e.preventDefault();
        if (this.state.docId === '') {
            alert("DocId is Mandatory");
        }
        else {
            let prescription = {
                doctor: {
                    doctorId: this.state.docId
                },
                patient: {
                    id: this.state.patientId
                },
                prescription: this.state.prec,
                diagnosis: this.state.diag,
                prescriptionDate: this.state.precDate
            }
            DoctorApiService.addPrescription(prescription)
                .then(resp => {
                    console.log(resp.data);
                    this.setState({ message: 'Prescription Added Successfully' });
                    swal({
                        title: this.state.message,
                        text: this.state.message,
                        icon: "success",
                        button: "Done",
                      });
                    this.props.history.push('/prescription');
                }).catch(err => {
                    console.error(err.response.data);
                    swal({
                        title: this.state.message,
                        text: "Please fill all the fields",
                        icon: "error",
                        button: "OK",
                      });
                    this.props.history.push('/prescription')
                });
        }
    }

    onChange = (e) => {

        this.setState({ [e.target.name]: e.target.value });
    }

    render() {
        return (
            <div>
                 <div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Create Prescription</h4>

                                <div className="form-group">
                                   Doctor ID :
                                <input type="number" placeholder="Enter Doctor Id" name="docId" className="form-control" value={this.state.docId} onChange={this.onChange} />
                                </div>

                                <div className="form-group">
                                    Patient ID :
                                <input type="number" placeholder="Enter Patient Id" name="patientId" className="form-control" value={this.state.patientId} onChange={this.onChange} />
                                </div>
                                <div className="form-group">
                                <input type="text" placeholder="Enter Patient diagnosis" name="diag" className="form-control" value={this.state.diag} onChange={this.onChange} />
                                </div>
                                <div className="form-group">
                                <textarea cols="120" rows="5" name="prec" className="form-control" placeholder="Enter Prescription" value={this.state.prec} onChange={this.onChange}/>
                                </div>
                                <div className="form-group">
                                <input type="date" placeholder="Enter Date" name="precDate" className="form-control" value={this.state.precDate} onChange={this.onChange} />
                                </div>
                                <button className="btn btn-success" onClick={this.savePrescription}>Save </button>
                            </form>
                    </div>

                </div>
                
        );
    }

}

export default AddPrescription;
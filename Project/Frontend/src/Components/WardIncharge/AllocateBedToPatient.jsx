import React, { Component } from 'react'
import WardInchargeApiService from '../../api/WardInchargeApiService.js';
import swal from "sweetalert";
import '../Pharmacist/AddMedicineComponent.css'


class AllocateBedToPatient extends Component {

    constructor(props) {
        super(props);
        this.state = {
            allocatedBedID: '',
            allocatedToPatientID: '',
            fromDate: '',
            toDate: '',
            message: null
        }
        this.saveAllocatedBedToPatient = this.saveAllocatedBedToPatient.bind(this);
        this.loadBedDetails = this.loadBedDetails.bind(this);
    }

    componentDidMount() {
        this.loadBedDetails();
    }

    loadBedDetails() {
        WardInchargeApiService.fetchBedById(window.localStorage.getItem("bedId"))
            .then((res) => {
                let bed = res.data;
                console.log(bed);
                this.setState({
                    allocatedBedID: bed.id,

                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveAllocatedBedToPatient = (e) => {
        e.preventDefault();
        
        let patientbed = {
            allocatedBedID: this.state.allocatedBedID,
            allocatedToPatientID: this.state.allocatedToPatientID,
            fromDate: this.state.fromDate,
            toDate: this.state.toDate
        };
        WardInchargeApiService.allocateBedToPatient(patientbed.allocatedBedID, patientbed.allocatedToPatientID, patientbed.fromDate, patientbed.toDate)
            .then(res => {
                this.setState({ message: res.data.message });
                swal({
                    title: "",
                    text: this.state.message,
                    button: "Ok",
                  });
                  this.props.history.push('/bedinventory');
            })
            .catch(err => {
                this.setState({ message: err.message });
                swal({
                    title: "",
                    text: this.state.message,
                    icon: "error",
                    button: "OK",
                  });
                  this.props.history.push('/bedinventory');

            });
        console.log(this.state.message);


    }

    render() {
        return (
            <div>
                 <div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Allocate Bed To Patient</h4>

                                <div className="form-group">
                                   
                                <input type="number" name="allocatedToPatientID" className="form-control" onChange={this.onChange} />
                                </div>

                                <div className="form-group">
                                <input type="date" name="fromDate" className="form-control" onChange={this.onChange} />
                                </div>

                                <div className="form-group">
                                <input type="date" name="toDate" className="form-control" onChange={this.onChange} />
                                </div>
                                <button className="btn btn-success" onClick={this.saveAllocatedBedToPatient}>Allocate Bed to Patient</button>
                            </form>
                    </div>
               
            </div>

        );
    }
}

export default AllocateBedToPatient;
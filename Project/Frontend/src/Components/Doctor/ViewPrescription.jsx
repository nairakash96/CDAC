import React, { Component } from 'react'
import DoctorApiService from "../../api/DoctorApiService";

class ViewPrescription extends Component {

    constructor(props) {
        super(props)
        this.state = {
            prescriptions: [],
            message: null
        }
        this.reloadPrescriptionList = this.reloadPrescriptionList.bind(this);
    }

    componentDidMount() {
        this.reloadPrescriptionList();
    }

    reloadPrescriptionList() {
        DoctorApiService.fetchPrescription()
            .then((resp) => {
                this.setState({ prescriptions: resp.data })
                console.log(this.state.prescriptions);
            });
    }

    render() {
        return (
            <div style={{width:"80%",margin:"auto"}}>
                <h2 className="text-center">Prescription Details</h2>


                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Prescription ID</th>
                            <th>Doctor Name</th>
                            <th>Department</th>
                            <th>Patient Name</th>
                            <th>Diagnosis</th>
                            <th>Prescription</th>
                            <th>Prescription Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.prescriptions.map(
                                p =>
                                    <tr key={p.id}>
                                        <td>{p.id}</td>
                                        <td>{p.doctorName}</td>
                                        <td>{p.deptName}</td>
                                        <td>{p.patientName}</td>
                                        <td>{p.diagnosis}</td>
                                        <td>{p.precDec}</td>
                                        <td>{p.precDate}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        );
    }

}

export default ViewPrescription;
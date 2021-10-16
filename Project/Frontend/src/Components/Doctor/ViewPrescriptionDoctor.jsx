import React, { Component } from 'react'
import DoctorApiService from "../../api/DoctorApiService";

class ViewPrescriptionDoctor extends Component {

    constructor(props) {
        super(props)
        this.state = {
            id:this.props.match.params.did,
            prescriptions: [],
        }

    }

    componentDidMount() {
        DoctorApiService.fetchPrescription(this.state.id)
            .then((resp) => {
                console.log("response")
                console.log(resp)
                this.setState({ prescriptions: resp.data 
                })
            })
        .catch((error)=>{
            console.log(error);
        });
    }

    render() {
        return (
            <div>
                <div className="container table-responsive py-5">

                <h2 className="text-center">Prescription Details</h2>
<br></br>
<table className="table  table-hover table-bordered"  >
    <thead className="thead-dark">
                        <tr>
                            <th>Prescription ID</th>
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
</div>
        );
    }

}

export default ViewPrescriptionDoctor;
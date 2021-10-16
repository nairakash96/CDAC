import React, { Component } from 'react'
import PatientService from "../../api/PatientService.js"

class ListPrescriptionComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.pid,
            prescription: []
        }
    }
    componentDidMount() {
        PatientService.getPrescriptionList(this.state.id)
            .then((response) => {
                console.log("response")
                console.log(response)
                this.setState({
                    prescription: response.data
                });

            })
            .catch((error) => {
                console.log(error);
            });
    }
    render() {
        return (
            <div>
                <div class="row mt-5 ml-3 mr-3 justify-content-center">
                    {this.state.prescription.length !== 0 && <div className="container py-4">
                        <h1 >Patient Prescription List</h1><br></br>
                        <table className="table">
                            <thead className="thead-dark">
                                <tr>
                                    <th>Prescription Id</th>
                                    <th>Date</th>
                                    <th>Doctor Name</th>
                                    <th>Prescription</th>
                                    <th>Diagnosis</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.prescription.map(function (data, index) {

                                    return (
                                        <tr key={index}>
                                            <td>{data.id}</td>
                                            <td>{data.precDate}</td>
                                            <td>{data.doctorName}</td>
                                            <td>{data.precDec}</td>
                                            <td>{data.diagnosis}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>}
                    {(this.state.prescription.length) === 0 && <h1>No Prescription</h1>}
                </div>
            </div>
        )
    }
}

export default ListPrescriptionComponent
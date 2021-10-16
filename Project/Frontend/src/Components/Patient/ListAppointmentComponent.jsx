import React, { Component } from 'react'
import PatientService from "../../api/PatientService.js"

class ListAppointmentComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.pid,
            appointment: []
        }
    }
    componentDidMount() {
        PatientService.getAppoinmentList(this.state.id)
            .then((response) => {
                console.log("response")
                console.log(response)
                this.setState({
                    appointment: response.data
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
                    {this.state.appointment.length !== 0 && <div className="container py-4">
                        <h1 >Patient Apppointment List</h1><br></br>
                        <table className="table">
                            <thead className="thead-dark">
                                <tr>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Doctor Name</th>
                                    <th>Doctor Email</th>
                                    <th>Department Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.appointment.map(function (data, index) {

                                    return (
                                        <tr key={index}>
                                            <td>{data.date}</td>
                                            <td>{data.time}</td>
                                            <td>{data.doctorName}</td>
                                            <td>{data.doctorEmail}</td>
                                            <td>{data.deptName}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>}
                    {(this.state.appointment.length) === 0 && <h1>No Appointment</h1>}
                </div>
            </div>
        )
    }
}
export default ListAppointmentComponent
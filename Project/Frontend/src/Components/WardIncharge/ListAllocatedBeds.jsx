import React, { Component } from 'react'
import WardInchargeApiService from '../../api/WardInchargeApiService.js';

class ListAllocatedBeds extends Component {

    constructor(props) {
        super(props)
        this.state = {
            beds: [],
            message: null
        }
        this.reloadBedsList = this.reloadBedsList.bind(this);

    }

    componentDidMount() {
        this.reloadBedsList();
    }

    reloadBedsList() {
        WardInchargeApiService.fetchAllAllocatedBeds()
            .then((resp) => {
                this.setState({ beds: resp.data })
                console.log(this.state.beds);
            });

    }


    render() {
        return (
            <div>
                <div class="container table-responsive py-5">
                    <h2 className="text-center role">List of Allocated Beds to Patient</h2>

                    <br></br><br></br>
                    <table className="table  table-hover table-bordered"  >
                        <thead class="thead-dark">
                            <tr>

                                <th>Bed  ID</th>
                                <th>Patient ID</th>
                                <th>From Date</th>
                                <th>To Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.beds.map(
                                    bed =>
                                        <tr key={bed.id}>
                                            <td>{bed.allocatedBedID}</td>
                                            <td>{bed.allocatedToPatientID.id}</td>
                                            <td>{bed.fromDate}</td>
                                            <td>{bed.toDate}</td>

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

export default ListAllocatedBeds;
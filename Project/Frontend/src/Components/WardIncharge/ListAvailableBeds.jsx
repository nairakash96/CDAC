import React, { Component } from 'react'
import WardInchargeApiService from '../../api/WardInchargeApiService.js';


class ListAvailableBeds extends Component {

    constructor(props) {
        super(props)
        this.state = {
            beds: [],
            message: null
        }
        this.reloadBedsList = this.reloadBedsList.bind(this);
        this.allocateBed = this.allocateBed.bind(this);

    }

    componentDidMount() {
        this.reloadBedsList();
    }

    reloadBedsList() {
        WardInchargeApiService.fetchAvailableBeds()
            .then((resp) => {
                this.setState({ beds: resp.data })
                console.log(this.state.beds);
            });
    }

    allocateBed(bedId) {
        window.localStorage.setItem("bedId", bedId);
        this.props.history.push('/allocateBedToPatient');
    }


    render() {
        return (
            <div>
                <div class="container table-responsive py-5">
                <h2 className="text-center role">List of Available Beds</h2>
                <br></br>
                
                <table className="table  table-hover table-bordered"  >
                    <thead class="thead-dark">
                        <tr>

                            <th>Bed  ID</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                                    {
                                        this.state.beds.map(
                                            bed =>
                                                <tr key={bed.id}>
                                                    <td>{bed.id}</td>
                                                    {bed.status === 0 && <td>Available</td>}

                                                    <td>
                                                        <button className="btn btn-success" onClick={() => this.allocateBed(bed.id)} style={{ marginLeft: '20px' }}> Allocate Bed to Patient</button>
                                                    </td>
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

export default ListAvailableBeds;
import React, { Component } from 'react'
import WardInchargeApiService from '../../api/WardInchargeApiService.js';
import swal from "sweetalert";


class ListAllBeds extends Component {

    constructor(props) {
        super(props)
        this.state = {
            beds: [],
            message: null
        }
        this.reloadBedsList = this.reloadBedsList.bind(this);
        this.saveNewBed = this.saveNewBed.bind(this);

    }

    componentDidMount() {
        this.reloadBedsList();
    }

    reloadBedsList() {
        WardInchargeApiService.fetchAllBeds()
            .then((resp) => {
                this.setState({ beds: resp.data })
                console.log(this.state.beds);
            });
    }

    saveNewBed = (e) => {
        let bed = {
            status: 0
        }
        WardInchargeApiService.addNewBed(bed)
            .then(resp => {
                console.log(resp.data);
                this.setState({ message: 'Bed  Added Successfully' });
                swal({
                    title: this.state.message,
                    text: "Bed  ID : " + resp.data.id,
                    icon: "success",
                    button: "Done",
                  });
                this.props.history.push('/beds');
            })
           
    }


    render() {
        return (
            <div class="container table-responsive py-5">
                <h2 className="text-center role">Bed Inventory</h2>
                <br></br>
                <button className="btn btn-success" onClick={this.saveNewBed}>Add New Bed </button>
                <br></br>
                <br></br>
                <table className="table  table-hover table-bordered"  >
                    <thead class="thead-dark">
                        <tr>

                            <th>Bed  ID</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.beds.map(
                                bed =>
                                    <tr key={bed.id}>
                                        <td>{bed.id}</td>
                                        {bed.status === 0 ? <td>Available</td> : <td> Allocated</td>}

                                    </tr>
                            )
                        }
                    </tbody>
                </table>




            </div>
        );
    }

}

export default ListAllBeds;
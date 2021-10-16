import React, { Component } from 'react'
import DoctorApiService from '../../api/DoctorApiService'
class ViewMedicine extends Component {

    constructor(props) {
        super(props)
        this.state = {
            medicines: [],
            message: null
        }
        this.reloadMedicineList = this.reloadMedicineList.bind(this);
    }

    componentDidMount() {
        this.reloadMedicineList();
    }

    reloadMedicineList() {
        DoctorApiService.fetchMedicines()
            .then((resp) => {
                this.setState({ medicines: resp.data })
                console.log(this.state.medicines);
            });
    }

    render() {
        return (
            <div>
                <div className="container table-responsive py-5">

                <h2 className="text-center">Medicine Stock Details</h2>
<br></br>
<table className="table table-hover " style={{borderStyle:"hidden"}}>
                    <thead className="thead-dark">
                        <tr>

                            <th>Medicine ID</th>
                            <th>Medicine Name</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.medicines.map(
                                medicine =>
                                    <tr key={medicine.id}>
                                        <td>{medicine.id}</td>
                                        <td>{medicine.name}</td>
                                        <td>{medicine.quantity}</td>
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

export default ViewMedicine;
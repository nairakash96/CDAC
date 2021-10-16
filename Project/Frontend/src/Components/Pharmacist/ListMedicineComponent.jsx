import React, { Component } from 'react'
import PharmacistApiService from '../../api/PharmacistApiService';
import swal from "sweetalert";

class ListMedicineComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            medicines: [],
            message: null
        }
        this.reloadMedicineList = this.reloadMedicineList.bind(this);
        this.addMedicine = this.addMedicine.bind(this);
        this.updateMedicine = this.updateMedicine.bind(this);
        this.deleteMedicine = this.deleteMedicine.bind(this);
    }

    componentDidMount() {
        this.reloadMedicineList();
    }

    reloadMedicineList() {
        PharmacistApiService.fetchMedicines()
            .then((resp) => {
                this.setState({ medicines: resp.data })
                console.log(this.state.medicines);
            });
    }

    addMedicine() {
        window.localStorage.removeItem("medicineId");
        this.props.history.push('/addMedicine');
    }

    updateMedicine(medicineId) {
        window.localStorage.setItem("medicineId", medicineId);
        this.props.history.push('/updateMedicine');
    }

    deleteMedicine(medicineId) {
        PharmacistApiService.deleteMedicine(medicineId)
            .then(res => {
                this.setState({ message: 'Medicine deleted successfully.' });
                this.setState({ medicines: this.state.medicines.filter(medicine => medicine.id !== medicineId) });
            })
        console.log(this.state.message);
        swal({
            title: this.state.message,
            text: "Medicine  with id " + medicineId + " deleted.",
            icon: "success",
            button: "Done",
          });
    }

    render() {
        return (
            <div >
            <div className="container table-responsive py-5">


                            <h2 className="text-center role">Medicine Inventory</h2>
                            <br></br>
                            <table className="table  table-hover table-bordered"  >
                                <thead className="thead-dark">
                                    <tr>

                                        <th>Medicine ID</th>
                                        <th>Medicine Name</th>
                                        <th>Quantity</th>
                                        <th></th>
                                        <th></th>
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
                                                    <td>
                                                        <button className="btn btn-success" onClick={() => this.updateMedicine(medicine.id)} style={{ marginLeft: '20px' }}> Update Quantity</button>
                                                    </td>
                                                    <td>
                                                        <button className="btn btn-success" onClick={() => this.deleteMedicine(medicine.id)} style={{ marginLeft: '20px' }}> Delete Medicine Details</button>
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

export default ListMedicineComponent;
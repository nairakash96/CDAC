import React, { Component } from 'react'
import PharmacistApiService from '../../api/PharmacistApiService';
import './AddMedicineComponent.css';
import swal from "sweetalert";

class UpdateMedicineComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id:'',
            name:'',
            quantity: ''
        }
        this.saveMedicine = this.saveMedicine.bind(this);
        this.loadMedicine = this.loadMedicine.bind(this);
    }

    componentDidMount() {
        this.loadMedicine();
    }

    loadMedicine() {
        PharmacistApiService.fetchMedicineById(window.localStorage.getItem("medicineId"))
            .then((res) => {
                let medicine = res.data;
                console.log(medicine);
                this.setState({
                    id: medicine.id,
                    name: medicine.name,
                    quantity: medicine.quantity,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveMedicine = (e) => {
        e.preventDefault();
        let medicine = {
            id: this.state.id, name: this.state.name,
            quantity: this.state.quantity
        };
        PharmacistApiService.updateMedicineDetails(medicine.id, medicine.quantity)
            .then(res => {
                this.props.history.push('/medicine');
            });
            swal({
                title: "",
                text: "Medicine Details Updated Successfully",
                icon: "success",
                button: "Done",
              });
        console.log(this.state.message);

    }

    render() {
        return (
            <div>

<div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Update Medicine Details</h4>

                                <div className="form-group">
                                   
                                <input type="number" name="quantity" placeholder="Enter Medicine Details" className="form-control" value={this.state.quantity} onChange={this.onChange} />
                                </div>

                                
                                <button className="btn btn-success" onClick={this.saveMedicine}>Update Medicine</button>
                            </form>
                    </div>
               
            </div>

        );
    }
}

export default UpdateMedicineComponent;
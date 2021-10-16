import React, { Component } from 'react';
import PharmacistApiService from '../../api/PharmacistApiService';
import swal from "sweetalert";

import './AddMedicineComponent.css'
class AddMedicineComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            quantity: '',
            price: '',
            message: null,
            validationMessage: ''

        }
        this.saveMedicine = this.saveMedicine.bind(this);
    }

    saveMedicine = (e) => {
        e.preventDefault();
        if (this.state.name === '') {
            alert("Medicine Name is Mandatory");
        }
        else {
            let medicine = {
                name: this.state.name,
                quantity: this.state.quantity,
                price: this.state.price
            }
            PharmacistApiService.addMedicine(medicine)
                .then(resp => {
                    console.log(resp.data);
                    this.setState({ message: 'Medicine Added Successfully' });
                    swal({
                        title: this.state.message,
                        text: this.state.message,
                        icon: "success",
                        button: "Done",
                      });
                      this.props.history.push('/medicine');

                }).catch(err => {
                    console.error(err.response.data);
                    swal({
                        title: "Duplicate Medicine Name",
                        text: "Please enter correct Medicine Details",
                        icon: "error",
                        button: "OK",
                      });
                    this.props.history.push('/medicine')
                });
        }
    }

    onChange = (e) => {

        this.setState({ [e.target.name]: e.target.value });
    }

    render() {
        return (
            <div >
                <div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Add New Medicine to Stock</h4>

                        
                                <div className="form-group">
                                   
                                    <input type="text" placeholder="Enter Medicine Name" name="name" className="form-control" value={this.state.name} onChange={this.onChange} />
                                </div>

                                <div className="form-group">
                                    <input type="number" name="quantity" placeholder="Enter Medicine Quantity" className="form-control" value={this.state.quantity} onChange={this.onChange} />
                                </div>
                                <button className="btn btn-success" onClick={this.saveMedicine}>Save Medicine Details</button>
                            </form>
                    </div>

                           
        </div>

        );
    }

}

export default AddMedicineComponent;
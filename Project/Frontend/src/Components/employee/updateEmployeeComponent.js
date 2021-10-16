import React, { Component } from "react";
import swal from "sweetalert";
import EmployeeApiService from "../../api/EmployeeApiService";
import '../Pharmacist/AddMedicineComponent.css'

export default class updateEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: 0,
      name: "",
      email: "",
      password: "",
      role: "",
      phoneNumber: "",
      address: "",
      message: null,
    };
    this.saveEmployee = this.saveEmployee.bind(this);
    this.loadEmployee = this.loadEmployee.bind(this);
  }
  componentDidMount() {
    this.loadEmployee();
  }
  loadEmployee() {
    EmployeeApiService.fetchEmployeeById(
      window.localStorage.getItem("eid")
    ).then((res) => {
      let emp = res.data;
      console.log(emp);
      this.setState({
        id: emp.id,
        name: emp.name,
        email: emp.email,
        password: emp.password,
        role: emp.role,
        phoneNumber: emp.phoneNumber,
        address: emp.address,
      });
    });
  }
  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  saveEmployee = (e) => {
    e.preventDefault();
    let employee = {
      id: this.state.id,
      name: this.state.name,
      email: this.state.email,
      password: this.state.password,
      role: this.state.role,
      phoneNumber: this.state.phoneNumber,
      address: this.state.address,
    };
    EmployeeApiService.editEmployee(employee)
      .then((resp) => {
        console.log(resp); //actual response data sent by back end

        this.setState({
          message: resp.data,
        });
        swal({
          title: this.state.message,
          icon: "success",
          button: "Done",
        });
        this.props.history.push("/employees");
      })
      .catch((err) => {
        this.setState({
          message: "Employee updation failure!!",
        });
        swal({
          title: this.state.message,
          text: err.response.data.message,
          icon: "error",
          button: "Try Again",
        });
        this.props.history.push("/employees");
      });
  };

  render() {
    return (
      <div className="addMedicineForm">
        {/*form starts from here*/}
        {/*Heading*/}
        <form
          style={{ width: "550px", margin: "auto" }}
          action=""
          className="main-form needs-validation"
        >
          <legend>
            <h1 style={{ color: "black" }}>
              <b>Employee Details Updation</b>
            </h1>
          </legend>
          <div className="form-group">
            <input
              type="text"
              name="name"
              id="name"
              className="form-control"
              placeholder="Full Name eg.John Doe"
              onChange={this.onChange}
              value={this.state.name}
            />
          </div>
          <br />
          <div className="form-group">
            <input
              type="email"
              name="email"
              id="email"
              className="form-control"
              required
              placeholder="aaa@example.com"
              onChange={this.onChange}
              value={this.state.email}
              readOnly
            />
          </div>
          <br />
          <div className="form-group">
            <input
              type="password"
              name="password"
              id="password"
              className="form-control"
              placeholder="Password"
              onChange={this.onChange}
              value={this.state.password}
            />
          </div>
          <br />
          <div className="form-group">
            <select
              name="role"
              id="role"
              className="form-control form-select"
              onChange={this.onChange}
              value={this.state.role}
              readOnly
              disabled
            >
              <option selected hidden>
                Choose Employees Role
              </option>
              <option value="ADMIN">Admin</option>
              <option value="DOCTOR">Doctor</option>
              <option value="PHARMACIST">Pharmacist</option>
              <option value="LABINCHARGE">Lab InCharge</option>
              <option value="RECEPTIONIST">Receptionist</option>
              <option value="WARDINCHARGE">Ward InCharge</option>
            </select>
          </div>
          <br />
          <div className="form-group">
            <input
              type="tel"
              name="phoneNumber"
              id="phoneNumber"
              className="form-control"
              placeholder="+91-XXXXXXXXXX"
              onChange={this.onChange}
              value={this.state.phoneNumber}
            />
          </div>
          <br />
          <div className="form-group">
            <textarea
              cols="4"
              rows="5"
              name="address"
              id="address"
              className="form-control"
              placeholder="Employees full address"
              onChange={this.onChange}
              value={this.state.address}
            ></textarea>
          </div>
          <br />

          <button className="btn btn-success" onClick={this.saveEmployee}>
            Update
          </button>
        </form>
      </div>
    );
  }
}

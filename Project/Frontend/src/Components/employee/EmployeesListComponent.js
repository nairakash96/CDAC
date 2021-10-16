import React, { Component } from "react";
import EmployeeApiService from "../../api/EmployeeApiService";
import swal from "sweetalert";

export default class EmployeesListComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [],
      message: null,
    };
    this.deleteEmployee = this.deleteEmployee.bind(this);
    this.editEmployee = this.editEmployee.bind(this);
    this.reloadEmployeeList = this.reloadEmployeeList.bind(this);
  }
  componentDidMount() {
    this.reloadEmployeeList();
  }

  reloadEmployeeList() {
    EmployeeApiService.fetchEmployees().then((resp) => {
      this.setState({ employees: resp.data });
      console.table(this.state.employees);
    });
  }

  deleteEmployee(eid) {
    EmployeeApiService.deleteEmployee(eid).then(() => {
      this.setState({ message: "Employee deleted successfully." });
      swal({
        title: this.state.message,
        text: "Employee with id " + eid + " deleted.",
        icon: "success",
        button: "Done",
      });
      this.setState({
        employees: this.state.employees.filter((emp) => emp.id !== eid),
      });
    });
  }

  editEmployee(id) {
    window.localStorage.setItem("eid", id);
    this.props.history.push("/edit-employee");
  }

  render() {
    return (
      <div className="container">

<b>
          <h1 style={{ color: "black" }} className="text-center">
            List of Employees
          </h1>
        </b>
      <table className="table  table-striped table-bordered"  >
          <thead className="thead-dark">
          <tr>
              <th>Name</th>
              <th>Email Id</th>
              <th>Role</th>
              <th>Phone No.</th>
              <th>Address</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.state.employees.map((e) => (
              <tr key={e.id}>
                <td>{e.name}</td>
                <td>{e.email}</td>
                <td>{e.role}</td>
                <td>{e.phoneNumber}</td>
                <td>{e.address}</td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => this.deleteEmployee(e.id)}
                  >
                    {" "}
                    Delete
                  </button>
                  <button
                    className="btn btn-success"
                    onClick={() => this.editEmployee(e.id)}
                    style={{ marginLeft: "20px" }}
                  >
                    {" "}
                    Edit
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
      </table>


  </div>
      
    );
  }
}

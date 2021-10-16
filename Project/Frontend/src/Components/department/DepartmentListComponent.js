import React, { Component } from "react";
import DepartmentApiService from "../../api/DepartmentApiService";
import swal from "sweetalert";
export default class DepartmentListComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      departments: [],
      message: "",
    };
    this.reloadDepartmentList = this.reloadDepartmentList.bind(this);
    this.deleteDepartment = this.deleteDepartment.bind(this);
  }
  componentDidMount() {
    this.reloadDepartmentList();
  }
  reloadDepartmentList() {
    DepartmentApiService.fetchDepartments().then((resp) => {
      this.setState({
        departments: resp.data,
      });
      console.table(this.state.departments);
    });
  }
  deleteDepartment(did) {
    DepartmentApiService.deleteDepartment(did).then(() => {
      this.setState({ message: "Department deleted successfully." });
      swal({
        title: this.state.message,
        icon: "success",
        button: "Done",
      });
      this.setState({
        departments: this.state.departments.filter((dept) => dept.id !== did),
      });
    });
  }
  render() {
    return (
      <div className="container table-responsive py-5">
        <b>
          <h1 style={{ color: "black" }} className="text-center">
            List of Departments
          </h1>
        </b>
        <table className="table table-striped" style={{borderStyle:"hidden"}}>
          <thead className="thead-dark">
            <tr>
              <th>Department Name</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.state.departments.map((d) => (
              <tr key={d.id}>
                <td>{d.departmentName}</td>

                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => this.deleteDepartment(d.id)}
                  >
                    {" "}
                    Delete
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

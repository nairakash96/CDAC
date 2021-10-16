import React, { Component } from "react";
import DepartmentApiService from "../../api/DepartmentApiService";
import swal from "sweetalert";
import '../Pharmacist/AddMedicineComponent.css'
export default class AddDepartmentComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: 0,
      departmentName: "",
      message: "",
      departmenterror: "",
    };
    this.saveDepartment = this.saveDepartment.bind(this);
  }

  saveDepartment = (e) => {
    e.preventDefault();
    let department = {
      departmentName: this.state.departmentName.toUpperCase(),
    };

    DepartmentApiService.addDepartment(department)
      .then((resp) => {
        console.log(resp.data);
        this.setState({
          id: resp.data.id,
          message: "Department added Successfully",
        });
        swal({
          title: this.state.message,
          icon: "success",
          button: "Done",
        });
        this.setState({
          id: 0,
          departmentName: "",
        });
      })
      .catch((err) => {
        console.log(err);
        this.setState({
          message: err.response.data.message,
        });
        swal({
          title: "Please enter valid and unique department Name",
          icon: "error",
          button: "Try Again",
        });
      });

  };
  onChange = (e) => this.setState({ [e.target.name]: e.target.value });


  render() {
    return (
      <div>

        <div className="addMedicineForm">
          <form>
            <h4 className="modal-title">Create New Department</h4>

            <div className="form-group">
              <input
                id="departmentName"
                name="departmentName"
                type="text"
                required
                className="form-control"
                placeholder="Department Name"
                onChange={this.onChange}
                value={this.state.departmentName}
              />
              <span style={{ color: "red" }}>{this.state.departmenterror}</span>
            </div>

            
            <button className="btn btn-success" onClick={this.saveDepartment}>
              Add
            </button>                            </form>
        </div>

      </div>
    );
  }
}

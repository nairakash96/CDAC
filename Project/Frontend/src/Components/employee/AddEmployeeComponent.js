import React, { Component } from "react";
import EmployeeApiService from "../../api/EmployeeApiService";
import DepartmentApiService from "../../api/DepartmentApiService";
import swal from "sweetalert";
import OtpService  from "../../api/OtpService";
class AddEmployeeComponent extends Component {
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
        departments: [],
        deptid: 0,
        emailerror:'',
        passworderror:'',
        mobilenumbererror:'',
        enteredOtp: "",
      };
      this.saveEmployee = this.saveEmployee.bind(this);
      this.reloadDepartmentList = this.reloadDepartmentList.bind(this);
    }
  
    componentDidMount() {
      this.reloadDepartmentList();
    }
    reloadDepartmentList = () => {
      DepartmentApiService.fetchDepartments().then((resp) => {
        this.setState({ departments: resp.data });
        console.table(this.state.departments);
      });
    };

    validateForm()
    {
        return this.validateEmail() &&  this.validatePassword() && this.validateMobileNo()?true:false;
        
    }
    saveEmployee = (e) => {
        e.preventDefault();
        console.log('SAVE EMP.................1');
        if(this.validateForm()){
          
          let employee = {
            name: this.state.name,
            email: this.state.email,
            password: this.state.password,
            role: this.state.role,
            phoneNumber: this.state.phoneNumber,
            address: this.state.address,
          }
          console.log('SAVE EMP.................2');
          OtpService.fetchMailData(this.state.email);
      // eslint-disable-next-line react/no-direct-mutation-state
      this.state.enteredOtp = prompt(
        "Please enter the otp sent to your email address for email verification."
      );
      OtpService.verifyOtp(this.state.enteredOtp).then((resp) => {
        console.log(resp.data);

        if (resp.data === "success") {
          EmployeeApiService.addEmployee(employee)
            .then((resp) => {
              console.log(resp); //actual response data sent by back end

              this.setState({
                id: resp.data.id,
                message: "Employee registration successful",
              });

              swal({
                title: this.state.message,
                text:
                  "Please Note this reference id for future reference \n Employee Id : " +
                  this.state.id,
                icon: "success",
                button: "Done",
              });
              if (this.state.role === "DOCTOR") {
                DepartmentApiService.assignDepartment(
                  this.state.id,
                  this.state.deptid
                );
              }
              this.setState({
                id: 0,
                name: "",
                email: "",
                password: "",
                role: "",
                phoneNumber: "",
                address: "",
                message: null,
              });
            })
            .catch((err) => {
              this.setState({
                message: "Employee registration failure!!",
              });
              swal({
                title: this.state.message,
                text: err.response.data.message,
                icon: "error",
                button: "Try Again",
              });
            });
        } else {
          swal({
            title: "Invalid Email address/OTP!!",
            icon: "error",
            button: "Try Again",
          });
        }
      });
    }
  
         
        else{
         console.log('In else');
         swal({
          title: "Error exists in the form",
          icon: "error",
          button: "Try Again",
        });
        }
      }




    onChange = (e) => this.setState({ [e.target.name]: e.target.value });


  validateEmail=(e)=>{
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);

    if(!this.state.email.match(pattern))
    {
      this.setState({emailerror:'Please enter in valid email format - abc@example.com'});
      return false;
    }
    else
    {
      this.setState({emailerror:''});
      return true;
    }
  
  }

  validatePassword=(e)=>{
    if (!this.state.password.match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
      this.setState({passworderror:'Password must contain at least one uppercase letter,digit and special character and must be atleast 8 characters long'});
      return false;

    }
    else
    {
      this.setState({passworderror:''});
      return true;

    }
  }

  validateMobileNo=(e)=>{
    if(!this.state.phoneNumber.match(/^[0-9]{10}$/))
    {
      this.setState({mobilenumbererror:'Mobile number must be of 10 digits'});
      return false;

    }
    else
    {
      this.setState({mobilenumbererror:''});
      return true;

    }
  }
 

    render() {
        return (
          <div className="addMedicineForm">
            
            <form>
                <h4 className="modal-title">Employee Registration Form</h4>

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
                />
    
    <span style={{color:"red"}}>           {this.state.emailerror}</span>
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
                <span style={{color:"red"}}>{this.state.passworderror}</span>
               
              </div>
    
              <br />
              <div className="form-group">
                <select
                  name="role"
                  id="role"
                  className="form-control form-select"
                  onChange={this.onChange}
                  value={this.state.role}
                  required
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
    
              {
                //Check if role is doctor
                this.state.role === "DOCTOR" ? (
                  <div>
                    <div className="form-group">
                      <select
                        name="deptid"
                        id="deptid"
                        className="form-control form-select"
                        onChange={this.onChange}
                        value={this.state.deptid}
                      >
                        <option>
                          Choose Doctors Department
                        </option>
                        {this.state.departments.map((d) => (
                          <option value={d.id} key={d.id}>
                            {d.departmentName.toLowerCase()}
                          </option>
                        ))}{" "}
                      </select>
                    </div>
                    ;
                  </div>
                ) : (
                  <div></div>
                )
              }
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
                <span style={{color:"red"}}>{this.state.mobilenumbererror}</span>
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
                Register
              </button>
            </form>
          </div>
        );
      }
    }
    export default AddEmployeeComponent;
import React, { Component } from 'react'
import AuthenticationService from "../../api/AuthenticationService.js"
import OtpService from "../../api/OtpService";
import swal from "sweetalert"
class EmployeeLoginComponent extends Component {
  constructor(props) {
    super(props)
    this.state =
    {
      email: "",
      password: "",
      loginFailed: false,
      showSuccessMsg: false,
      enteredOtp: ""
    }
    this.handleChange = this.handleChange.bind(this)
    this.loginClicked = this.loginClicked.bind(this)
  }

  handleChange(event) {
    this.setState(
      {
        [event.target.name]: event.target.value
      }
    )
  }

  loginClicked() {
    this.setState({enteredOtp: null});
    OtpService.fetchMailData(this.state.email);

    const promptvalue = prompt("Please enter the otp sent to your email address");
    console.log(promptvalue)
    // eslint-disable-next-line react/no-direct-mutation-state
    this.state.enteredOtp = promptvalue;
    console.log(this.state.enteredOtp);
    OtpService.verifyOtp(this.state.enteredOtp).then((resp) => {
      console.log(resp.data);

      if (resp.data === "success") {
        AuthenticationService.executeEmployeeAuthenticationService(
          this.state.email,
          this.state.password
        )
          .then((response) => {
            console.log(response);
            AuthenticationService.registerSuccessfulLogin(
              this.state.email,
              this.state.password,
              response.data.role
            );
            if (response.data.role === "RECEPTIONIST")
              this.props.history.push(`/receptionist`);
            if (response.data.role === "DOCTOR")
              this.props.history.push(`/doctor`);
            if (response.data.role === "PHARMACIST")
              this.props.history.push(`/pharmacist`);
            if (response.data.role === "WARDINCHARGE")
              this.props.history.push(`/wardInCharge`);
            if (response.data.role === "ADMIN")
              this.props.history.push(`/employees`);
            if (response.data.role === "LABINCHARGE")
              this.props.history.push(`/labInCharge`);
            // console.log("Other Role");
            else
              this.setState({
                loginFailed: false,
                showSuccessMsg: true,
              });
          })
          .catch(() => {
            this.setState({
              loginFailed: true,
              showSuccessMsg: false,
              // actualOtp: "",
              // enteredOtp: "",
            });
          });
      } else {
        swal({
          title: "Invalid Otp!!",
          icon: "error",
          button: "Try Again",
        });
      }
    });
  }

  render() {
    return (
      <div>
        <ShowErrorMessage loginFailed={this.state.loginFailed} />
        <div class="container">
          <div class="myForm login-box">
            <h1 class="login-title">Employee Login</h1>

            <div class="form-group row col-10" style={{ marginLeft: "45px" }}>
              <label for="email" class="form-control-label" style={{ fontSize: "20px" }}>Email: </label>
              <input class="form-control input-lg" type="email" name="email" id="email" placeholder="email" value={this.state.email} onChange={this.handleChange} />
            </div>
            <div class="form-group row col-10 " style={{ marginLeft: "45px" }} >
              <label for="password" class="form-control-label" style={{ fontSize: "20px" }}>Password:</label>
              <input class="form-control input-lg" type="password" name="password" placeholder="password" value={this.state.password} onChange={this.handleChange} />
            </div>
            <div class="form-group">
              <button className="btn btn-success btn-lg login-key " onClick={this.loginClicked}> Login </button>
            </div>
          </div>
        </div>
      </div>
    )
  }
}

function ShowErrorMessage(props) {
  if (props.loginFailed)
    return <div className="alert alert-warning">Invalid Credentials</div>
  else
    return null
}

export default EmployeeLoginComponent



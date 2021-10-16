import React, { Component } from 'react'
import AuthenticationService from "../../api/AuthenticationService.js"

class PatientLoginComponent extends Component {

    constructor(props) {
        super(props)
        this.state =
        {
            email: "",
            password: "",
            loginFailed: false,
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
        AuthenticationService
            .executePatientAuthenticationService(this.state.email, this.state.password)
            .then((response) => {
                console.log(response);
                AuthenticationService.registerSuccessfulPatientLogin(this.state.email, this.state.password, "PATIENT", response.data.id);

                this.props.history.push(`/patient/${response.data.id}`)

                this.setState({
                    loginFailed: false
                })
            }).catch(() => {
                this.setState({
                    loginFailed: true
                })
            })
    }
    render() {
        return (
            <div>
                <ShowErrorMessage loginFailed={this.state.loginFailed} />
                <div class="container">
                    <div class="myForm login-box">
                        <h1 class="login-title">Patient Login</h1>

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

export default PatientLoginComponent
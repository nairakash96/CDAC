import { Component } from "react";
import { Redirect, Route } from "react-router";
import AuthenticationService from "../../api/AuthenticationService.js";

class AuthenticatedRoute extends Component {
    render() {
        if (AuthenticationService.isUserLoggedIn()) {
            return <Route {...this.props} />
        }
        else {
            return <Redirect to="/" />
        }
    }
}

export default AuthenticatedRoute
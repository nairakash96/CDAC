import React, { Component } from 'react'

class LogoutComponent extends Component {
    // componentDidMount() {
    //     setTimeout(this.props.history.push('/'), 5000);
    // }
    render() {
        return (
            <div>
                <h1>
                    Thanks for Using e-Hospital
                </h1>
                <h3>
                    Logged Out Successfully
                </h3>
                {/* {setTimeout(this.props.history.push('/'), 5000)} */}
            </div>
        )
    }
}

export default LogoutComponent
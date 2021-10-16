import React from 'react';
import './HomePage.css';
import { Link } from 'react-router-dom';
import ehospitalbackground from './video1.mp4'
function HomePageComponent() {
    return (

        <div>

            <div className="main">
                <h1 className="title">eHospital <br />
                    <span >One-Stop Automated Solution for Hospital Management</span></h1>

                <video autoPlay loop id="video-background" muted>
                    <source src={ehospitalbackground} type="video/mp4" />
                </video>
            </div>
            <div className="row">
                <div className="col-lg-4 mb-4 emp" >
                    <div className="card special-card">
                        <div className="card-body">
                            <h5 className="card-title">Employee</h5>
                            <p className="card-text">
                                For Hospital Employee
                            </p>
                            <Link className="nav-link btn btn-outline-primary btn-sm" to="/login">Login</Link>
                        </div>
                    </div>
                </div>
                <div className="col-lg-4 mb-4 emp" >
                    <div className="card special-card">
                        <div className="card-body">
                            <h5 className="card-title">Patient</h5>
                            <p className="card-text">
                                For Patients
                            </p>
                            <Link className="nav-link btn btn-outline-primary btn-sm" to="/patientlogin">Login</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}



export default HomePageComponent;
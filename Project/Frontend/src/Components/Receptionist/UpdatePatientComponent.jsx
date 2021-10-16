import React, { Component } from 'react'
import { Formik, Field, Form, ErrorMessage } from 'formik';
import ReceptionistService from "../../api/ReceptionistService.js"
import swal from "sweetalert";


class UpdatepatientComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            patient: {
                fullname: "",
                email: "",
                age: "",
                gender: "",
                type: "",
                totalBillAmount: 0,
                password: "",
                errors: {},
            }

        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

        console.log(":::Constructor")
        console.log(this.state.patient)
    }

    componentDidMount() {

        ReceptionistService.getPatient(this.state.id)
            .then(
                (response) => {
                    console.log(response.data)
                    this.setState({
                        patient: {
                            id: response.data.id,
                            fullname: response.data.patientName,
                            email: response.data.patientEmail,
                            age: response.data.age,
                            gender: response.data.gender,
                            type: response.data.patientType,
                            totalBillAmount: response.data.totalBillAmount,
                            password: response.data.password
                        }

                    })
                }
            )
        console.log(":::did mount")
        console.log(this.state.patient)

    }

    render() {

        console.log(":::Render")
        console.log(this.state.patient)
        return (

            <div>
                <div>
                    <Formik initialValues={
                        {
                            fullname: this.state.patient.fullname,
                            email: this.state.patient.email,
                            type: this.state.patient.type,
                            gender: this.state.patient.gender,
                            age: this.state.patient.age,
                            totalBillAmount: this.state.patient.totalBillAmount,
                            password: this.state.patient.password
                        }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}>
                        {() => {
                            return (
                                <div>
                                    <Form className="container mt-10 py-5">

                                        <div class="p-3 mb-2 bg-dark text-white border border-white border-10">
                                            <h2>Update Patient</h2>
                                        </div>

                                        <div class="p-3 mb-2 bg-light text-dark border-style">
                                            <div className="row">
                                                <fieldset className="form-group  col-md-6">
                                                    <label class="text-left col-12" style={{ fontSize: "19px" }}>Name</label>
                                                    <Field name="fullname" className="form-control" type="text" />
                                                    <ErrorMessage name="fullname" component="div" style={{ color: "red", fontSize: "15px" }} ></ErrorMessage>
                                                </fieldset>
                                                <fieldset className="form-group  col-md-6">
                                                    <label class="text-left col-12" style={{ fontSize: "19px" }}>Email Address</label>
                                                    <Field name="email" className="form-control" type="email" />
                                                    <ErrorMessage name="email" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                                                </fieldset>
                                            </div>

                                            <div className="row">
                                                <fieldset className="form-group  col-md-6">
                                                    <label class="text-left col-12" style={{ fontSize: "19px" }}>Type Of Patient</label>
                                                    <Field as="select" name="type" className="form-control w-100">
                                                        {(this.state.type === "IN") ? <>
                                                            <option value="IN" selected>IN</option>
                                                            <option value="OUT">OUT</option>
                                                        </> :
                                                            <>
                                                                <option value="IN" >IN</option>
                                                                <option value="OUT" selected>OUT</option>
                                                            </>

                                                        }
                                                    </Field>
                                                    <ErrorMessage name="type" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                                                </fieldset>
                                                <fieldset className="form-group  col-md-6">
                                                    <label class="text-left col-12" style={{ fontSize: "19px" }}>Bill</label>
                                                    <Field name="totalBillAmount" className="form-control w-100 text-left" type="number" />
                                                    <ErrorMessage name="totalBillAmount" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                                                </fieldset>
                                            </div>
                                            <div className="row">
                                                <fieldset className="form-group  col-md-6">
                                                    <label class="text-left col-12" style={{ fontSize: "19px" }}>Age</label>
                                                    <Field name="age" className="form-control w-100 text-left" type="number" />
                                                    <ErrorMessage name="age" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                                                </fieldset>

                                            </div>
                                        </div>
                                        <fieldset className="form-group">
                                            <button type="submit" className="btn btn-success btn-lg w-25">Update</button>
                                        </fieldset>

                                    </Form>
                                </div>
                            )
                        }}
                    </Formik>
                </div >

            </div >
        )
    }

    onSubmit(values) {
        let input = {}
        input = this.state.patient
        console.log(input)
        console.log("In Component didi mount")
        console.log(this.state.patient.password)
        console.log("Inside on submit")
        console.log("values")
        if (this.state.type === "IN" && values.type === "OUT") {
            this.setState({
                patient: {
                    type: "OUT",
                }
            })
        }
        else if (this.state.type === "OUT" && values.type === "IN") {
            this.setState({
                patient: {
                    type: "IN",
                }
            })
        }
        this.setState({
            patient:
            {
                id: input.id,
                fullname: values.fullname,
                email: values.email,
                age: values.age,
                totalBillAmount: values.totalBillAmount,
                password: input.password,
                gender: input.gender
            }
        })
        console.log("In on submit")
        console.log(this.state.patient)

        ReceptionistService.putPatient(this.state.id,
            values.fullname,
            values.email,
            values.password,
            values.type,
            values.gender,
            values.age,
            values.totalBillAmount).then(
                () => {
                    swal({
                        title: "Updated Successfully",
                        icon: "success",
                        button: "OK",
                    });

                    // alert("Updated Successfully")

                    this.props.history.push(`/patient/list/show`)
                })
            .catch(
                () => {
                    swal({
                        title: "Failed to Update",
                        icon: "error",
                        button: "Try again",
                    });
                }
            )

    }

    validate(values) {

        console.log("Inside on validate")
        let errors = {}
        if (!values.fullname)
            errors.fullname = "Please enter Name"
        else if (values.fullname.length < 3)
            errors.fullname = "Name should be atleast 3 characters"

        if (!values.email) {
            errors.email = 'Email is required';
        } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
            errors.email = 'Invalid email address';
        }

        if (!values.age) {
            errors.age = 'Enter the age';
        }
        else if (values.age < 0) {
            errors.age = 'Age should be positive number';
        }


        this.setState({
            errors: errors
        })

        return errors;
    }
}

export default UpdatepatientComponent
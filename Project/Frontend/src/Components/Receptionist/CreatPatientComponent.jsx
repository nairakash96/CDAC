import React, { Component } from 'react'
import { Formik, Field, Form, ErrorMessage } from 'formik';
import ReceptionistService from "../../api/ReceptionistService.js"
import swal from "sweetalert";


class CreatPatientComponent extends Component {
  constructor(props) {
    super(props)
    this.state = {
      message: '',
      patient: {
        id: '',
        fullname: "",
        email: "",
        password: "",
        confirmPassword: "",
        type: "",
        gender: "",
        age: '',
        totalBillAmount: 0.0
      },
      errors: {}

    }

    this.onSubmit = this.onSubmit.bind(this)
    this.validate = this.validate.bind(this)

  }

  componentDidMount() {

  }

  render() {

    return (
      <div>
        <div>
          <Formik initialValues={
            {
              fullname: "",
              email: "",
              password: "",
              confirmPassword: "",
              type: "",
              gender: "",
              age: '',
              totalBillAmount: 0.0
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

                    <div class="p-3 mb-2 bg-dark text-white border border-white border-style">
                      <h2>Create Patient</h2>
                    </div>

                    <div class="p-3 mb-2 bg-light text-dark border-style">
                      <div className="row">
                        <fieldset className="form-group  col-md-6">
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Name</label>
                          <Field name="fullname" className="form-control" type="text" />
                          <ErrorMessage name="fullname" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                        <fieldset className="form-group  col-md-6">
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Email Address</label>
                          <Field name="email" className="form-control" type="email" />
                          <ErrorMessage name="email" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group  col-md-6" >
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Password</label>
                          <Field name="password" className="form-control" type="password" />
                          <ErrorMessage name="password" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                        <fieldset className="form-group  col-md-6" >
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Confirm Password</label>
                          <Field name="confirmPassword" className="form-control" type="password" />
                          <ErrorMessage name="confirmPassword" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group  col-md-6">
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Type Of Patient</label>
                          <Field as="select" name="type" className="form-control w-100">
                            <option selected>Choose...</option>
                            <option value="IN" >IN</option>
                            <option value="OUT">OUT</option>
                          </Field>
                          <ErrorMessage name="type" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                        <fieldset className="form-group  col-md-6">
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Gender</label>
                          <Field as="select" name="gender" className="form-control w-100">
                            <option selected>Choose...</option>
                            <option value="Female" >Female</option>
                            <option value="Male">Male</option>
                          </Field>
                          <ErrorMessage name="gender" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                      </div>

                      <div className="row">
                        <fieldset className="form-group  col-md-6" >
                          <label class="text-left col-12" style={{ fontSize: "19px" }}>Age</label>
                          <Field name="age" className="form-control" type="number" />
                          <ErrorMessage name="age" component="div" style={{ color: "red", fontSize: "15px" }}></ErrorMessage>
                        </fieldset>
                      </div>
                    </div>
                    <fieldset className="form-group">

                      <button type="submit" className="btn btn-success btn-lg w-25">Save</button>
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


    let patient = {
      id: '',
      fullname: values.fullname,
      email: values.email,
      password: values.password,
      type: values.type,
      gender: values.gender,
      age: values.age,
      totalBillAmount: 0.0
    }

    ReceptionistService.createPatient(patient.fullname,
      patient.email,
      patient.password,
      patient.type,
      patient.gender,
      patient.age, 0).then(
        (response) => {
          this.setState({
            message: response.data.message
          })
          //  this.state.message = response.data.message
          swal({
            title: this.state.message,
            icon: "success",
            button: "OK",
          });
          this.props.history.push(`/patient/list/show`)
        }
      )
      .catch(
        () => {

          this.setState({

            message: "Failed to create patient"
          })
          swal({
            title: this.state.message,
            icon: "error",
            button: "Try Again",
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
      errors.fullname = "N1me should be atleast 3 characters"

    if (!values.email) {
      errors.email = 'Email is required';
    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
      errors.email = 'Invalid email address';
    }

    if (!values.password) {
      errors.password = 'Password is required';
    }
    else if (!values.confirmPassword) {
      errors.confirmPassword = 'Please confirm the Password';
    }
    else if (values.password !== values.confirmPassword)
      errors.confirmPassword = 'Password and Confirmed Password does not match';

    if (!values.age) {
      errors.age = 'Enter the age';
    }
    else if (values.age < 0) {
      errors.age = 'Age should be positive number';
    }

    if (!values.type) {
      errors.type = 'Select the type';
    }

    if (!values.gender) {
      errors.gender = 'Select the Gender';
    }

    this.setState({
      errors: errors
    })
    console.log(values.type)
    return errors;
  }
}

export default CreatPatientComponent
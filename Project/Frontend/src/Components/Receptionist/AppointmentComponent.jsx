import React, { Component } from 'react'
import moment, { now } from 'moment'
import { Formik, Field, Form, ErrorMessage } from 'formik';
import ReceptionistService from "../../api/ReceptionistService.js"
import DatePicker from "react-datepicker"
import "react-datepicker/dist/react-datepicker.css";
import swal from "sweetalert";




class AppointmentComponent extends Component {
  constructor(props) {
    super(props)
    this.state = {
      deptName: [],
      doctorName: [],
      patientName: [],
      deptId: "",
      doctorId: "",
      patientId: "",
      doctorOptions: [],
      patientOptions: [],
      statusDoctor: true,
      statusPatient: true,
      statusBtn: true,
      date: new Date(),
      time: "",
      message: ""
    }
    this.onSubmit = this.onSubmit.bind(this)
    this.validate = this.validate.bind(this)
    this.onDeptNameSelected = this.onDeptNameSelected.bind(this)
    this.onDoctorNameSelected = this.onDoctorNameSelected.bind(this)
    this.onPatientNameSelected = this.onPatientNameSelected.bind(this)

  }

  componentDidMount() {
    ReceptionistService.getDepartments()
      .then((response) => {
        console.log("response")
        console.log(response)
        this.setState({
          deptName: response.data
        });

      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {

    const options = [];
    options.push(<option value="default" selected> Select Department</option>);
    for (let [, value] of Object.entries(this.state.deptName)) {
      options.push(
        <option key={value.id} value={value.id}>
          {value.departmentName}
        </option>
      );

    }

    return (
      <div>
        <div>
          <Formik initialValues={{}}
            onSubmit={this.onSubmit}
            validateOnChange={false}
            validateOnBlur={false}
            validate={this.validate}
            enableReinitialize={true}>
            {() => {
              return (
                <div className="container">
                  <Form className="container mt-10 py-5 w-75">
                    {this.state.message && <p component="div" className="alert alert-warning" >{this.state.message}</p>}

                    <div class="p-3 mb-2 bg-dark text-white border border-white border-10">
                      <h2>Book Appointment</h2>
                    </div>
                    <div class="p-3 mb-2 bg-light text-dark border-style">
                      <div className="row">
                        <fieldset className="form-group col-md-3">
                          <label className="form-control w-100 text-left">Department Name</label>
                        </fieldset>
                        <fieldset className="form-group col-md-8">
                          <Field
                            className="form-control"
                            as="select"
                            onChange={this.onDeptNameSelected}
                            name="deptartmentID"
                          >
                            {options}
                          </Field>
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group col-md-3">
                          <label className="form-control w-100 text-left">Doctor Id-Name</label>
                        </fieldset>
                        <fieldset className="form-group col-md-8">
                          <Field
                            className="form-control"
                            as="select"
                            disabled={this.state.statusDoctor}
                            onChange={this.onDoctorNameSelected}
                            value={this.state.doctorId}
                            name="doctorID"
                          >
                            <option value="default" selected> Select Doctor</option>
                            {this.state.doctorOptions}
                          </Field>
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group col-md-3">
                          <label className="form-control w-100 text-left">Patient Name</label>
                        </fieldset>
                        <fieldset className="form-group col-md-8">
                          <Field
                            className="form-control"
                            as="select"
                            onChange={this.onPatientNameSelected}
                            name="patientID" value={this.state.patientId}
                            disabled={this.state.statusPatient}
                          >
                            <option value="default" selected> Select Patient</option>
                            {this.state.patientOptions}
                          </Field>
                          <ErrorMessage name="type" component="div" className="alert alert-warning"></ErrorMessage>
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group col-md-3">
                          <label className="form-control w-100 text-left">Date</label>
                        </fieldset>
                        <fieldset className="form-group col-md-8">
                          <DatePicker
                            selected={this.state.date}
                            dateFormat="yyyy/MM/dd  EE  hh:mm a"
                            className="form-control"
                            name="startDate"
                            showTimeSelect
                            disabledKeyboardNavigation
                            onChange={date => this.setState({
                              date: date
                            }, () => console.log(this.state.date + ":date"))}
                          />
                          {/* <DatePicker
                                                        onChange={this.handleChange}
                                                        selected={this.state.startDate}
                                                        showTimeSelect
                                                        dateFormat="MM/dd/yyyy  EE hh:mm a"
                                                        locale="ro"
                                                    /> */}
                        </fieldset>
                      </div>
                      <div className="row">
                        <fieldset className="form-group">
                          <button type="submit" className="btn btn-success btn-lg w-40" disabled={this.state.statusBtn}>Book Now</button>
                        </fieldset>

                      </div>
                    </div>

                  </Form>
                </div>
              )
            }}
          </Formik>
        </div >

      </div >


    )
  }
  onDeptNameSelected(event) {
    console.log("onDeptNameSelected")
    this.setState({
      deptId: event.target.value
    });

    this.setState({
      deptId: event.target.value
    }, () => {
      if (this.state.deptId !== "default") {
        ReceptionistService.getDoctorsByDept(this.state.deptId)
          .then((response) => {

            this.setState({
              doctorName: response.data
            }, () => {
              const doctorOptions = [];
              for (let [, value] of Object.entries(this.state.doctorName)) {
                doctorOptions.push(
                  <option key={value.id} value={value.id}>
                    {value.id + "-" + value.name}
                  </option>
                );
              }
              this.setState({
                doctorOptions: doctorOptions,
                statusDoctor: false
              }, () => {
                console.log("this.state.doctorOptions")
                console.log(this.state.doctorOptions)
              });

            });

          })
          .catch((error) => {
            console.log(error);

          });
      }
      else {
        this.setState({
          statusDoctor: true,
          statusPatient: true,
          statusBtn: true,
          doctorId: "",
          patientId: ""

        });
      }
    });
  }

  onDoctorNameSelected(event) {
    console.log("onPatientNameSelected")

    this.setState({
      doctorId: event.target.value
    }, () => {
      if (this.state.deptId !== "default") {
        ReceptionistService.retriveAllPatients()
          .then((response) => {

            this.setState({
              patientName: response.data
            }, () => {
              const patientOptions = [];
              for (let [, value] of Object.entries(this.state.patientName)) {
                patientOptions.push(
                  <option key={value.id} value={value.id}>
                    {value.id + "-" + value.patientName}
                  </option>
                );
              }
              this.setState({
                patientOptions: patientOptions,
                statusPatient: false
              }, () => {
                console.log("this.state.doctorOptions")
                console.log(this.state.doctorOptions)
              });

            });

          })
          .catch((error) => {
            console.log(error);

          });
      }
      else {
        this.setState({
          statusPatient: true,
          statusBtn: true,
          patientId: ""
        });
      }
    });
  }

  onPatientNameSelected(event) {
    console.log("onPatientNameSelected")
    this.setState({
      patientId: event.target.value
    }, () => {
      if (this.state.deptId !== "default") {
        this.setState({
          statusBtn: false
        });
      }
      else {
        this.setState({
          statusBtn: true
        });
      }

    });
  }

  onSubmit() {
    console.log("Inside on submit")
    console.log("Inside on submit")
    var selectedDateStr = moment(this.state.date).format('YYYY-MM-DD').toString();
    var selectedTimeStr = moment(this.state.date).format('hh:mm:ss').toString();
    console.log(selectedTimeStr)
    console.log(selectedDateStr)
    console.log(typeof (selectedDateStr))
    console.log(this.state.deptId)
    console.log(this.state.doctorId)
    console.log(this.state.patientId)
    console.log(selectedDateStr)
    ReceptionistService.bookAppointment(this.state.deptId,
      this.state.doctorId,
      this.state.patientId,
      selectedDateStr,
      selectedTimeStr).then(
        () => {
          swal({
            title: "Appointment booked successfully",
            icon: "success",
            button: "OK",
          });
          this.props.history.push(`/receptionist`)
        })
      .catch(
        () => {

          swal({
            title: "Error occured",
            icon: "error",
            button: "OK",
          });
        }
      )

  }

  validate() {
    let errors = {}
    let date = this.state.date
    console.log(this.state.date)
    date.setMinutes(date.getMinutes() + 60);
    if (!this.state.date)
      errors.startDate = "Select Valid Date"
    if (this.state.date < now())
      errors.startDate = "Past Dates are not allowed"
    this.setState({
      message: errors.startDate
    });
    return errors;
  }
}

export default AppointmentComponent
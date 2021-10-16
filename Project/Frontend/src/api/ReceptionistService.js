import axios from "axios"
import { API_URL } from '../Constants.js'

class ReceptionistService {

    retriveAllPatients() {
        return axios.get(`${API_URL}/patient`)
    }

    deletePatient(id) {
        return axios.delete(`${API_URL}/patient/${id}`)
    }

    getPatient(id) {
        return axios.get(`${API_URL}/patient/${id}`)
    }

    createPatient(patientName, patientEmail, password, patientType, gender, age) {

        return axios.post(`${API_URL}/patient`, { patientName, patientEmail, password, patientType, gender, age, totalBillAmount: 0 })
    }

    putPatient(id, patientName, patientEmail, password, patientType, gender, age, totalBillAmount) {
        return axios.put(`${API_URL}/patient`, { id, patientName, patientEmail, password, patientType, gender, age, totalBillAmount })
    }
    getDepartments() {
        console.log("In get Departments React")
        return axios.get(`${API_URL}/dep`)
    }
    getDoctorsByDept(id) {

        return axios.get(`${API_URL}/doctor/${id}`)
    }

    bookAppointment(deptId, doctorId, patientId, appointmentDate, appointmentTime) {

        return axios.post(`${API_URL}/patient/appointment`, {
            appointmentDate, appointmentTime, deptId, patientId, doctorId

        })
    }
    getAppoinmentList(pid) {
        return axios.get(`${API_URL}/appointment/${pid}`)
    }

}

export default new ReceptionistService()
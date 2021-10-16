import axios from "axios"
import { API_URL } from '../Constants.js'

class PatientService {

    getAppoinmentList(pid) {
        return axios.get(`${API_URL}/appointment/${pid}`)
    }

    getPrescriptionList(patientId) {
        return axios.get(`${API_URL}/prescription/${patientId}-`)
    }

    getReportList(patientId) {
        return axios.get(`${API_URL}/report/filesByPatientId?pid=${patientId}`
        )
    }

}

export default new PatientService()
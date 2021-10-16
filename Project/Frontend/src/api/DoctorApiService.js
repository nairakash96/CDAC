import axios from 'axios';


const DOCTOR_API_BASE_URL = 'http://localhost:8080/prescription';
const PHARMACIST_API_BASE_URL = 'http://localhost:8080/medicine';

class DoctorApiService {

    fetchMedicines() {
        return axios.get(PHARMACIST_API_BASE_URL);
    }

    fetchPrescription() {
        return axios.get(DOCTOR_API_BASE_URL );
    }

   fetchPrescriptionById(prescriptionId) {
        return axios.get(DOCTOR_API_BASE_URL + '/' + prescriptionId);
    }

    fetchPrescriptionByPid(prescriptionId,patientId) {
        return axios.get(DOCTOR_API_BASE_URL + '/' + prescriptionId+'/'+patientId);
    }
    

    addPrescription(prescription) {
        return axios.post(""+DOCTOR_API_BASE_URL, prescription);
    }

   
}

export default new DoctorApiService();
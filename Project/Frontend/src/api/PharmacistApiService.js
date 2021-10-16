import axios from 'axios';


const PHARMACIST_API_BASE_URL = 'http://localhost:8080/medicine';

class PharmacistApiService {

    fetchMedicines() {
        return axios.get(PHARMACIST_API_BASE_URL);
    }

    fetchMedicineById(medicineId)
    {
        return axios.get(PHARMACIST_API_BASE_URL+'/'+medicineId);
    }


    deleteMedicine(medicineId) {
        return axios.delete(PHARMACIST_API_BASE_URL + '/' + medicineId);
    }

    addMedicine(medicine) {
        return axios.post(""+PHARMACIST_API_BASE_URL, medicine);
    }

    updateMedicineDetails(medicineId,quantity) {
        return axios.put(PHARMACIST_API_BASE_URL + '/updateMedicineDetails?quantity='+quantity+'&medicineId='+medicineId);
    }


}

export default new PharmacistApiService();
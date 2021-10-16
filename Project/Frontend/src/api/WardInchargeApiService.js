import axios from 'axios';


const WARDINCHARGE_API_BASE_URL = 'http://localhost:8080/bed';

class WardIncharge_ApiService {

    fetchAvailableBeds() {
        return axios.get(WARDINCHARGE_API_BASE_URL+'/checkAvailableBeds');
    }

    fetchAllBeds() {
        return axios.get(WARDINCHARGE_API_BASE_URL);
    }

    fetchAllAllocatedBeds()
    {
        return axios.get(WARDINCHARGE_API_BASE_URL+'/checkAllocatedBeds')
    }

  fetchBedById(bedId) {
        return axios.get(WARDINCHARGE_API_BASE_URL + '/' + bedId);
    }
   
    addNewBed(bed) {
        return axios.post("" + WARDINCHARGE_API_BASE_URL, bed);
    }

    allocateBedToPatient(allocatedBedId,allocatedToPatientId,fromDate,toDate) {
        return axios.post(WARDINCHARGE_API_BASE_URL + '/allocatePatientBed?bid='+allocatedBedId+'&pid='+allocatedToPatientId+'&fromDate='+fromDate+'&toDate='+toDate);
    }


}

export default new WardIncharge_ApiService();
import axios from "axios";

const LAB_INCHARGE_API_BASE_URL = "http://localhost:8080/report";

class LabInchargeApiService {
  fetchAllBasicReports() {
    return axios.get(LAB_INCHARGE_API_BASE_URL);
  }

 

  deleteBasicReport(basicReportId) {
    return axios.delete(LAB_INCHARGE_API_BASE_URL + "/" + basicReportId);
  }

  addNewBasicReport(basicReport) {
    return axios.post("" + LAB_INCHARGE_API_BASE_URL, basicReport);
  }
}

export default new LabInchargeApiService();

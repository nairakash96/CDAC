import axios from "axios";
const EMPLOYEE_API_BASE_URL = "http://localhost:8080/employee";
class EmployeeApiService {
  fetchEmployees() {
    return axios.get(EMPLOYEE_API_BASE_URL);
  }
  addEmployee(employee) {
    return axios.post("" + EMPLOYEE_API_BASE_URL, employee);
  }
  deleteEmployee(eid) {
    return axios.delete("" + EMPLOYEE_API_BASE_URL + "/" + eid);
  }
  editEmployee(employee) {
    return axios.put("" + EMPLOYEE_API_BASE_URL + "/" + employee.id, employee);
  }
  fetchEmployeeById(eid) {
    return axios.get("" + EMPLOYEE_API_BASE_URL + "/" + eid);
  }
}
export default new EmployeeApiService();

import axios from "axios";
const DEPARTMENT_API_BASE_URL = "http://localhost:8080/department";
const ASSIGN_DEPARTMENT_API_BASE_URL =
  "http://localhost:8080/employee/assignDoctorToDepartment";
class DepartmentApiService {
  addDepartment(dept) {
    return axios.post("" + DEPARTMENT_API_BASE_URL, dept);
  }
  fetchDepartments() {
    return axios.get(DEPARTMENT_API_BASE_URL);
  }
  deleteDepartment(did) {
    return axios.delete("" + DEPARTMENT_API_BASE_URL + "/" + did);
  }
  assignDepartment(did, deptid) {
    console.log('In assign department')
    console.log(did, deptid);
    var reqparam = "?did=" + did + "&deptid=" + deptid;
    console.log(reqparam);
    return axios.put("" + ASSIGN_DEPARTMENT_API_BASE_URL + reqparam);
  }
}
export default new DepartmentApiService();

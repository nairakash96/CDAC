
import axios from "axios"
import { API_URL } from '../Constants.js'

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
export const USER_ROLE = 'userRole'
export const PATIENT_ID = 'patientId'


class AuthenticationService {


    registerSuccessfulLogin(email, password, role) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email)
        sessionStorage.setItem(USER_ROLE, role)

    }

    registerSuccessfulPatientLogin(email, password, role, id) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email)
        sessionStorage.setItem(USER_ROLE, role)
        sessionStorage.setItem(PATIENT_ID, id)

    }



    executeEmployeeAuthenticationService(email, password) {
        return axios.post(`${API_URL}/login`, {
            email,
            password
        })
        // axios.post(`${API_URL}/login`, {
        //     email,
        //     password
        // }).then((response) =>{
        //     role = response.data.role
        //     return response;
        // }
        // )
    }

    executePatientAuthenticationService(email, password) {

        return axios.post(`${API_URL}/patientlogin`, {
            email,
            password
        })


    }
    getId() {
        return sessionStorage.getItem(PATIENT_ID);
    }

    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        sessionStorage.removeItem(USER_ROLE);
        sessionStorage.removeItem(PATIENT_ID);
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        if (user === null)
            return false;
        return true;
    }

    getRole() {
        let role = sessionStorage.getItem(USER_ROLE);
        return role;
    }

    getemail() {
        let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        if (user === null)
            return null;
        return user;
    }

}

export default new AuthenticationService()
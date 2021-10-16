import axios from "axios";
const MAIL_SENDER_BASE_URL = "http://localhost:8080/sendemail";
const OTP_VERIFY_BASE_URL = "http://localhost:8080/otp";
class OtpService {
  verifyOtp(eotp) {
    return axios.get("" + OTP_VERIFY_BASE_URL + "/" + eotp);
  }
  fetchMailData(eaddr) {
    var body = {
      toEmail: eaddr,
    };
    console.log(body);
    return axios.post("" + MAIL_SENDER_BASE_URL, body);
  }
}
export default new OtpService();
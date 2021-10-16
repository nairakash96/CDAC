import http from "../http-common";

class FileUploadService {
  upload(file, onUploadProgress,reportId,patientId,reportIssueDate) {
    let formData = new FormData();

    formData.append("file", file);
    formData.append("reportId",reportId);
    formData.append("patientId",patientId);
    formData.append("rdate",reportIssueDate);
    console.log('In upload')
    return http.post("/report/upload", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    
    });
  }

  getFiles() {
    console.log('In getFiles')
    return http.get("/report/files");
  }

  getFilesByPatientID(pid)
  {
    console.log('In getFilesByPatientID')
    return http.get("/report/filesByPatientId/?pid="+pid);
  }

  

}

export default new FileUploadService();
import React, { Component } from "react";
import UploadService from "../../api/file-upload.service";
import axios from "axios";
import LabInchargeApiService from "../../api/LabInchargeApiService";
import swal from "sweetalert";
import '../Pharmacist/AddMedicineComponent.css';

export default class UploadPatientReport extends Component {
  constructor(props) {
    super(props);
    this.selectFile = this.selectFile.bind(this);
    this.upload = this.upload.bind(this);

    this.state = {
      currentFile: undefined,
      progress: 0,
      message: "",
      reportId: "",
      patientId: "",
      reportIssueDate: "",
      reportInfos: [],
      reports: [],
    };
  }

  componentDidMount() {
    UploadService.getFiles().then((response) => {
      this.setState({
        reportInfos: response.data,
      });
    });
    LabInchargeApiService.fetchAllBasicReports().then((resp) => {
      this.setState({ reports: resp.data });
      console.log(this.state.reports);
    });
  }

  selectFile(event) {
  
    this.setState({
      currentFile: event.target.files[0],
      progress: 0,
      message: "",
    });
    console.log(this.state.currentFile)
  }

  upload=(e)=> {
    e.preventDefault();
    this.setState({
      progress: 0,
    });

    UploadService.upload(
      this.state.currentFile,
      (event) => {
        this.setState({
          progress: Math.round((100 * event.loaded) / event.total),
        });
      },
      this.state.reportId,
      this.state.patientId,
      this.state.reportIssueDate
    )
      .then((response) => {
        this.setState({
          message: response.data.message,
        });
        
       return UploadService.getFiles();
        
      })
      .then((files) => {
        console.log("In files-then");
        this.setState({
          reportInfos: files.data,
        });
        swal({
          text: this.state.message,
          icon:"success",
          button: "OK",
        });
      })
      .catch((err) => {
        this.setState({
          progress: 0,
          message: err.message,
          currentFile: undefined,
        });
        swal({
          text:this.state.message,
          icon: "error",
          button: "OK",
        });
      });
     
  }

  routeChange(srNo) {
    axios({
      url: "http://localhost:8080/report/files/" + srNo,
      method: "GET",
      responseType: "blob",
    }).then((response) => {
      var fileURL = window.URL.createObjectURL(new Blob([response.data]));
      var fileLink = document.createElement("a");

      fileLink.href = fileURL;
      fileLink.setAttribute("download", "Report.pdf");
      document.body.appendChild(fileLink);

      fileLink.click();
    });
  }

  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };
  render() {
    const { currentFile, progress, message, reportInfos } = this.state;

    return (
      <div>
        <div className="addMedicineForm" style={{width:"700px"}}>
          
                    <form>
                    <h4 className="modal-title">Upload Patient Report</h4>

                            <table className="table  " style={{borderStyle:"hidden"}}>
                              
                              <tbody>
                                <tr><td align="left">Report Name</td>
                                  <td align="left">
                                  <select onChange={this.onChange} name="reportId" style={{width:"430px"}}>
                      {this.state.reports.map((rep) => (
                        <option value={rep.id} key={rep.id}>
                          {rep.reportName}
                        </option>
                      ))}
                    </select>
                                  </td>
                                </tr>
                                <tr>
                                  <td align="left">
                                    Patient ID :
                                  </td>
                                  <td>
                                  <input
                      type="text"
                      name="patientId"
                      className="form-control"
                      onChange={this.onChange}
                    />
                                  </td>
                                </tr>

                                <tr>
                                  <td align="left">
                                    Report Issue Date :
                                  </td>
                                  <td>
                                  <input
                      type="date"
                      name="reportIssueDate"
                      className="form-control"
                      onChange={this.onChange}
                    />
                                  </td>
                                </tr>
                                <tr >

                                  <td colSpan="2" align="left"  > <input
                        type="file"
                        accept="image/*"
                        onChange={this.selectFile}
                      />
                                    </td>
                                </tr>
                                <tr>
                                  <td colSpan="2" align="center">
                                  <button
                      className="btn btn-success "
                      disabled={!currentFile}
                      onClick={this.upload} 
                      style={{height:"40px"}}
                    >
                      Upload Patient Report
                    </button>
                                  </td>
                                </tr>

                              </tbody>
                              </table>  

                  
                 
                            </form>
                    </div>
              {currentFile && (
                <div className="progress my-3">
                  <div
                    className="progress-bar progress-bar-info progress-bar-striped"
                    role="progressbar"
                    aria-valuenow={progress}
                    aria-valuemin="0"
                    aria-valuemax="100"
                    style={{ width: progress + "%" }}
                  >
                    {progress}%
                  </div>
                </div>
              )}

              {message && (
                <div className="alert alert-secondary mt-3" role="alert">
                  {message}
                </div>
              )}

<div className="container table-responsive py-5">


<h2 className="text-center role">Patient Reports Inventory</h2>
<br></br>
<table className="table  table-striped" style={{borderStyle:"hidden"}}  >
    <thead className="thead-dark">
    <tr>
                      <th>Patient ID</th>
                      <th>Report Name</th>
                      <th>Report Issue Date</th>
                      <th>Download Report</th>
                    </tr>
    </thead>
    <tbody>
                    {reportInfos &&
                      reportInfos.map((file) => (
                        <tr>
                          <td  key={file.srNo}>
                            {file.patientId}
                          </td>
                          <td> {file.reportName} </td>
                          <td> {file.reportIssueDate} </td>
                          <td>
                            <button
                              className="btn btn-success"
                              onClick={() => this.routeChange(file.srNo)}
                              style={{ marginLeft: "20px" }}
                            >
                              Download Report
                            </button>
                          </td>
                        </tr>
                      ))}
                  </tbody>
</table>


</div>

              
            </div>
        
    );
  }
}

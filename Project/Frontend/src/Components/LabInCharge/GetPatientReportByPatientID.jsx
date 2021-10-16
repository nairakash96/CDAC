import React, { Component } from "react";
import UploadService from "../../api/file-upload.service";
import axios from "axios";

export default class GetPatientReportByPatientID extends Component {
  constructor(props) {
    super(props);

    this.state = {
      message: "",
      pid: "",
      reportInfos: [],
    };
  }

  fetchReportByPatientID = (e) => {
    e.preventDefault();
    UploadService.getFilesByPatientID(parseInt(this.state.pid)).then(
      (response) => {
        this.setState({
          reportInfos: response.data,
        });
      }
    );
    console.log(this.state.reportInfos);
  };

  routeChange(srNo) {
    axios({
      url: "http://localhost:8080/report/files/" + srNo,
      method: "GET",
      responseType: "blob",
    }).then((response) => {
      var fileURL = window.URL.createObjectURL(new Blob([response.data]));
      var fileLink = document.createElement("a");

      fileLink.href = fileURL;
      fileLink.setAttribute("download", "file.pdf");
      document.body.appendChild(fileLink);

      fileLink.click();
    });
  }

  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };
  render() {
    return (
      <div>
         <div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Get Patient Report Details</h4>

                                <div className="form-group">
                                   
                                <input placeholder="Enter Patient ID"
                      type="text"
                      name="pid"
                      className="form-control"
                      onChange={this.onChange}
                    />                                </div>

                              <div>
<button
                    className="btn btn-success"
                    onClick={this.fetchReportByPatientID}
                    style={{ marginLeft: "20px" }}
                  >Get Reports </button></div>
                            </form>
                    </div>
        
              <div>
                {this.state.message && (
                  <div className="alert alert-secondary mt-3" role="alert">
                    {this.state.message}
                  </div>
                )}
              </div>

              <div class="container table-responsive py-5">


<h2 className="text-center ">Patient Reports</h2>
<br></br>
<table className="table table-striped"  style={{borderStyle:"hidden"}} >
    <thead class="thead-dark">
    <tr>
                            
                            <th>Report Name</th>
                            <th>Report Issue Date</th>
                            <th></th>
                        </tr>
    </thead>
    <tbody>
                    {this.state.reportInfos &&
                      this.state.reportInfos.map((file) => (
                        <tr>
                          <td key={file.srNo}>
                            {file.reportName}{" "}
                          </td>
                          <td>{file.reportIssueDate}</td>
                          <td>
                            {" "}
                            <button
                              className="btn btn-success"
                              onClick={() => this.routeChange(file.srNo)}
                              style={{ marginLeft: "20px" }}
                            >
                              {" "}
                              View Report
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

import React, { Component } from "react";
import PatientService from "../../api/PatientService.js";
import { Link } from "react-router-dom";

class ListReportComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.pid,
      report: [],
    };
  }

  componentDidMount() {
    PatientService.getReportList(this.state.id)
      .then((response) => {
        console.log("response");
        console.log(response);
        this.setState({
          report: response.data,
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }
  render() {
    return (
      <div>
        <div class="row mt-5 ml-3 mr-3 justify-content-center">
          {this.state.report.length !== 0 && <div className="container py-4">
            <h1 >Patient Report List</h1><br></br>
            <table className="table">
              <thead className="thead-dark">
                <tr>
                  <th>Report Download Link</th>
                  <th>Size</th>
                </tr>
              </thead>
              <tbody>
                {this.state.report.map(function (data, index) {
                  let path = `/${data.url}`;
                  console.log(path);
                  return (

                    <tr key={index}>
                      <td><i >Download here &#8594;    </i>
                        <Link
                          to={{
                            pathname: `${data.url}`,
                          }}
                          target="_blank"
                          style={{ fontSize: "20px" }}
                        >
                          {" "}
                          Report no- {index + 1}{" "}
                        </Link>
                      </td>
                      <td><i class="text-right" style={{ fontSize: "20px" }}>
                        {" "}
                        size: {Math.ceil(data.size / 1024)} KB
                      </i>
                      </td>
                    </tr>
                  )
                })}
              </tbody>
            </table>
          </div>}
          {this.state.report.length === 0 && <h1>No Report</h1>}
        </div>
      </div>

    );
  }
}


export default ListReportComponent;

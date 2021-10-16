import React, { Component } from 'react'
import LabInchargeApiService from "../../api/LabInchargeApiService";

class ListBasicReportDetails extends Component {

    constructor(props) {
        super(props)
        this.state = {
            reports: [],
            message: null
        }
        this.reloadBasicReportsList = this.reloadBasicReportsList.bind(this);
        this.deleteBasicReport = this.deleteBasicReport.bind(this);

    }

    componentDidMount() {
        this.reloadBasicReportsList();
    }

    reloadBasicReportsList() {
        LabInchargeApiService.fetchAllBasicReports()
            .then((resp) => {
                this.setState({reports: resp.data})
                console.log(this.state.reports);
            });
    }

    deleteBasicReport(basicReportId) {
        LabInchargeApiService.deleteBasicReport(basicReportId)
           .then(res => {
               this.setState({message : 'Basic Report deleted successfully.'});
               this.setState({reports: this.state.reports.filter(repo => repo.id !== basicReportId)});
           })
           console.log(this.state.message);
    }

    
    render() {
        return (
            <div>
                 <div class="container table-responsive py-5">


<h2 className="text-center role">Basic Reports Inventory</h2>
<br></br>
<table className="table  table-hover table-bordered"  >
    <thead class="thead-dark">
    <tr>
                            
                            <th>Report ID</th>
                            <th>Report Name</th>
                            <th></th>
                        </tr>
    </thead>
    <tbody>
                        {
                            this.state.reports.map(
                        report =>
                                    <tr key={report.id}>
                                        <td>{report.id}</td>
                                        <td>{report.reportName}</td>
                                        <td>
                                            <button className="btn btn-success" onClick={() => this.deleteBasicReport(report.id)} style={{marginLeft: '20px'}}> Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
</table>


</div>




                
            </div>
        );
    }

}

export default ListBasicReportDetails;
import React,{Component} from 'react';
import LabInchargeApiService from '../../api/LabInchargeApiService';
import swal from "sweetalert";
import '../Pharmacist/AddMedicineComponent.css'
class AddNewBasicReport extends Component
{
    constructor(props)
    {
        super(props);
        this.state={
            reportName:'',
            message:null

        }
        this.saveNewBasicReport=this.saveNewBasicReport.bind(this);
    }

    saveNewBasicReport=(e)=>{
        e.preventDefault();
        
            let basicreport={
                reportName:this.state.reportName
            }
            
            LabInchargeApiService.addNewBasicReport(basicreport)
            .then(resp=>{
                console.log(resp.data);
                this.setState({message:'Basic Report Details  Added Successfully'});
                swal({
                    title: this.state.message,
                    icon: "success",
                    button: "Done",
                  });
                this.props.history.push('/reports');
            }).catch(err=>{
                console.error(err.response.data);
                swal({
                    title: "Duplicate Report Name-Please enter correct Basic Report Details",
                    icon: "error",
                    button: "OK",
                  });
                this.props.history.push('/reports')
            });
        
    }

    onChange=(e)=> {
     
        this.setState({[e.target.name]:e.target.value});}

    render() {
        return(
            <div>
                <div className="addMedicineForm">
                    <form>
                            <h4 className="modal-title">Add New Basic Report</h4>

                                <div className="form-group">
                                   
                                <input type="text" placeholder="Enter Basic Report Name" name="reportName" className="form-control" value={this.state.reportName} onChange={this.onChange}/>
                                </div>

                              
                                <button className="btn btn-success" onClick={this.saveNewBasicReport}>Save </button>
                            </form>
                    </div>
               
    </div>
        );
    }

}

export default AddNewBasicReport;
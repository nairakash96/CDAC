import React,{Component} from 'react';

class StatefulComp extends Component{

    state={
        name:"Akash",
        email:"nairakash96@gmail.com",
        age:"25"
    }
    render(){
        return(
            <div>
                <h3>Name:{this.state.name}</h3>
                <h3>Email:{this.state.email}</h3>
            </div>
        );
    }
}
export default StatefulComp;
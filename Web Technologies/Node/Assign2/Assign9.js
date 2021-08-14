var fs=require("fs");
fs.readFile("Cust.json",function(err,data){
    if(err){
        console.log(err);
    }
    else{
        var dat=JSON.parse(data);
        var emp=dat.Cust;
        console.log("Name\tDept\tSal");
        for(e of emp)
        console.log(e.Name+"\t"+e.Dept+"\t"+e.Sal);
    }
})
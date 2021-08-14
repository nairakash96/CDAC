var fs=require("fs");
var data=["Ashokan","Akash","Anju","Prasanna"]
var newdata=[];
    var newdata=data.toString().split(",").sort().join("|");
fs.writeFile("name.txt",newdata.toString(),function(err){
    if(!err){
        console.log("Writing")
    }
});

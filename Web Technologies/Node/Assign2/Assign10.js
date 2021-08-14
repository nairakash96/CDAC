var fs=require("fs");
fs.readFile("empinfo.txt",function(err,data){
    if(err){
    console.log("Error Reading ");
}
else{
    var dt=data.toString();
    fs.appendFile("resignEmp.txt",dt,function(err,data){
        if(err){
            console.log(err);
        }
        console.log("Appending Succesfully done");
    })
}
})
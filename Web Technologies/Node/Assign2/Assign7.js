var fs=require("fs");
fs.readFile("emp.txt",function(err,data){
    if(err){
        console.log(err);
    }
    else{
    var arr=data.toString().split("\n");
    var tot=0;
    for(i=0;i<arr.length;i++){
        var newarr=arr[i].split(":");
        for(j=3;j<newarr.length;j+=4){
            tot=parseInt(tot+parseInt(newarr[j]));
        }
    }
    console.log("Total Salary "+tot);
}
})
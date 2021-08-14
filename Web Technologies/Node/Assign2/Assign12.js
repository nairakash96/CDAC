var fs=require("fs");
fs.readFile("data12.txt",function(err,data){
    if(err){
        console.log(err);
    }
    else{
        var a=data.toString().split("\n");
        for(i=0;i<a.length;i++)
        console.log((i+1)+"."+a[i]);
        
    }
});
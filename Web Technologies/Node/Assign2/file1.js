var fs=require("fs");

/*fs.writeFileSync("data.txt","Hello World, welcome to fs");
var data=fs.readFileSync("data.txt","utf8");
console.log(data);*/

/*
fs.readFile("data1.txt",function(err,data){
    if(err)
        return console.error(err);
    console.log(data.toString());
})
*/
/*fs.writeFile("data.txt","101:Alpha",function(err){
    if(err)
    console.log(err);
})*/

fs.appendFile("data1.txt","\n102:Beta",function(err){
    if(err)
    console.log(err);
})


var readl=require("readline");
var inp=readl.createInterface({
    input:process.stdin,
    output:process.stdout
})
inp.question("Enter your Name ",function(name){
    console.log("Your Name is "+name);
})
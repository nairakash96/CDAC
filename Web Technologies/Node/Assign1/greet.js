var current=new Date();
var curr=current.getHours();
exports.greet=function(){
if(curr<12){
  console.log("Good Morning");
}
else if(curr >= 12 && curr <16){
  console.log("Good Afternoon");
}
else{
  console.log("Good Evening");
}
}
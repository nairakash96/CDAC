exports.greet=function(){
    var  date=new Date();
    var hour=date.getHours();
    if(hour<12)
      return ("<h1>Good Morning</h1>");
    else if(hour<17)
       return ("<h1>Good after noon</h1>");
    else if(hour<22)
        return ("<h1>Good Evening</h1>");
    else
         return ("<h1>Good Night</h1>");
  }
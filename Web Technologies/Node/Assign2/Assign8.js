var fs=require('fs')
var Obj=function(empname,dept,sal){
    this.firstName=empname;
    this.depart=dept;
    this.salary=sal;

}
var c=new Obj('Alpha','comp',20000);
console.log(c);
var d=new Obj('Bete','entc',60000);
var e=new Obj('Gama','it',50000);
var f=new Obj('Delta','it',70000);
var arr=[];
arr.push(c,d,e,f);
console.log(arr);

arr.forEach(function(e){
    fs.appendFile('delta.txt',e.firstName+":"+e.depart+":"+e.salary+"\n",function(err){
        if(err)
            console.error(err);
        console.log("updated successfully")
    })
})
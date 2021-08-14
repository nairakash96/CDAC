var fs=require('fs')
var Obj=function(empname,dept,sal){
    this.firstName=empname;
    this.depart=dept;
    this.salary=sal;

}
var c=[{firstName:'Alpha',Dept:'comp',Sal:20000},
        {firstName:'Bete',Depr:'entc',Sal:60000},
        {firstName:'Gama',Dept:'it',Sal:50000},
        {firstName:'Delta',Dept:'it',Sal:70000}];
        var arr=[];
for(i=0;i<c.length;i++){
arr.push(c[i]);
}
console.log(arr);

arr.forEach(function(e){
    fs.writeFile('abc.txt',e.firstName+":"+e.depart+":"+e.salary+"\n",function(err){
        if(err)
            console.error(err);
        console.log("updated successfully")
    })
})
var fs=require("fs");
fs.readFile("bookData.json",function(err,data){
    if(err){
        console.log(err);
    }
    else{
        var dat=JSON.parse(data);
        var bk=dat.Books;
        for(e of bk){
            console.log("Title "+e.Title+"\tAuther "+e.Auther+"\tPrice "+e.Price);
        }
    }
})
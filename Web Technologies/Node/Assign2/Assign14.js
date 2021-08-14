var http=require("http");
var url=require("url");
var fs=require("fs");
var fun=require("./greetUser");

var srv=http.createServer(processRequest);
srv.listen(7682,'127.0.0.1');
console.log("the server is listning at port 7682");

function processRequest(req,res){
    var q=url.parse(req.url,true);
    var weburl=q.pathname;
    if(weburl=="/"){
        res.writeHead(200,{"Content-Type":"text/html"});
     res.write(fun.greet());
    }
}

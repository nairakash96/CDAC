var http=require("http");
var fs=require("fs");
function process_request(req,res){
    fs.readFile("First.html",function(err,data){
        res.writeHead(200,{'Content-Type':"test/html"});
        res.end();
    });
}
var s=http.createServer(process_request);
s.listen(1337,"127.0.0.1");
console.log("Server running");
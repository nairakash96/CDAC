var http = require('http');
var url = require('url');
var fs = require('fs');

function process_req(req, res) {
   console.log(req.url);
   console.log(req.url.substring(0,10));
  if (req.method == 'GET' && req.url == '/') {
	  fs.readFile('login.html', function(err, data) {
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.write(data);
      res.end();
   });
  }
  else if(req.method == 'GET' && req.url.substring(0,13) == '/processlogin'){
     var q = url.parse(req.url, true);
	 var qdata = q.query;
     console.log(qdata.passwd); 
     console.log(qdata.uname);
     var uname = qdata.uname;
     var passwd = qdata.passwd
     if(uname == "admin" && passwd == "admin123"){
        fs.readFile("success.html", function(err, data) {
           if (err) {
              res.writeHead(404, {'Content-Type': 'text/html'});
              res.end("404 Not Found");
           }  
            res.writeHead(200, {'Content-Type': 'text/html'});
            res.write(data);
            res.end();
        });
	 }
   }
   else if(req.method == 'GET' && req.url.substring(0,7) == '/jbooks'){
      console.log("in jbooks");

      fs.readFile('javabooks.html', function(err, data) {
         res.writeHead(200, {'Content-Type': 'text/html'});
         res.write(data);
         res.end();
      });
   }
   else if(req.method == 'GET' && req.url.substring(0,7) == '/nbooks'){
      console.log("in nbooks");

      fs.readFile('nodebooks.html', function(err, data) {
         res.writeHead(200, {'Content-Type': 'text/html'});
         res.write(data);
         res.end();
      });
   }
   else
	   res.end("not found");
}
var server = http.createServer(process_req)
server.listen(3000);
console.log('server listening on localhost:3000');

var http = require('http');
var url = require('url');
var fs = require('fs');

function process_req(req, res) {
	console.log(req.url);
  if (req.method == 'GET' && req.url == '/') {
	  fs.readFile('RectArea.html', function(err, data) {
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.write(data);
      res.end();
   });
  }
  else if(req.method == 'GET' && req.url.substring(0,8) == '/process'){
     var q = url.parse(req.url, true);
	   var qdata = q.query;

      var l=qdata.len;
     var b = qdata.br;
   
     var area = l*b;
     var perimeter=2*(l+b);
     res.writeHead(200, {'Content-Type': 'text/html'});
      res.write("length="+l+" breath="+b);
     res.write(" The area is : " + area);
     res.write(" Perimeter "+ perimeter);
     
     res.end();
   }
  
   else
	   res.end("not found");
}
var server = http.createServer(process_req)
server.listen(3000);
console.log('server listening on localhost:3000');

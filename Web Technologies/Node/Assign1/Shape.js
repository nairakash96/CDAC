var oppCir=require("./Circle")
var oppRect=require("./Rectangle")
var oppTri=require("./Triangle")
console.log("Area of circle "+oppCir.calcArea(5)+"\nCircunfrence of circle "+oppCir.calcCircumfrence(5)+"\nDiameter of circle "+oppCir.calcDiameter(5))
console.log("Area of Rectangle "+oppRect.calcArea(5,10)+"\nPerimeter of Rectangle "+oppRect.calcPerimeter(5,10));
console.log(oppTri.isEquilateral(5,10,5)+"\nPerimeter of Triangle "+oppTri.calcPerimeter(5,10,5));

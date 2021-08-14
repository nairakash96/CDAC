module.exports={
    isEquilateral:function(s1,s2,s3){
        if(s1==s2==s3){
            console.log("Equilateral Triangle ");
        }
        else{
            console.log("Non Equilateral Triangle ");
        }
    },
    calcPerimeter:function(s1,s2,s3){
        return s1+s2+s3;
    }
}
module.exports={
    palindrom:function(str){
        str2=str.split("").reverse().join("");
        if(str==str2){
            console.log(str+" is Palindrom\n");
        }
        else{
            console.log(str+" is NOT Palindrom\n");
        }
    },
    upper:function(str){
        console.log(str+" Uppercase ---> "+str.toUpperCase());
    },
    search:function(arr){
        
        return arr.filter(function(e){ return e.startsWith("www")}).length

    }
    
}
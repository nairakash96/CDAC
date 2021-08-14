module.exports={
    add:function(a,b){
    return a+b;
    },
    sub:function(a,b){
        return a-b;
    },
    mul:function(a,b){
        return a*b;
    },
    div:function(a,b){
        return a/b;
    },
    square:function(a){
        return a*a;
    },
    sum:function(){
        var sm=0,i=0;
        while(i<arguments.length){
            sm+=arguments[i++];
        }
        return sm;
    }
}
/*sum:function(){
    var sm=0;
    for(ele of arguments){
        sum+=ele;
    }
    return sm;
}

sum:function(...abc){
    var sm=0;
    for(ele of abc){
        sm+=ele;
    }
    return sm;
}
*/
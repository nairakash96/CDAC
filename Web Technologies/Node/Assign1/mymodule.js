module.exports={
    factorial:function(a){
        f=1;
        for(i=1;i<=a;i++){
            f*=i;
        }
    return f;
    },
    prime:function(a){
        p=1;
        for(i=2;i<a;i++){
            if(a%i==0){
                p=0;
            }
        }
        if(a==2||p==1){
            console.log(a+" is a prime number");
        }
        else{
            console.log(a+" is not a prime number");
        }
    },
    printable:function(a){
        for(i=1;i<=10;i++){
            console.log(a+" x "+i+" = "+a*i);
        }
    }
}
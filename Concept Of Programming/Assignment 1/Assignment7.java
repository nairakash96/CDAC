class Assignment7{
public static void main(String args[]){
int p=Integer.parseInt(args[0]);
float r=Float.parsefloat(args[1]);
int t=Integer.parseInt(args[2]);
double SI=(p*r*t)/100.0;
System.out.println("Simple Intrest = "+SI);
System.out.println("Total ammount = "+(SI+p));
}
}
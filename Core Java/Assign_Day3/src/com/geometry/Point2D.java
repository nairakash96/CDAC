package com.geometry;
public class Point2D{
    int x,y;
    public Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean isEqual(Point2D ptr2){
        return this.x==ptr2.x && this.y==ptr2.y;
    }
    public String getDetails(){
        return "X="+this.x+" Y="+this.y;
    }
    public double calculateDistance(Point2D ptr2){
        double dis=Math.pow(this.x-ptr2.x,2)+Math.pow(this.y -ptr2.y,2);
        return Math.sqrt(dis);
    }
}

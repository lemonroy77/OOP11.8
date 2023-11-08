class Triangle{
    private double a,b,c;//用private修饰的成员，在类外部就不能使用
    public Triangle(){a=1;b=1;c=1;}
    private boolean limit(double x,double y,double z){
        return (x>0&&y>0&&z>0&&x+y>z&&x+z>y&&y+z>x);
    }
    public void setEdges(double x,double y,double z){
        if(limit(x,y,z)==false) return;
        else {a=x;b=y;c=z;}
    }
    public String toString(){return "a="+a+",b="+b+",c="+c;}
    public boolean equals(Triangle t){
        String s=a+","+b+","+c;
        String x,y,z;
        x=t.a+"";y=t.b+"";z=t.c+"";
        if(s.indexOf(x)<0) return false;
        else s=s.replaceFirst(x,"#");
        if(s.indexOf(y)<0) return false;
        else s=s.replaceFirst(y,"#");
        if(s.indexOf(z)<0) return false;
        else return true;
        }
}
class App{
    public static void main(String [] args){
        Triangle t1,t2,t3;
        t1=new Triangle();
        t1.setEdges(1,2,3);
        System.out.println("赋值1,2,3,t1:"+t1);
        t1.setEdges(2,3,4);
        System.out.println("赋值2,3,4,t1:"+t1);
        t2=new Triangle();
        t2.setEdges(3,4,2);
        System.out.println("赋值3,4,2,t2:"+t2);
        t3=new Triangle();
        t3.setEdges(3,4,5);
        System.out.println("赋值3,4,5,t3:"+t3);
        System.out.print("t1==t2:"+t1.equals(t2));
        System.out.print("t1==t3:"+t1.equals(t3));
     }
}
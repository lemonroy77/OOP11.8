/*②设立三个构造函数：输入1/2/3条边构造三角形。当然，
若边值不满足约束，则只能创建边值为1的单位三角型；
③新增直角三角形类RtTriangle，作为Triangle的子类，
它有两个构造函数：通过两条直角边构造；或是通过三条边构造，
要求，若给定的三边不满足直角三角约束，只能创建以3、4、5为边长的
直角三角。*/
package SJ;
public class SJ {
	private double a;
	private double b;
	private double c;//三角形的三边a,b,c
	public boolean limit(double x, double y, double z) {  //正确三角形的约束条件
		return (x>0&&y>0&&z>0&&x+y>z&&x+z>y&&y+z>x);
	}
	public void setEdges(double x,double y,double z) { //三角形是否正确判断
		if(limit(x,y,z)==false) return;
		else {a=x;b=y;c=z;}
	}
	public SJ(double x, double y, double z){//普通三角形或单位三角形
		if(limit(x,y,z)==false) {a=1;b=1;c=1;}
		else {a=x;b=y;c=z;}
	}
	public SJ(double x, double y){//等腰三角形，x是底，y是腰
		this(x,y,y);
	}
	public SJ(double x){//等边三角形
		this(x,x,x);
	}
	public boolean equals(SJ t) {//通过判断边是否相等判断两三角形是否全等
		String s=a+","+b+","+c;			//将三边连接成字符串
		String x,y,z;x=t.a+"";y=t.b+"";z=t.c+"";  //将三边转换成字符串
		if(s.indexOf(x)<0)return false;//若边x在s中不存在，则不可能全等
		else s=s.replaceFirst(x,"#");//把s中的x用#替换，即删除其中的x
		if(s.indexOf(y)<0)return false;//若边y在s中不存在，则不可能全等
		else s=s.replaceFirst(y,"#");//把s中的y用#替换，即删除其中的y
		if(s.indexOf(z)<0)return false;
		else return true;
	}
	public String toString() {return "a="+a+",b="+b+",c="+c;}
}
class RtSJ extends SJ{//直角三角形继承三角形
	public RtSJ(double x,double y) {super(x,y,Math.sqrt(x*x+y*y));}//通过直角边构造三角形，由于a,b,c被private，所以要主动调用构造函数
	public RtSJ(double x,double y,double z) {
		super(x,y,z);
		if((x*x+y*y!=z*z)||(limit(x,y,z)==false)) setEdges(3,4,5);//若无法构成直角三角形，则直接创建单位直角三角形
		
	}
}
class App{
	public static void main(String[] args) {
		SJ t1,t2;
		t1 = new SJ(1,2,3);t2 = new SJ(1);  //创建三角形t1,t2
		System.out.println("赋值1,2,3, 三角形t1："+t1);
		System.out.println("赋值1, 三角形t2："+t2);
		System.out.println("t1==t2:"+t1.equals(t2));	//判断t1与t2是否全等
		t2.setEdges(3,4,5);  //修改t2的赋值
		System.out.println("赋值3,4,5,三角形t2："+t2);
		System.out.println("t1==t2:"+t1.equals(t2));	//判断t1与t2是否全等
		RtSJ t3 = new RtSJ(3,4);     //创建直角三角形t3
		System.out.println("赋值3,4,直角三角形t3："+t3);
		RtSJ t4 = new RtSJ(-3,-4,5);   //创建直角三角形t4
		System.out.println("赋值-3,-4,5,直角三角形t4："+t4);
	}
}

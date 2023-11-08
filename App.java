class Ally{                            //游戏中的联盟
   String name;                        //联盟的名称
   final int maxNum=10;
   Player[] player = new Player[maxNum];//联盟的玩家
   Ally(String s){name=s;} 
   void addMember(Player p){            //增加成员
    for(int i=0;i<player.length;i++)
    if(player[i]==null){
        player[i]=p;return;}
        System.out.print("\n该联盟成员已满,无法加入!\n");
    }
    public String toString(){
        String s="【"+name+"】全部成员：";
        for(int i=0;i<player.length;i++)
        if(player[i]!=null)s=s+player[i]+" ";
    return s;    
     }
   }
class Player{
    String name;
    Ally ally;
    Player(String n,Ally a){
        name=n;
        this.ally=a;
        ally.addMember(this);
    }
    Player(String n){name=n;ally=null;}
    public String toString(){return name;}
    boolean isFriend(Player p){
        if(this.ally==null||p.ally==null) return false;
        return this.ally==p.ally;
    }
    void showIsFriend(Player p){
        String result=(isFriend(p)==true)?"是！":"不是!";
        System.out.print(name+" 与 "+p.name+" 是朋友？"+result+"\n");   }
    void showAllyInfo(){//System.out.println(ally);
    if(ally!=null) System.out.println(ally);
else System.out.println(name+" 是独行侠，未加入任何联盟！");
}
}
class App{
    public static void main(String[] args){
        Ally a1,a2;
        a1=new Ally("逍遥派");
        a2=new Ally("雷霆战队");
        Player[] p={new Player("王大",a1),new Player("赵二"),
        new Player("张三",a1),new Player("李四",a1),
        new Player("王五",a2),
        new Player("马六")};
        System.out.println("======组队情况如下：");
        System.out.print(a1+"\n"+a2+"\n");
        System.out.print("======验证玩家显示联盟信息,以p[0],p[1],p[5]为例：\n");
        p[0].showAllyInfo();
        p[1].showAllyInfo();
        p[5].showAllyInfo();
        System.out.print("======验证是否成为朋友：\n");
        p[0].showIsFriend(p[1]);
        p[0].showIsFriend(p[2]);
        p[1].showIsFriend(p[5]);
    }
}
import java.util.Scanner;

class Television {    
    private int channel;

    public Television(int channel) {  
        this.channel = channel;  
    }

    public void setChannel(int channel) {  
        this.channel = channel;  
    }

    public int getChannel() {  
        return channel;  
    }

    public void displayChannel() {  
        System.out.println("当前频道：" + channel);  
    }  
}

class RemoteController {  
    private Television television;

    public RemoteController(Television television) {  
        this.television = television;  
    }

    public void adjustChannel(int channel) {  
        television.setChannel(channel);  
        television.displayChannel();  
    }  
}

public class Main {  
    public static void main(String[] args) {  
        Television television = new Television(1);  
        RemoteController remoteController = new RemoteController(television);
        Scanner scanner = new Scanner(System.in);  
        System.out.println("请输入要调整的频道：");  
        int inputChannel = scanner.nextInt();
        remoteController.adjustChannel(inputChannel);  
    }  
}

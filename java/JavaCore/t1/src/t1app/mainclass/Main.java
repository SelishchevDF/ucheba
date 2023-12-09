package t1app.mainclass;
import t1app.otherclasses.HelloClass;
import t1app.otherclasses.WorldClass;


// C:\Users\Selishchev\Desktop\JavaCore\t1>javac -sourcepath ./src -d out src/t1app/mainclass/Main.java
// C:\Users\Selishchev\Desktop\JavaCore\t1>java -classpath ./out t1app.mainclass.Main

public class Main {
    public static void main(String[] args) {

        System.out.println(HelloClass.stringHello() + ", " + WorldClass.stringWorld() + "!");
    }
}

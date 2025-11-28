import java.io.Serializable;

public class Person  implements Serializable {

    private String name;
    public static  int x;

    public void printInfo(){
        x = 1;
        System.out.println(x);
    }
}

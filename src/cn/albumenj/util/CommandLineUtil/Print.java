package cn.albumenj.util.commandlineutil;

/**
 * @author Albumen
 */
public class Print {
    public static void flush()
    {
        for (int i = 0;i<70;i++) {
            System.out.println();
        }
    }
    public static void printLine()
    {
        System.out.println();
        for (int i = 0;i<40;i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();
    }

    public static void printChoice(String str){
        for (int i = 0;i<10;i++) {
            System.out.print(" ");
        }
        System.out.println(str);
    }

    public static void printWelcome(String name){
        System.out.println("尊敬的" + name + "，您好：");
    }
}

package cn.albumenj.util.commandlineutil;

/**
 * @author Albumen
 */
public class PrintLine {
    public static void print()
    {
        System.out.println();
        for (int i = 0;i<40;i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();
    }
}

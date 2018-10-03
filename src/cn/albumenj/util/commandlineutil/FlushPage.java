package cn.albumenj.util.commandlineutil;

/**
 * @author Albumen
 */
public class FlushPage {
    public static void flush()
    {
        for (int i = 0;i<70;i++) {
            System.out.println();
        }
    }
}

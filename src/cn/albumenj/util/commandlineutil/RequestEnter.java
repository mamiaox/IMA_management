package cn.albumenj.util.commandlineutil;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Albumen
 */
public class RequestEnter {

    private static Scanner scanner = new Scanner(System.in);

    public static int requestInt(){
        try{
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("您的输入有误!");
            return 0;
        }
    }

    public static String requestString(){
        return scanner.next();
    }

    public static boolean requestContinueDo(){
        System.out.print("是否继续执行（是 1 /否 2）：");
        switch (requestInt()){
            case 1:
                return true;
            case 2:
                return false;
            default:
                return false;
        }
    }

    public static void requestContinue(){
        System.out.println("请输入任意内容以返回。");
        requestString();
    }
}

package cn.albumenj.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RequestEnter {

    static Scanner scanner = new Scanner(System.in);

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
}

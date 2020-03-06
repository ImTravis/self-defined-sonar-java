package org.finger.java.rule.checks.namerules;

/**
 * Created by huqingen on 2017/3/17.
 */
public class HiCHildFunction {// Noncompliant

    public static void getB(String password){
        System.out.println("bbb"+password);
    }

    public  static String reseatName(){
        return "reseat name";
    }
}

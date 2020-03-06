package org.finger.java.rule.checks.namerules;

/**
 * Created by huqingen on 2017/3/17.
 */
public abstract class HiClass {// Noncompliant

    @Autowire
    private HiChildFunction hiChildFunction;

    private String a = "a";

    public static void sayBey(){

        name = HiCHildFunction.reseatName();
    }



    public static void sayHelloWord(){
        String name ="travis";



        if("travis".equals(name)){
            name ="aa";
            String password ="bb";
            name = HiCHildFunction.reseatName();

            if(name.equals("aa")){
                name = HiCHildFunction.reseatName();
            }
        }

        for(int k=0;k<10;k++){
            String password="2";
            hiChildFunction.getB(password);
            for(int l=0;l<10;l++){
                hiChildFunction.getB(password);
                for(int p=0;p<10;p++){
                    hiChildFunction.getB(password);
                }
            }
        }
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }


}

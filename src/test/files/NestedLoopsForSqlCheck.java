package org.finger.java.rule.checks.namerules;

public class NestedLoopsForSqlCheck {

    public void checkSql1() {
        for (int k = 0; k < 10; k++) {
            String a ="a";
            dbQuery();
        }
    }

    public void dbQuery() {
        System.out.println("c测试");
    }

    public void checkSql2() {
        for (int k = 0; k < 10; k++) {
            for (int a = 0; a < 10; a++){
                checkSql1();
            }

        }
    }

}

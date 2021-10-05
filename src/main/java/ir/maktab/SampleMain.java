package ir.maktab;

import ir.maktab.util.ApplicationContext;

public class SampleMain {
    public static void main(String[] args) {
        try {
            ApplicationContext.getUserService().login("userfake", "123456");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

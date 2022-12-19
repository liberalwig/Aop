package co.kr.mono.aop.ui;

public class BluePrinter implements Printer{
    @Override
    public void print(String msg) {

        System.out.println("----- BluePrinter Start -----");
        System.out.println(msg);
        System.out.println("----- BluePrinter End -----");

    }
}

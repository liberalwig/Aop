package co.kr.mono.aop.ui;

public class MonoPrinter implements Printer{
    @Override
    public void print(String msg) {

        System.out.println("----- MonoPrinter Start -----");
        System.out.println(msg);
        System.out.println("----- MonoPrinter End -----");

    }
}

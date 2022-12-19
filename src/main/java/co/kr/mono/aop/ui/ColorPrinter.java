package co.kr.mono.aop.ui;

import org.springframework.stereotype.Component;

@Component
public class ColorPrinter implements Printer{
    @Override
    public void print(String msg) {

        System.out.println("----- ColorPrinter Start -----");
        System.out.println(msg);
        System.out.println("----- ColorPrinter End -----");

    }
}

package co.kr.mono.aop.ui;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MonoPrinter implements Printer{
    @Override
    public void print(String msg) {

        System.out.println("----- MonoPrinter Start -----");
        System.out.println(msg);
        System.out.println("----- MonoPrinter End -----");

    }
}

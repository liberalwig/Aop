package co.kr.mono.aop.config;

import co.kr.mono.aop.entity.ExamScore;
import co.kr.mono.aop.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

@ComponentScan(basePackages = "co.kr.mono.aop")
@Configuration
@EnableAspectJAutoProxy // 프록시 생성
public class Config {

    @Bean
    Person person() {
        ArrayList<ExamScore> examScoreList = new ArrayList<>();
        examScoreList.add(new ExamScore("1", 100, 97, 80));
        examScoreList.add(new ExamScore("2", 70, 93, 90));
        examScoreList.add(new ExamScore("3", 86, 90, 50));

        Person person = new Person();
        person.setName("홍길동");
        person.setMajor("영문학");
        person.setExamList(examScoreList);
        return person;
    }

}

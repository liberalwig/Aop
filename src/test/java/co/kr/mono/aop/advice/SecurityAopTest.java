package co.kr.mono.aop.advice;

import co.kr.mono.aop.config.Config;
import co.kr.mono.aop.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
class SecurityAopTest {

    @Autowired
    private ApplicationContext context;
    private Person person;

    @BeforeEach
    public void setUp() {
        person = context.getBean(Person.class);
    }

    @Test
    @DisplayName("App-JavaConfig 정상실행: 클라이언트 person.print() 호출")
    public void aopNoParamTest() {
        System.out.println("\n### STEP 0 : 클라이언트 person.getTot() 호출");
        person.print();
    }

    @Test
    @DisplayName("App-JavaConfig 정상실행: 클라이언트 person.print(1) 호출")
    public void aopParamTest() {
        System.out.println("\n### STEP 0 : 클라이언트 person.getTot(1) 호출");
        Set<Map.Entry<String, Float>> entries = person.getTot("1").entrySet(); // 특정 학년(1)의 결과 받음. Set 안에 Map 만든 경우
        System.out.println("\n### 클라이언트 결과: " + entries);
        person.print();
    }

    @Test
    @DisplayName("AOP-JavaConfig 클라이언트 printThrowException() 호출")
    public void aopExceptionTest() {
        System.out.println("\n### STEP 0 : 클라이언트 printThrowException() 호출");
        person.printThrowException();
    }










}
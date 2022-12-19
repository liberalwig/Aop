package co.kr.mono.aop.advice;

import co.kr.mono.aop.util.UtilLib;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class SecurityAop {
    public void displayLine() {
        System.out.println(UtilLib.lpad("-", 50, "-"));
    }

    @Before("execution(public * co.kr.mono.aop.entity.Person.*(..))") // public + returnType 다 + 패키지 + 메소드 다 + 파라미터 0,1,2 이상
    public void logBefore(JoinPoint joinPoint) {

        String signatureStr = joinPoint.getSignature().toString();

        displayLine() ;
        System.out.println("### => 공통코드 실행중");
        System.out.println("### STEP1 : <aop:before> : 메서드 실행 전에 적용되는 어드바이스");
        System.out.println("### STEP1 : " + signatureStr + " 시작전");
        displayLine();
    }

    @Around("execution(public * co.kr.mono.aop.entity.Person.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable { // joinPoint 를 상속받은 메소드( = ProceedingJoinPoint) 가 보내는 권한 위임받아서 타겟을 호출
        String signatureStr = joinPoint.getSignature().toString();
        displayLine();
        System.out.println("### STEP2 : <aop:around> : 메서드 호출 이전, 이후, 예외 발생 등 모든 시점에 적용 가능한 어드바이스 정의");
        System.out.println("### STEP2 : " + signatureStr + " around 시작.");

        long timeMilli = new Date().getTime();

        try {
            // 핵심기능
            Object result =  joinPoint.proceed();
            // Object result = null;
            return result;
        } finally {

            System.out.println(String.format("실행시간 : %d ms",new Date().getTime() - timeMilli));
            System.out.println("### STEP2 : " + signatureStr + " around 종료.");
            displayLine();
        }
    }

    @AfterReturning(pointcut = "execution(public * co.kr.mono.aop.entity.Person.*(..))", returning = "retVal")
    public void logAfterReturning(JoinPoint joinPoint, Object retVal) {

        String signatureStr = joinPoint.getSignature().toString();
        displayLine();

        System.out.println("### STEP3 : " + "<aop:after-returning> : 메서드가 정상적으로 실행된 후에 " +
                "적용되는 어드바이스 정의");
        System.out.println("### STEP3 : " + signatureStr + "\n### : 실행 결과 [" + retVal+ "]");
        displayLine();
    }

    @AfterThrowing(pointcut = "execution(public * co.kr.mono.aop.entity.Person.*(..))", throwing = "ex") // 오류 났을 때 exception 정보를 @AfterThrowing 쪽에 넘김
    public void logAfterThrowing(JoinPoint joinPoint ,Exception ex) {

        String signatureStr = joinPoint.getSignature().toString();
        System.out.println("JOINPOINT : "+signatureStr);
        displayLine();

        System.out.println("### STEP4 : <aop:after-throwing> : 메서드가 예외를 발생시킬 때 " +
                "적용되는 어드바이스를 정의");
        System.out.println("### STEP4 : 예외발생  => " + ex.toString());
        displayLine();
    }

    @After("execution(public * co.kr.mono.aop.entity.Person.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String signatureStr = joinPoint.getSignature().toString();
        displayLine();

        System.out.println("### STEP5 : <aop:after> : 메서드가 정상적으로 실행되는지 " +
                "또는 에외를 발생시키는지 여부에 상관없이 실행하는어드바이스를 정의");
        System.out.println("### STEP5 : " + signatureStr + " 종료.");
        displayLine();
    }

}
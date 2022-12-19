package co.kr.mono.aop.entity;

import co.kr.mono.aop.ui.Printer;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString


public class Person {

    private String name;
    private String major;
    private ArrayList<ExamScore> examList;

    @Autowired
    private Printer printer;

    public void print(){
        String str = "Person [name=" + name
                + ", major = " +major +"]\n"
                +"ExamList = "+examList+"]";
        printer.print(str);
    }

    public Map<String, Float> getTot(){
        ArrayList<ExamScore> exams = this.getExamList();

        Map<String, Float> map = exams.stream()
                .collect(Collectors.toMap(exam->exam.getGrade()
                        , exam->(float)(exam.getKor() + exam.getEng() + exam.getMath())/3));
        return map;
    }

    public Map<String, Float> getTot(String grade){
        ArrayList<ExamScore> exams = this.getExamList();

        Map<String, Float> map = exams.stream().filter(exam -> exam.getGrade().equals(grade))
                .collect(Collectors.toMap(exam -> exam.getGrade()
                        ,exam -> (float)(exam.getKor() + exam.getMath() + exam.getEng())/3));

        return map;
    }

    public void printThrowException(){
        throw new IllegalArgumentException("=> 고의로 발생시켰음");
    }
}
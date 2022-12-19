package co.kr.mono.aop.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExamScore {

    private String grade;
    private int kor;
    private int eng;
    private int math;
}

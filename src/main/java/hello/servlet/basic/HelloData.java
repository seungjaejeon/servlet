package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //lombok 자동으로 게터세터
public class HelloData {
    private String username;
    private int age;
}

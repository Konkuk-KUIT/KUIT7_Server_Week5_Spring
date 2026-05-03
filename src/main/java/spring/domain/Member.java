package spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private static long sequence = 0;

    private Long id;
    private String name;

    public Member(String name) {
        this.id = ++sequence;
        this.name = name;
    }
}

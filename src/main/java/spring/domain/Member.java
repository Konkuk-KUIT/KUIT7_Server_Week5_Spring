package spring.domain;

import lombok.Getter;

@Getter
public class Member {

    private static long sequence = 0;

    private final Long id;
    private final String name;

    public Member(String name) {
        this.id = ++sequence;
        this.name = name;
    }
}

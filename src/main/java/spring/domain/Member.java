package spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }

}

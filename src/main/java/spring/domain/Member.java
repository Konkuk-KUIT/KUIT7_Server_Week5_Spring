package spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }
}
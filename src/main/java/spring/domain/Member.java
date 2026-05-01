package spring.domain;

public class Member {
    private static long sequence = 0;

    private Long id;
    private String name;

    public Member(String name) {
        this.id = ++sequence;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}

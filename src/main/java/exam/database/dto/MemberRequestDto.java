package exam.database.dto;

import exam.database.entity.Member;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String email;
    private String password;

    public Member toEntity(String email, String password) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        return member;
    }
}

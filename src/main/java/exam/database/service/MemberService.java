package exam.database.service;

import exam.database.dto.MemberRequestDto;
import exam.database.entity.Member;
import exam.database.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member find(MemberRequestDto memberRequestDto) {
        log.info("mReq email:{}", memberRequestDto.getEmail());
        Member findMember = memberRepository.findByEmail(memberRequestDto.getEmail()).orElseThrow(() -> {
                throw new NoSuchElementException("존재하지 않는 회원입니다.");
        });
        return validatePassword(memberRequestDto.getPassword(), findMember.getPassword()) ? findMember : null;
    }

    public boolean validatePassword(String inputPassword, String findMemberPassword) {
        return inputPassword.equals(findMemberPassword);
    }

}

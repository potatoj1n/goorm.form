package potatoni.goorm.form.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto signup(MemberDto memberDto) {
        // MemberEntity 생성
        MemberEntity member = new MemberEntity(null, memberDto.loginId(), memberDto.name(), memberDto.password());
        // 저장
        MemberEntity savedMember = memberRepository.save(member);
        // 변환하여 반환
        return convertToDto(savedMember);
    }

    public List<MemberDto> findAll() {
        return memberRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public MemberDto login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Invalid login credentials!"));
    }

    // MemberEntity를 MemberDto로 변환하는 헬퍼 메소드
    private MemberDto convertToDto(MemberEntity member) {
        return new MemberDto(member.getId(), member.getLoginId(), member.getName(), null);  // 비밀번호는 보안상 전달하지 않습니다.
    }
}

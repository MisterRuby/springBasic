package ruby.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service        // 해당 어노테이션이 붙은 클래스를 스프링 빈으로 등록. @Service 컴포넌트에 @Component가 포함되어 있다.
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired  // 생성자를 통해 의존관계 주입. 또는 생성자가 아닌 필드에 해당 어노테이션을 붙여 주입받을 수도 있다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

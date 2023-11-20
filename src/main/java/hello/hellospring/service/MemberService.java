package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        // Dependency injection (DI)
        this.memberRepository = memberRepository;
    }
    // Sign up Logic
    public Long join(Member member){
        // each member should have different name!
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // extract method ctrl+shift+alt+t
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Already exist member!");
                });
    }
    // search all members
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

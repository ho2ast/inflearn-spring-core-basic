package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙는 것의 생성자를 만들어 줌
public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

//  private MemberRepository memberRepository;
//  private DiscountPolicy discountPolicy; // final 생략 -> 수정자 주입 때문에

//  수정자
//  @Autowired
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    System.out.println("discountPolicy = " + discountPolicy);
//    this.discountPolicy = discountPolicy;
//  }
//  수정자
//  @Autowired
//  public void setMemberRepository(MemberRepository memberRepository) {
//    System.out.println("memberRepository = " + memberRepository);
//    this.memberRepository = memberRepository;
//  }

  @Autowired // 생성자가 1개일 경우는 생략 가능
  public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId); // 회원 정보 조회
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}

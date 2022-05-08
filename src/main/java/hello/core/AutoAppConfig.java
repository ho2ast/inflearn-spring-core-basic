package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class, // 해당 클래스가 등록되어 있는 패키지로 찾는다.
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
        // 기존의 AppConfig와 충돌 발생하지 않도 제외
        // 디폴트는 @ComponentScan가 붙은 클래스의 패키지 위치가 시작 위치
)
public class AutoAppConfig {
//  @Bean(name="memoryMemberRepository")
//  MemberRepository memberRepository () {
//    return new MemoryMemberRepository();
//  }
}

package com.wani.articletddturorial.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wani.articletddturorial.modules.member.domain.Member;
import com.wani.articletddturorial.modules.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Transactional
public abstract class IntegrationTest {

    protected static final String AUTHORIZATION = "Authorization";

    @Autowired protected ObjectMapper objectMapper;
    @Autowired protected MockMvc mockMvc;
    @Autowired protected MemberRepository memberRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private TokenFactory tokenFactory;
    protected String setUpToken;
    protected Member setUpMember;

    @BeforeEach
    protected void setUp(){
        setUpMember = memberRepository.save(
            Member.register()
        )
    }

}

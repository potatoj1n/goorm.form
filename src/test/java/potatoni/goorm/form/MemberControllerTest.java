package potatoni.goorm.form;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import potatoni.goorm.form.member.MemberController;
import potatoni.goorm.form.member.MemberDto;
import potatoni.goorm.form.member.MemberService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void testLogin() throws Exception {
        // 로그인 데이터 준비
        String jsonLoginRequest = "{\"loginId\":\"kim\",\"password\":\"1234\"}";

        // 서비스 메서드를 모의로 설정
        MemberDto mockMemberDto = new MemberDto(1L, "kim", "kim", "1234");
        given(memberService.login("kim", "1234")).willReturn(mockMemberDto);

        // 로그인 요청을 테스트
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLoginRequest))
                .andExpect(status().isOk());
    }
}

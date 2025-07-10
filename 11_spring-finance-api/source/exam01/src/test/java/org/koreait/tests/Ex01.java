package org.koreait.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.koreait.member.controllers.RequestJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Ex01 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Test
    void test1() throws Exception {
        RequestJoin form = new RequestJoin();
        form.setEmail("koyounghee@test.org");
//        form.setPassword("1234");
//        form.setName("고영희");

        String json = om.writeValueAsString(form);
        System.out.println(json);

        /**
         * import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
         * import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
         * import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
         */

        mockMvc.perform(post("/api/v1/member/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print());

    }
}

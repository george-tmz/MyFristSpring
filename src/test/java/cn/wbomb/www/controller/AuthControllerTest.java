package cn.wbomb.www.controller;

import cn.wbomb.www.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    private MockMvc mvc;
    @Mock
    private UserService userService;
    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(new AuthController(userService, authenticationManager))
                .build();
    }

    @Test
    void returnNotLoginByDefault() throws Exception {
        mvc.perform(get("/auth")).andExpect(status().isOk())
                .andExpect(mvcResult -> Assertions.assertTrue(mvcResult.getResponse().getContentAsString().contains("ok")));
    }
}
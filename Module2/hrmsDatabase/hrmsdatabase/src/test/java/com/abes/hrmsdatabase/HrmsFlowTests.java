package com.abes.hrmsdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:hrmsflow;DB_CLOSE_DELAY=-1")
@AutoConfigureMockMvc
class HrmsFlowTests {
    @Autowired MockMvc mvc;

    @Test void registerLoginAndAttendanceAreScopedToSession() throws Exception {
        mvc.perform(get("/v1/user/attendance")).andExpect(status().isUnauthorized());
        String registration = """
            {"emp_id":1001,"emp_name":"Test User","email":"test@example.com","password":"password123","designation":"Developer","stack":"Java"}
            """;
        mvc.perform(post("/v1/user/register").contentType(MediaType.APPLICATION_JSON).content(registration))
            .andExpect(status().isOk()).andExpect(jsonPath("$.emp_id").value(1001))
            .andExpect(jsonPath("$.password").doesNotExist());
        mvc.perform(post("/v1/user/register").contentType(MediaType.APPLICATION_JSON).content(registration))
            .andExpect(status().isConflict());
        mvc.perform(post("/v1/user/login").contentType(MediaType.APPLICATION_JSON)
            .content("{\"emp_id\":1001,\"password\":\"wrong\"}"))
            .andExpect(status().isUnauthorized());
        MockHttpSession session = (MockHttpSession) mvc.perform(post("/v1/user/login").contentType(MediaType.APPLICATION_JSON)
            .content("{\"emp_id\":1001,\"password\":\"password123\"}"))
            .andExpect(status().isOk()).andReturn().getRequest().getSession();
        mvc.perform(get("/v1/user/me").session(session)).andExpect(status().isOk()).andExpect(jsonPath("$.emp_id").value(1001));
        mvc.perform(post("/v1/user/attendance/mark").session(session)).andExpect(status().isOk())
            .andExpect(jsonPath("$.inTime").exists());
        mvc.perform(post("/v1/user/attendance/mark").session(session)).andExpect(status().isConflict());
        mvc.perform(post("/v1/user/attendance/checkout").session(session)).andExpect(status().isOk())
            .andExpect(jsonPath("$.outTime").exists());
        mvc.perform(get("/v1/user/attendance").session(session)).andExpect(status().isOk())
            .andExpect(jsonPath("$[0].attendanceId").exists());
        mvc.perform(post("/v1/user/logout").session(session)).andExpect(status().isOk());
        mvc.perform(get("/v1/user/me")).andExpect(status().isUnauthorized());
    }
}

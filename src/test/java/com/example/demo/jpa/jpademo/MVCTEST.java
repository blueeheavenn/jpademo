package com.example.demo.jpa.jpademo;

import com.example.demo.jpa.jpademo.controller.ControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@WebMvcTest( ControllerTest.class)
public class MVCTEST {

    @Autowired
    MockMvc mockMvc;

//    @MockBean
//    TestEntityManager em;





    @Test
    public void test() throws Exception {
        //given(em.pe)
        //RequestBuilder rb= servletContext -> servletContext.set
      mockMvc.perform(
                MockMvcRequestBuilders.get("/urls")
               .contentType("application/json"))
             .andExpect(status().isOk());





                //.andReturn();
        //.(MediaType.APPLICATION_JSON_VALUE)).andReturn();
                //.andExpect(status().isOk());
    }

}

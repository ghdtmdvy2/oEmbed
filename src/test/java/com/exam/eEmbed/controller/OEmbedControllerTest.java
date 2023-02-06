package com.exam.eEmbed.controller;

import com.exam.eEmbed.OEmbedTaskApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = OEmbedTaskApplication.class)
@AutoConfigureMockMvc
class OEmbedControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showSearch() throws Exception {
        ResultActions resultActions = mockMvc.
                perform(get("/oEmbed/search"))
                .andDo(print());
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(handler().handlerType(OEmbedController.class))
                .andExpect(handler().methodName("showSearch"));
    }
    @Test
    public void search() throws Exception {
        ResultActions resultActions = mockMvc.
                perform(post("/oEmbed/search")
                        .param("url","https://www.youtube.com/watch?v=dBD54EZIrZo"))
                .andDo(print());
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(handler().handlerType(OEmbedController.class))
                .andExpect(handler().methodName("search"));
    }
}
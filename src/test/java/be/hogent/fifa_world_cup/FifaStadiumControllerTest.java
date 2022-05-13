package be.hogent.fifa_world_cup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class FifaStadiumControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/fifa"))
                .andExpect(status().isOk())
                .andExpect(view().name("fifaStadiumForm"))
                .andExpect(model().attributeExists("stadiumList"))
                .andExpect(model().attributeExists("stadiumSelection"));
    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(post("/fifa"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/fifa/1")).andExpect(status().isOk());

    }

    @Test
    public void testPostById() throws Exception {
        mockMvc.perform(post("/fifa/1")).andExpect(status().isOk());

    }
}

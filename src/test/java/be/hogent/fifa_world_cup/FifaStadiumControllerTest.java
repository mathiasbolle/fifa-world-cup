package be.hogent.fifa_world_cup;

import domain.WedstrijdTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import service.JpaStadionDao;
import service.JpaWedstrijdTicketDao;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class FifaStadiumControllerTest {

    @Mock
    private JpaStadionDao stadionDao;

    @Mock
    private JpaWedstrijdTicketDao wedstrijdTicketDao;

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
                .andExpect(view().name("fifaStadiumForm")) .andExpect(model().attributeExists("stadiumList"))
                .andExpect(model().attributeExists("stadiumSelection"))
                .andExpect(model().attribute("stadiumList", hasSize(2)));
    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(post("/fifa"))
                .andExpect(status().isOk())
                .andExpect(view().name("fifaStadiumResult"));
                //.andExpect(model().attributeExists("stadiumName"));


    }

    @Test
    public void testGetById() throws Exception {
        Mockito.when(stadionDao.stadionNameByMatchId(1)).thenReturn("Al Bayt Stadium");
        WedstrijdTicket x = Mockito.mock(WedstrijdTicket.class);
        Mockito.when(wedstrijdTicketDao.getTicketsOfWedstrijdById(1)).thenReturn(x);
        //Mockito.when(wedstrijdTicketDao.getTicketsOfWedstrijdById(1).getWedstrijd()).thenReturn();

        mockMvc.perform(get("/fifa/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("fifaStadiumResult"))
                .andExpect(model().attributeExists("stadiumName"))
                .andExpect(model().attributeExists("match_title"))
                .andExpect(model().attributeExists("available_tickets"))
                .andExpect(model().attributeExists("purchase"))
                .andExpect(model().attribute("stadiumName", stadionDao.stadionNameByMatchId(1)));
                //.andExpect(model().attributeExists("match_title", wedstrijdTicketDao.getTicketsOfWedstrijdById(1).getWedstrijd().toString()));
                //.andExpect(model().attribute("purchase", ))
    }

    @Test
    public void testPostById() throws Exception {
        mockMvc.perform(post("/fifa/1")).andExpect(status().isOk())
                .andExpect(view().name("fifaStadiumResult"))
                .andExpect(forwardedUrl("/views/fifaStadiumResult.jsp"));
                //.andExpect(model().attributeExists("stadiumList"));
                //.andExpect(model().attribute("stadiumList", hasSize(2)));

    }
}

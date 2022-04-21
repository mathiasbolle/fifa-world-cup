package domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class Wedstrijd {
    private String id; //unieke sleutel

    private String[] landen; //2 landen van de wedstrijd

    private Date datum;
    private int dag; //dag van de wedstrijd

    private int uur; //uur van de wedstrijd

    public Wedstrijd() {
    }

    public Wedstrijd(String id, String[] landen, int dag, int maand, int uur) {
        this.id = id;
        this.landen = landen;
        this.datum = new GregorianCalendar(2022, maand, dag).getTime();
        this.uur = uur;
    }

    public String getId() {
        return id;
    }

    public String[] getLanden() {
        return landen;
    }

    public Date getDatum() {
        return datum;
    }

    public int getUur() {
        return this.uur;
    }

    @Override
    public String toString()
    {
        return String.format("%s vs %s op %d-11", landen[0], landen[1], null);
    }
}

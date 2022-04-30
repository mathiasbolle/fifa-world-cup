package domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Wedstrijd {
    private String id; //unieke sleutel

    private String[] landen; //2 landen van de wedstrijd

    private Date datum;
    private int dag; //dag van de wedstrijd

    private int uur; //uur van de wedstrijd
    private Calendar cal;

    public Wedstrijd() {
    }

    public Wedstrijd(String id, String[] landen, int dag, int maand, int uur) {
        this.id = id;
        this.landen = landen;
        this.datum = new GregorianCalendar(2022, maand, dag).getTime();
        this.uur = uur;
        cal = Calendar.getInstance();
        cal.setTime(datum);
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
        return String.format("%s vs %s op %d-%d", landen[0], landen[1], cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH));
    }
}

package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stadions")
@NamedQueries({
        @NamedQuery(name = "Stadion.stadionNameByMatchId", query="select s From Stadion s JOIN s.wedstrijden w WHERE w.id = :id")
})
public class Stadion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "s")
    private Set<Wedstrijd> wedstrijden = new HashSet<>();

    public void addWedstrijd(Wedstrijd wedstrijd) {
        wedstrijden.add(wedstrijd);
    }


    protected Stadion() {

    }

    public Stadion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

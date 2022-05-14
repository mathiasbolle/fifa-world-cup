package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stadions")
public class Stadion {

    @Id
    private int id;

    private String name;

    /*
    @OneToMany(mappedBy = "w")
    private List<Wedstrijd> wedstrijden;

     */

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

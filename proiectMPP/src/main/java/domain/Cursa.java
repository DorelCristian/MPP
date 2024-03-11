package domain;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Cursa extends Entity<Long>{
    private String destinatie;
    private Date date;
    private Time ora;
    private int locuriDisponibile;

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public Cursa(String destinatie, Date date, Time ora, int locuriDisponibile)
    {
        this.destinatie=destinatie;
        this.date=date;
        this.ora=ora;
        this.locuriDisponibile=locuriDisponibile;
    }

    public Time getOra() {
        return ora;
    }

    public void setOra(Time ora) {
        this.ora = ora;
    }

    public Date getDate() {
        return date;
    }

    public int getLocuriDisponibile() {
        return locuriDisponibile;
    }

    public void setLocuriDisponibile(int locuriDisponibile) {
        this.locuriDisponibile = locuriDisponibile;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cursa cursa = (Cursa) o;
        return locuriDisponibile == cursa.locuriDisponibile && Objects.equals(destinatie, cursa.destinatie) && Objects.equals(date, cursa.date) && Objects.equals(ora, cursa.ora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), destinatie, date, ora, locuriDisponibile);
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "destinatie='" + destinatie + '\'' +
                ", date=" + date +
                ", ora=" + ora +
                ", locuriDisponibile=" + locuriDisponibile +
                '}';
    }
}

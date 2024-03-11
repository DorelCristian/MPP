package domain;

import java.util.Objects;

public class Rezervare extends Entity<Long>{
    private int idClient;
    private int idCursa;
    private int Locuri;

    public Rezervare(int idClient,int idCursa,int Locuri)
    {
        this.idClient=idClient;
        this.idCursa=idCursa;
        this.Locuri=Locuri;
    }

    public int getLocuri() {
        return Locuri;
    }

    public void setLocuri(int locuri) {
        Locuri = locuri;
    }

    public int getIdCursa() {
        return idCursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rezervare rezervare = (Rezervare) o;
        return idClient == rezervare.idClient && idCursa == rezervare.idCursa && Locuri == rezervare.Locuri;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "idClient=" + idClient +
                ", idCursa=" + idCursa +
                ", Locuri=" + Locuri +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idClient, idCursa, Locuri);
    }

    public void setIdCursa(int idCursa) {
        this.idCursa = idCursa;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}

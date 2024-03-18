package domain;

import java.util.Objects;

public class Rezervare extends Entity<Long>{
   // private int idClient;
    Client client;
    Cursa cursa;
    //private int idCursa;
    private int locuri;

    /*public Rezervare(int idClient,int idCursa,int Locuri)
    {
        this.idClient=idClient;
        this.idCursa=idCursa;
        this.Locuri=Locuri;
    }*/
    public Rezervare(int locuri,Client client,Cursa cursa)
    {
        this.locuri=locuri;
        this.client=client;
        this.cursa=cursa;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        locuri = locuri;
    }

    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rezervare rezervare = (Rezervare) o;
        return locuri == rezervare.locuri && Objects.equals(client, rezervare.client) && Objects.equals(cursa, rezervare.cursa);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "client=" + client +
                ", cursa=" + cursa +
                ", Locuri=" + locuri +
                '}';
    }
}

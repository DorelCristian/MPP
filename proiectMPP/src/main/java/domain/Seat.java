package domain;

import java.util.Objects;

public class Seat extends Entity<Long>{
    private int idRezervare;
    private int seatNumber;
    public Seat(int idRezervare,int seatNumber)
    {
        this.idRezervare=idRezervare;
        this.seatNumber=seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getIdRezervare() {
        return idRezervare;
    }

    public void setIdRezervare(int idRezervare) {
        this.idRezervare = idRezervare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Seat seat = (Seat) o;
        return idRezervare == seat.idRezervare && seatNumber == seat.seatNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idRezervare, seatNumber);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "idRezervare=" + idRezervare +
                ", seatNumber=" + seatNumber +
                '}';
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proiectMPP.src.main.java.domain
{
    internal class Seat:Entity<long>
    {
        public long idRezervare { get; set; }
        public long seatNumber { get; set; }

        public Seat(long idRezervare,long seatNumber)
        {
            this.idRezervare = idRezervare;
            this.seatNumber = seatNumber;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proiectMPP.src.main.java.domain
{
    internal class Rezervare:Entity<long>
    {
        public long idClient { get; set; }
        public long idCursa { get; set; }
        public long locuri { get; set; }
       

        public Rezervare(long idClient, long idCursa, long locuri)
        {
            this.idClient = idClient;
            this.idCursa = idCursa;
            this.locuri = locuri;
        }
    }
}

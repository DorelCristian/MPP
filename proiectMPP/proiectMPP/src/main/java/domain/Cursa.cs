using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proiectMPP.src.main.java.domain
{
    internal class Cursa:Entity<long>
    {
        public string destinatie { get; set; }
        public DateTime data { get; set; }
        public TimeSpan time { get; set; }
        public long locuri { get; set; }

        public Cursa(string destinatie,DateTime data, TimeSpan time,long locuri)
        {
            this.destinatie = destinatie;
            this.data = data;
            this.time = time;
            this.locuri = locuri;
        }
    }
}

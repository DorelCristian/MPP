using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proiectMPP.src.main.java.domain
{
    internal class User:Entity<long>
    {
        public long username { get; set; }
        public string password { get; set; }

        public User(long username,string password)
        {
            this.username = username;
            this.password = password;
        }
    }
}

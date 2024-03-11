using proiectMPP.src.main.java.domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proiectMPP.src.main.java.repo
{
    internal interface IRepository<Id,E> where E:Entity<Id>
    {
        IEnumerable<E> FindAll();
        E FindOne(Id id);
        E Save(E entity);
        E Delete(Id id);
        E Update(Id id);

    }
}
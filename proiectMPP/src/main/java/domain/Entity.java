package domain;
import java.io.Serializable;
import java.util.Objects;
public class Entity<Long>implements Serializable {
    protected Long id;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=(Long)id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity<?> entity)) return false;
        return getId().equals(entity.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}

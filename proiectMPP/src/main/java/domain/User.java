package domain;

public class User extends Entity<Long>{
    private String username;
    private String password;
    public User(String username,String password)
    {
        this.username=username;
        this.password=password;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    @Override
    public String toString(){
        return "User{"+
                "username="+'\''+username+'\''+
                ",password="+'\''+password+'\'';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return this.getId().equals(that.getId()) && this.username.equals(that.username) && this.password.equals(that.password);
    }
}

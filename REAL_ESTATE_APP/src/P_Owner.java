
public class P_Owner {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int ID)
    {
        this.id=ID;
    }
    public String getFname()
    {
        return this.firstName;
    }
    public void setFname(String FNAME)
    {
        this.firstName=FNAME;
    }
    
     public String getLname()
    {
        return this.lastName;
    }
    public void setLname(String LNAME)
    {
        this.lastName=LNAME;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public void setPhone(String PHONE)
    {
        this.phone=PHONE;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String EMAIL)
    {
        this.email=EMAIL;
    }
     public String getAddress()
    {
        return this.address;
    }
    public void setAddress(String ADDRESS)
    {
        this.address=ADDRESS;
    }
    //db work
}

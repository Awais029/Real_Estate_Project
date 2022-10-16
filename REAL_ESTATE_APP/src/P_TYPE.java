
import java.sql.PreparedStatement;


public class P_TYPE {
    private int id;
    private String name;
    private String description;
    
    //getter and setter
    
    public Integer getid()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String NAME)
    {
        this.name=NAME;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String DESCRIPTION)
    {
        this.description=DESCRIPTION;
    }
    
    //create the class constructor
    
    public P_TYPE(){}
    public P_TYPE(Integer ID, String NAME, String DESCRIPTION)
    {
        this.id=ID;
        this.name=NAME;
        this.description=DESCRIPTION;
    }
    
    //create a function to insert -edit -remove type
    public boolean execTypeQuery(String queryType, P_TYPE type)
    {
        PreparedStatement ps;
      
        //add new type
        if(queryType.equals("add"))
        {
            //database work 
        }
        return true;
    }
}


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class P_TYPE {
    private int id;
    private String name;
    private String description;
    
    //getter and setter
    
    public Integer getid()
    {
        return id;
    }
    public void setId(Integer ID){
        this.id=ID;
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
            try {
                //query insert into property type for name description
                ps=THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO property_type(name, description) VALUES (?,?)");
                ps.setString(1, type.getName());
                ps.setString(2, type.getDescription());
                
                return(ps.executeUpdate() > 0);
                   
            } catch (SQLException ex) {
                System.out.println("Exception"+ex);
                return false;
            }      
        }
        //add new type
        else if(queryType.equals("edit"))
        {
            try {
                //query UPDATE `property_type` SET `name`=?,`description`=? WHERE `id`=?
                ps=THE_CONNECTION.getTheConnection().prepareStatement("UPDATE property_type SET name=?, description=? WHERE id=?");
                ps.setString(1, type.getName());
                ps.setString(2, type.getDescription());
                ps.setInt(3, type.getid());
                return(ps.executeUpdate() > 0);
                   
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
         //add new type
        else if(queryType.equals("remove"))
        {
            try {
                //query --> DELETE FROM `property_type` WHERE `id`
                ps=THE_CONNECTION.getTheConnection().prepareStatement("DELETE FROM property_type WHERE id=?");
                ps.setInt(1, type.getid());
                return(ps.executeUpdate() > 0);
                   
            } catch (SQLException ex) {
                Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter the Correct Query(add, edit, remove)", "Invalid Operation", 2);
            return false;
        }
        
        }
    
    public HashMap<String, Integer> getTypesMap()
    {
        HashMap<String, Integer> map=new HashMap<>();
        Statement st;
        ResultSet rs;
        try {
            st=THE_CONNECTION.getTheConnection().createStatement();
            rs=st.executeQuery("SELECT * FROM property_type");
              P_TYPE type;
          while(rs.next())
            {
                type=new P_TYPE(rs.getInt(1), rs.getString(2), rs.getString(3));
                map.put(type.getName(), type.getid());
            }  
        } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;   
    }
    //create a function to get a type data by id
    public P_TYPE getTypeById(Integer id){
        PreparedStatement ps;
        ResultSet rs;
        P_TYPE type=new P_TYPE();
        try {
            ps=THE_CONNECTION.getTheConnection().prepareStatement("SELECT * FROM property_type WHERE id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();   
            if(rs.next()){
                type.setId(id);
                type.setName(rs.getString(2));
                type.setDescription(rs.getString(3));
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    }


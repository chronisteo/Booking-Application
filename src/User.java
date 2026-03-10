import java.io.Serializable;

/**
 * class that represents a user(provider,customer,admin)
 */

public class User implements Serializable {
    private String username;
    private String password;
    private String full_name;

    /**
     * constructor that gets as parameters username,password,FullName
     * @param username user's username
     * @param password user's password
     * @param full_name user's FullName
     */

    public User(String username, String password, String full_name){
        this.username=username;
        this.full_name=full_name;
        this.password=password;
    }

    /**
     * this method sets user's username
     * @param username user's username
     */

    public void setUsername(String username){
        this.username=username;
    }

    /**
     * this method sets user's fullName
     * @param full_name user's fullName
     */

    public void setFull_name(String full_name){
        this.full_name=full_name;
    }

    /**
     * this method sets user's password
     * @param password user's password

     */
    public void setPassword(String password){
        this.password=password;
    }

    /**
     * @return user's username
     */

    public String getUsername(){
        return  username;
    }

    /**
     * @return  user's FullName
     */

    public String getFull_name(){
        return  full_name;
    }

    /**
     * @return user's password
     */
    public String getPassword(){
        return password;
    }


}

package pl.edu.pwr.ztw.books.models;

public class Author {


    private int Id;
    private String Name;
    private String LastName;

    public Author(int id,String name, String lastName) {
        Id = id;
        Name = name;
        LastName = lastName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

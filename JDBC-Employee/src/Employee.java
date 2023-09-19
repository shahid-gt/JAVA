public class Employee {
    private int id;
    private String name;
    private String designation;

    public Employee() {
    }

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public Employee(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String toString() {
        return "Employee ID = " + this.id + "\nEmployee Name = " + this.name + "\nEmployee designation = " + this.designation;
    }
}

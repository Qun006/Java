public class Teacher extends Person implements Payable{
    private String department;
    private double baseSalary; // Lương cứng
    private int teachingHours;// Giờ giảng dạy

    public Teacher(String surname, String name, int age, String email, String department, double baseSalary, int teachingHours) {
        super(surname, name, age, email);
        this.department = department;
        this.baseSalary = baseSalary;
        this.teachingHours = teachingHours;
    }

    public Teacher() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    @Override
    public String getInfo() {
        return "Teacher: " + getId() + " | Full Name: " + getSurname() + " " + getName() + " | Dept: " + getDepartment() + " | Salary: " + calculateSalary() + " VND";
    }

    @Override
    public double calculateSalary() {
        return baseSalary+(teachingHours*200000);
    }
}

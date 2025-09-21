public class Student extends Person{
    private String major; //Ngành học
    private double gpa=-1.0;

    public Student(String surname, String name, int age, String email, String major) {
        super(surname, name, age, email);
        this.major = major;
    }

    public Student() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getGrade(){
        if(gpa>=8.0){
            return "A";
        }
        else if(gpa>=6.5 && gpa<8.0){
            return "B";
        }
        else if(gpa<6.5 && gpa>=5.0){
            return "C";
        }
        else if(gpa>=3.0 && gpa<5.0){
            return "D";
        }
        else{
            return "F";
        }
    }
    @Override
    public String getInfo() {
        return "\n Student: " + getId() + " | Full Name: " + getSurname() + " " + getName() + " | Major: " + getMajor() + " | GPA: " + getGpa() + " | Grade: " + getGrade();
    }
}

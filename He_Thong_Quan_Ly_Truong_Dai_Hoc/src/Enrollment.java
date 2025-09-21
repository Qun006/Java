public class Enrollment {
    private Student student = new Student();//Sinh viên đăng kí
    private Course course;//Môn học đăng kí
    private double score = -1.0;//Điểm cuối kỳ (mặt định -1 nếu chưa có)

    public Enrollment(Student student, Course course, double score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public Enrollment() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    //kiểm tra có điểm cuối kỳ không
    public boolean hasScore(){
        if(score>=0){
            return true;
        }
        else {
            return false;
        }
    }
    public String getEnrollmentInfo(){
        return "Enrollment: " + student.getSurname() + " " + student.getName() + " - " + course.getCourseName() + " - Score: " + getScore();
    }
}

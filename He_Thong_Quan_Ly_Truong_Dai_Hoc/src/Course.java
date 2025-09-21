public class Course {
    private int courseId;//Mã Môn
    private static int autoId=1;
    private String courseName;//Tên môn
    private int credit;//Số tín chỉ

    public Course( String courseName, int credit) {
        this.courseId = autoId++;
        this.courseName = courseName;
        this.credit = credit;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getCourseInfo(){
        return "Course: " + getCourseId() + " | Name: " + getCourseName() + " | Credit: " + getCredit();
    }
}

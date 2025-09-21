import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements Manageable<Student> {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentManager() {
    }

    @Override
    public void add(Student item) {
        students.add(item);
    }

    @Override
    public boolean removeById(int id) {
        for(Student st : students){
            if(st.getId()==id){
                students.removeIf(student -> student.getId()==id);
//                for(Enrollment e : enrollments){
//                    if(e.getStudent().getId()==id){
                        enrollments.removeIf(enrollment -> enrollment.getStudent().getId()==id);
//                    }
//                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        for(Student st : students){
            if(st.getId()== id){
                return st;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        for(Student st : students){
            if(st.getName().equalsIgnoreCase(name)){
                studentList.add(st);
            }
        }
        return studentList;
    }

    @Override
    public void sortByName() {
        if(students.isEmpty()){
            System.out.print("\n Danh sách trống!");
        }
        else {
            students.sort(Comparator.comparing(Student::getName));
        }
    }

    @Override
    public void displayAll() {
        if(students.isEmpty()){
            System.out.print("\n Danh sách trống!");
        }
        else {
            for (Student st : students) {
                st.getInfo();
            }
        }
    }
    public void enrollStudent(int studentId, int courseId){
        //Kiểm tra xem studentId có tồn tại hay không
        Student student = findById(studentId);
        if(student==null){
            throw new IllegalArgumentException("Không tìm thấy id của sinh viên!");
        }
        //Kiểm tra xem courseId có tồn tại hay không
        Course course = null;
        for(Course c : courses) {
            if(c.getCourseId()==courseId) {
                course = c;
                return;
            }
        }
        if(course==null) {
            throw new IllegalArgumentException("\n Không tìm thấy id của môn học!");
        }
        //Kiểm tra xem Student đã đang kí môn này chưa
        for(Enrollment e : enrollments){
            if(e.getStudent().getId() == studentId && e.getCourse().getCourseId() == courseId){
                throw new RuntimeException("\n Sinh viên đã đăng kí môn này rồi!");
            }
        }

        //Nếu chưa đăng kí -> thm mới Enrollment
        enrollments.add(new Enrollment(student,course,-1));//-1 nghĩa là chưa có điểm
        System.out.print("Sinh viên: " + student.getSurname() + " " + student.getName() + " đã đăng kí môn " + course.getCourseName() + " thành công");
    }
    public void setScore(int studentId, int courseID, double score){
        Scanner sc = new Scanner(System.in);
        //Kiểm tra xem sinh viên đã đăng kí môn học này chx
        Enrollment enrollment = null;
        for(Enrollment e : enrollments){
            if(e.getStudent().getId()==studentId && e.getCourse().getCourseId()==courseID){
                enrollment=e;
            }
        }
        if (enrollment==null){
            throw new IllegalArgumentException("\n Sinh viên chưa đăng kí môn học này!");
        }
        if(score<0 || score>10){
            throw new IllegalArgumentException("\n Điểm bạn nhập không hợp lệ!");
        }
        else {
            //Add điểm vào
            for (Enrollment e : enrollments) {
                if (e.getStudent().getId() == studentId && e.getCourse().getCourseId() == courseID) {
                    e.setScore(score);
                    System.out.print("\n Đã thêm điểm thành công!");
                    break;
                }
            }
        }
    }
    public void printTranscript(int studentId){
        Student student = null;
        for(Student st : students){
            if(st.getId()==studentId){
                student=st;
            }
        }
        if(student!=null) {
            int count = 0;
            double total = 0;
            for (Enrollment e : enrollments) {
                if (e.getStudent().getId() == studentId && e.getScore() > 0 || e.getScore() < 10) {
                    e.getEnrollmentInfo();
                    count++;
                    total += e.getScore();
                }
            }
            System.out.print("GPA: " + (total / count));
        }
        else{
            throw new IllegalArgumentException("\n Không có id của sinh viên như trên!");
        }
    }
    public Student findTopStudent(){

        for(Student st: students){
            int count =0;
            double total=0;
            for(Enrollment e : enrollments){
                if(e.getStudent().getId()==st.getId()){
                    total+=e.getScore();
                    count++;
                }
            }
            st.setGpa(total/count);
        }
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        return students.get(0);
    }
    public void sortStudentByGPADesc(){
        for(Student st: students){
            int count =0;
            double total=0;
            for(Enrollment e : enrollments){
                if(e.getStudent().getId()==st.getId()){
                    total+=e.getScore();
                    count++;
                }
            }
            st.setGpa(total/count);
        }
        students.sort(Comparator.comparingDouble(Student::getGpa).reversed());
    }
}

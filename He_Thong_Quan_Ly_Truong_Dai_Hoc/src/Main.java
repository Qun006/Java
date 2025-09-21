import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        StudentManager studentManager = new StudentManager(students);
        TeacherManager teacherManager = new TeacherManager(teachers);
        CourseManagere courseManagere = new CourseManagere(courses);
        int count;
        do {
            System.out.print("\n   ==== University Mangament ====");
            System.out.print("\n 1.Quản lý sinh viên.");
            System.out.print("\n 2.Quản lý giảng viên.");
            System.out.print("\n 3.Quản lý môn học.");
            System.out.print("\n 4.Đăng ký môn học cho sinh viên.");
            System.out.print("\n 5.Nhập điểm cho sinh viên.");
            System.out.print("\n 6.In bảng điểm cho sinh viên.");
            System.out.print("\n 7.Tính lương giảng viên.");
            System.out.print("\n 8.Thống kê (Top Student, Sort GPA, Sort Salary)");
            System.out.print("\n 9.Xóa theo ID.");
            System.out.print("\n 0.Thoát chương trình.");
            System.out.print("\n Bạn muốn chọn chức năng nào: ");
            count = sc.nextInt(); sc.nextLine();
            if(count<0 || count>9){
                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
            }
            else{
                switch (count){
                    case 0:
                        break;
                    case 1:
                        int countStudent;
                        do {
                            System.out.print("\n   ==== Quản Lý Sinh Viên ====");
                            System.out.print("\n 1.Thêm sinh viên.");
                            System.out.print("\n 2.Tìm kiếm theo Id.");
                            System.out.print("\n 3.Tìm kiếm theo tên.");
                            System.out.print("\n 4.Sắp xếp theo tên");
                            System.out.print("\n 5.In danh sách tất cả các sinh viên.");
                            System.out.print("\n 0.Quai lại.");
                            System.out.print("\n Bạn muốn chọn chức năng nào: ");
                            countStudent = sc.nextInt(); sc.nextLine();
                            if(countStudent>5 || countStudent<0){
                                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
                            }
                            else{
                                switch (countStudent){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.print("\n Nhập Họ: ");
                                        String surname = sc.nextLine();
                                        System.out.print("\n Nhập tên: ");
                                        String name = sc.nextLine();
                                        System.out.print("\n Nhập tuổi: ");
                                        int age = sc.nextInt(); sc.nextLine();
                                        System.out.print("\n Nhập email: ");
                                        String email = sc.nextLine();
                                        System.out.print("\n Nhập ngành học: ");
                                        String major = sc.nextLine();
                                        Student student = new Student(surname, name, age, email, major);
                                        studentManager.add(student);
                                        System.out.print("\n Đã thêm sinh viên thành công!");
                                        break;
                                    case 2:
                                        System.out.print("\n Nhập Id muốn tìm: ");
                                        int id = sc.nextInt(); sc.nextLine();
                                        if(studentManager.findById(id)!=null){
                                            studentManager.findById(id);
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy sinh viên có Id như trên!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("\n Nhập tên muốn tìm: ");
                                        name = sc.nextLine();
                                        if(studentManager.findByName(name).isEmpty()){
                                            System.out.print("\n Không tìm thấy ai có tên " + name);
                                        }
                                        else{
                                            studentManager.findByName(name);
                                        }
                                        break;
                                    case 4:
                                        studentManager.sortByName();
                                        System.out.print("\n Đã sắp xếp thành công!");
                                        break;
                                    case 5:
                                        studentManager.displayAll();
                                        System.out.print("\n Đã in danh sách!");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        while(countStudent!=0);
                    case 2:
                        int countTeacher;
                        do {
                            System.out.print("\n   ==== Quản Lý Giảng Viên ====");
                            System.out.print("\n 1.Thêm sinh viên.");
                            System.out.print("\n 2.Tìm kiếm theo Id.");
                            System.out.print("\n 3.Tìm kiếm theo tên.");
                            System.out.print("\n 4.Sắp xếp theo tên");
                            System.out.print("\n 5.In danh sách tất cả các Giảng Viên.");
                            System.out.print("\n 0.Quai lại.");
                            System.out.print("\n Bạn muốn chọn chức năng nào: ");
                            countTeacher = sc.nextInt(); sc.nextLine();
                            if(countTeacher>5 || countTeacher<0){
                                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
                            }
                            else{
                                switch (countTeacher){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.print("\n Nhập Họ: ");
                                        String surname = sc.nextLine();
                                        System.out.print("\n Nhập tên: ");
                                        String name = sc.nextLine();
                                        System.out.print("\n Nhập tuổi: ");
                                        int age = sc.nextInt(); sc.nextLine();
                                        System.out.print("\n Nhập email: ");
                                        String email = sc.nextLine();
                                        System.out.print("\n Nhập phòng làm việc: ");
                                        String department = sc.nextLine();
                                        System.out.print("\n Nhập lương cơ bản: ");
                                        double baseSalary = sc.nextDouble(); sc.nextLine();
                                        System.out.print("\n Nhập giờ làm việc: ");
                                        int teachingHours = sc.nextInt(); sc.nextLine();
                                        Teacher teacher = new Teacher(surname, name, age, email, department, baseSalary, teachingHours);
                                        teacherManager.add(teacher);
                                        System.out.print("\n Đã thêm giảng viên thành công!");
                                        break;
                                    case 2:
                                        System.out.print("\n Nhập Id muốn tìm: ");
                                        int id = sc.nextInt(); sc.nextLine();
                                        if(teacherManager.findById(id)!=null){
                                            teacherManager.findById(id);
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy giảng viên có Id như trên!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("\n Nhập tên muốn tìm: ");
                                        name = sc.nextLine();
                                        if(teacherManager.findByName(name).isEmpty()){
                                            System.out.print("\n Không tìm thấy ai có tên " + name);
                                        }
                                        else{
                                            teacherManager.findByName(name);
                                        }
                                        break;
                                    case 4:
                                        teacherManager.sortByName();
                                        System.out.print("\n Đã sắp xếp thành công!");
                                        break;
                                    case 5:
                                        teacherManager.displayAll();
                                        System.out.print("\n Đã in danh sách!");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        while(countTeacher!=0);
                    case 3:
                        int countCourse;
                        do {
                            System.out.print("\n   ==== Quản Lý Môn Học ====");
                            System.out.print("\n 1.Thêm sinh viên.");
                            System.out.print("\n 2.Tìm kiếm theo Id.");
                            System.out.print("\n 3.Tìm kiếm theo tên.");
                            System.out.print("\n 4.Sắp xếp theo tên");
                            System.out.print("\n 5.In danh sách tất cả các Môn Học.");
                            System.out.print("\n 0.Quai lại.");
                            System.out.print("\n Bạn muốn chọn chức năng nào: ");
                            countCourse = sc.nextInt(); sc.nextLine();
                            if(countCourse>5 || countCourse<0){
                                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
                            }
                            else{
                                switch (countCourse){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.print("\n Nhập tên môn học: ");
                                        String courseName = sc.nextLine();
                                        System.out.print("\n Nhập số tín chỉ: ");
                                        int credit = sc.nextInt(); sc.nextLine();
                                        Course course = new Course(courseName,credit);
                                        courseManagere.add(course);
                                        System.out.print("\n Đã thêm môn học thành công!");
                                        break;
                                    case 2:
                                        System.out.print("\n Nhập Id muốn tìm: ");
                                        int id = sc.nextInt(); sc.nextLine();
                                        if(courseManagere.findById(id)!=null){
                                            courseManagere.findById(id);
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy môn học có Id như trên!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("\n Nhập tên muốn tìm: ");
                                        courseName = sc.nextLine();
                                        if(courseManagere.findByName(courseName).isEmpty()){
                                            System.out.print("\n Không tìm thấy môn học có tên " + courseName);
                                        }
                                        else{
                                            courseManagere.findByName(courseName);
                                        }
                                        break;
                                    case 4:
                                        courseManagere.sortByName();
                                        System.out.print("\n Đã sắp xếp thành công!");
                                        break;
                                    case 5:
                                        courseManagere.displayAll();
                                        System.out.print("\n Đã in danh sách!");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        while(countCourse!=0);
                    case 4:
                        System.out.print("\n Nhập id sinh viên: ");
                        int studentId = sc.nextInt(); sc.nextLine();
                        System.out.print("\n Nhập id môn học: ");
                        int courseId = sc.nextInt(); sc.nextLine();
                        studentManager.enrollStudent(studentId,courseId);
                        break;
                    case 5:
                        System.out.print("\n Nhập id sinh viên: ");
                        studentId = sc.nextInt(); sc.nextLine();
                        System.out.print("\n Nhập id môn học: ");
                        courseId = sc.nextInt(); sc.nextLine();
                        System.out.print("\n Nhập điểm: ");
                        double score = sc.nextDouble(); sc.nextLine();
                        studentManager.setScore(studentId,courseId,score);
                        break;
                    case 6:
                        System.out.print("\n Nhập id sinh viên: ");
                        studentId = sc.nextInt(); sc.nextLine();
                        studentManager.printTranscript(studentId);
                        System.out.print("\n Đã in bảng điểm thành công!");
                        break;
                    case 7:
                        teacherManager.printTeacherSalary();
                        System.out.print("\n Đã tính xong lương các giảng viên!");
                        break;
                    case 8:
                        int count8;
                        do{
                            System.out.print("\n   ==== Thống Kê ====");
                            System.out.print("\n 1.In Sinh viên có điểm GPA cao nhất.");
                            System.out.print("\n 2.Sắp xếp sinh viên theo điểm GPA.");
                            System.out.print("\n 3.Sắp xếp giảng viên theo lương.");
                            System.out.print("\n 0.Thoát chương trình.");
                            System.out.print("\n Bạn muốn chọn chức năng nào: ");
                            count8 = sc.nextInt(); sc.nextLine();
                            if(count8>3 || count8<0){
                                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
                            }
                            else{
                                switch (count8){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.print(studentManager.findTopStudent());
                                        System.out.print("\n Đã tìm thành công.");
                                        break;
                                    case 2:
                                        studentManager.sortStudentByGPADesc();
                                        System.out.print("\n Đã sắp xếp thành công!");
                                        break;
                                    case 3:
                                        teacherManager.sortTeacherBySalaryDesc();
                                        System.out.print("\n Đã sắp xếp thành công!");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        while (count8!=0);
                    case 9:
                        int countRemove;
                        do{
                            System.out.print("\n   ==== Xóa theo ID ====");
                            System.out.print("\n 1.Xóa sinh viên.");
                            System.out.print("\n 2.Xóa giảng viên.");
                            System.out.print("\n 3.Xóa môn học.");
                            System.out.print("\n 0.Thoát chương trình.");
                            countRemove = sc.nextInt(); sc.nextLine();
                            if(countRemove>3 || countRemove<0){
                                System.out.print("\n Hãy nhập đúng số của chức năng mà bạn muốn dùng!");
                            }
                            else{
                                switch (countRemove){
                                    case 0:
                                        break;
                                    case 1:
                                        System.out.print("\n Nhập id sinh viên muốn xóa: ");
                                        studentId = sc.nextInt(); sc.nextLine();
                                        if(studentManager.removeById(studentId)){
                                            System.out.print("\n Đã xóa sinh viên thành công!");
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy sinh viên có id như trên!");
                                        }
                                        break;
                                    case 2:
                                        System.out.print("\n Nhập id giảng viên muốn xóa: ");
                                        int teacherID = sc.nextInt(); sc.nextLine();
                                        if(teacherManager.removeById(teacherID)){
                                            System.out.print("\n Đã xóa giảng viên thành công!");
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy giảng viên có id như trên!");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("\n Nhập id môn học muốn xóa: ");
                                        courseId = sc.nextInt(); sc.nextLine();
                                        if(courseManagere.removeById(courseId)){
                                            System.out.print("\n Đã xóa môn học thành công!");
                                        }
                                        else{
                                            System.out.print("\n Không tìm thấy môn học có id như trên!");
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        while (countRemove!=0);
                    default:
                        break;
                }
            }
        }
        while(count!=0);
        System.out.print("\n Chương trình đã kết thúc!");
        System.out.print("\n Thank you very much :)");
    }
}
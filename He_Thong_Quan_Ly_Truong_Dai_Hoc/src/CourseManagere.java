import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseManagere implements Manageable<Course>{
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;

    public CourseManagere(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public CourseManagere() {
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void add(Course item) {
        courses.add(item);
    }

    @Override
    public boolean removeById(int id) {
        for(Course c : courses){
            if(c.getCourseId()==id){
                courses.removeIf(course -> c.getCourseId()==id);
                //                for(Enrollment e : enrollments){
//                    if(e.getCourseId().getId()==id){
                enrollments.removeIf(enrollment -> enrollment.getCourse().getCourseId()==id);
//                    }
//                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Course findById(int id) {
        for(Course c : courses){
            if(c.getCourseId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> courseList = new ArrayList<>();
        for(Course c : courses){
            if(c.getCourseName().equalsIgnoreCase(name)){
                courseList.add(c);
            }
        }
        return courseList;
    }

    @Override
    public void sortByName() {
        if(courses.isEmpty()){
            System.out.print("\n Danh sách trống!");
        }
        else {
            courses.sort(Comparator.comparing(Course::getCourseName));
        }
    }

    @Override
    public void displayAll() {
        if(courses.isEmpty()){
            System.out.print("\n Danh sách trống!");
        }
        else {
            for (Course c : courses){
                c.getCourseInfo();
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TeacherManager implements Manageable<Teacher>{
    private ArrayList<Teacher> teachers;

    public TeacherManager(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TeacherManager() {
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void add(Teacher item) {
        teachers.add(item);
    }

    @Override
    public boolean removeById(int id) {
        for (Teacher t : teachers){
            if(t.getId()==id){
                teachers.removeIf(teacher -> t.getId()==id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Teacher findById(int id) {
        for (Teacher t : teachers){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findByName(String name) {
        List<Teacher> teacherList = new ArrayList<>();
        for(Teacher t : teachers){
            if(t.getName().equalsIgnoreCase(name)){
                teacherList.add(t);
            }
        }
        return teacherList;
    }

    @Override
    public void sortByName() {
        if (teachers.isEmpty()) {
            System.out.print("\n Danh sách trống!");
        }
        else {
            teachers.sort(Comparator.comparing(Teacher::getName));
        }
    }

    @Override
    public void displayAll() {
        if(teachers.isEmpty()){
            System.out.print("\n Danh sách trống!");
        }
        else {
            for (Teacher t : teachers) {
                t.getInfo();
            }
        }
    }
    public void printTeacherSalary(){
        for(Teacher t : teachers){
            System.out.print("\n Teacher: " + t.getSurname() + " " + t.getName() + " - Salary: " + t.calculateSalary() + " VND");
        }
    }
    public void sortTeacherBySalaryDesc(){
        teachers.sort(Comparator.comparingDouble(Teacher::calculateSalary).reversed());
    }
}

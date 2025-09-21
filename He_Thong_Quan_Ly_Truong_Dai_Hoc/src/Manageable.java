import java.util.List;

public interface Manageable<T> {
    //Hàm thêm
    void add(T item);
    //Hàm xóa theo id
    boolean removeById(int id);
    //hàm tìm theo id
    T findById(int id);
    //hàm tìm danh sách tên
    List<T> findByName(String name);
    //Hàm sắp xếp theo tên từ A -> Z
    void sortByName();
    //Hàm in tất cả ra màn hình
    void displayAll();
}

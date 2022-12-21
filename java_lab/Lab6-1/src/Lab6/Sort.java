package Lab6;
import java.util.Comparator;
public class Sort implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        int sortint = 0;
        if (student1 != null && student2 != null) {
            sortint = student1.getLastname().compareTo(student2.getLastname());
        }
        return sortint;
    }
}

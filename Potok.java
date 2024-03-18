import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс учебной группы
class StudyGroup {
    private String name;

    public StudyGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Класс потока, содержащий список учебных групп
class Stream implements Iterable<StudyGroup> {
    protected List<StudyGroup> groups; // Изменили модификатор доступа на protected

    public Stream() {
        groups = new ArrayList<>();
    }

    public void addGroup(StudyGroup group) {
        groups.add(group);
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return groups.iterator();
    }
}

// Класс компаратора потоков
class StreamComparator {
    public int compare(Stream stream1, Stream stream2) {
        // Теперь мы можем обращаться к полю groups, так как оно protected
        return Integer.compare(stream1.groups.size(), stream2.groups.size());
    }
}

public class Potok {
    public static void main(String[] args) {
        // Создаем потоки и добавляем в них учебные группы
        Stream stream1 = new Stream();
        stream1.addGroup(new StudyGroup("Group 1"));
        stream1.addGroup(new StudyGroup("Group 2"));

        Stream stream2 = new Stream();
        stream2.addGroup(new StudyGroup("Group 1"));
        stream2.addGroup(new StudyGroup("Group 2"));
        stream2.addGroup(new StudyGroup("Group 3"));

        // Создаем компаратор потоков
        StreamComparator comparator = new StreamComparator();

        // Сравниваем потоки по количеству групп
        int result = comparator.compare(stream1, stream2);

        // Выводим результат сравнения
        if (result < 0) {
            System.out.println("Stream 1 has fewer groups than Stream 2");
        } else if (result > 0) {
            System.out.println("Stream 1 has more groups than Stream 2");
        } else {
            System.out.println("Stream 1 and Stream 2 have the same number of groups");
        }
    }
}

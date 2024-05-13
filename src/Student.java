public class Student {

    private int Student_Id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.Student_Id = id;
        this.name = name;
        this.course = course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setID(int id) {
        this.Student_Id = id;
    }

    public int getID() {
        return Student_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(Student_Id).append(", Name: ").append(name).append(", Course: ").append(course);
        return sb.toString();
    }
}

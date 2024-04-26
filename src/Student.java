public class Student {

    private int id;
    private String name;
    private double[] marks;

    public Student(int id, String name, double[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
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
        sb.append("ID: ").append(id).append(", Name: ").append(name).append(", Marks: ");
        for (Double mark : marks) {
            sb.append(mark).append(" ");
        }
        return sb.toString();
    }
}

package firstlook.jihad.assignment_one.model;

public class Item {

    String subject;
    String teacher;
    int image;

    public Item(String subject,String teacher, int image) {
        this.subject = subject;
        this.image = image;
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

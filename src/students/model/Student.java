package students.model;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String city;
    private Lesson lesson;
    private User registerUser;

    public Student(String name, String surname, int age, String phoneNumber, String city, Lesson lesson,User registerUser) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.lesson = lesson;
        this.registerUser = registerUser;
    }


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public User getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(User registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lesson='" + lesson.getName() + '\'' +
                ", registerUser='" + registerUser + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

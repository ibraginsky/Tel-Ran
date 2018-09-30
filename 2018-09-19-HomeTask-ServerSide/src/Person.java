public class Person {
    String name;
    int age;
    String phone;
    String city;

    public Person(String name, int age, String phone, String city) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ";\tAge: " + age +
                ";\tPhone: " + phone +
                ";\tCity: " + city;
    }
}

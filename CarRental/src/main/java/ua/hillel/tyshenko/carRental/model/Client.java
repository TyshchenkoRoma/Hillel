package ua.hillel.tyshenko.carRental.model;

/**
 * Created by roman on 29.07.16.
 */
public class Client {

    private String firstName;
    private String secondName;
    private int age;
    private Long clientId;

    public Client( String firstName, String secondName, int age, Long clientId) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.clientId = clientId;
    }



    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +

                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", clientId=" + clientId +
                '}';
    }
}

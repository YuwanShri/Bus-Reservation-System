/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package busreservationsystem.pkg1;

public class Customer {
    String name; // Updated to private for information hiding
    private String mobileNumber;
    private String email;
    private String city;
    private int age;

    public Customer(String name, String mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        setAge(age); // Use setter to ensure validation
    }

    // Getters and Setters for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) { // Validation for name
            System.err.println("Invalid name provided. Defaulting to 'Unknown'.");
            this.name = "Unknown"; // Fallback value
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        if (mobileNumber != null && mobileNumber.matches("\\d{10}")) { // Validation for a 10-digit number
            this.mobileNumber = mobileNumber;
        } else {
            throw new IllegalArgumentException("Mobile number must be a 10-digit numeric value.");
        }
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) { // Simple validation for email
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
    if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
        this.city = city;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) { // Validation for positive age
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be greater than 0.");
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}


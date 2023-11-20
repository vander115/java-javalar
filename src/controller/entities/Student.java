package controller.entities;

public class Student {
  private String name;
  private int enrollment;

  public Student(String name, int enrollment) {
    this.name = name;
    this.enrollment = enrollment;
  }

  public String getName() {
    return name;
  }

  public int getEnrollment() {
    return enrollment;
  }
}

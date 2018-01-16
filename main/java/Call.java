public class Call {

  private Long duration;
  private String employeee;

  public Call() {}

  public Call(Long duration, String employeee) {
    this.duration = duration;
    this.employeee = employeee;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getEmployeee() {
    return employeee;
  }

  public void setEmployeee(String employeee) {
    this.employeee = employeee;
  }
}

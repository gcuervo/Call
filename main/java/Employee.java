import java.util.List;

import static java.lang.Thread.sleep;

public abstract class Employee {
  private String name;
  private Boolean isAvailable;
  private List<Call> answeredCalls;

  public Employee(String name) {
    this.name = name;
  }

  protected void answerCall(Call call) {
    try {
      sleep(call.getDuration());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    answeredCalls.add(call);
    isAvailable = Boolean.TRUE;
  }

  public void getCall(Call call) {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getisAvailable() {
    return isAvailable;
  }

  public void setisAvailable(Boolean available) {
    this.isAvailable = available;
  }

  public List<Call> getAnsweredCalls() {
    return answeredCalls;
  }

  public void setAnsweredCalls(List<Call> answeredCalls) {
    this.answeredCalls = answeredCalls;
  }
}

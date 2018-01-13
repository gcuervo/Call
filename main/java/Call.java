public class Call {

    private Double duration;
    private String employeee;

    public Call() {

    }

    public Call(double duration, String employeee) {
        this.duration = duration;
        this.employeee = employeee;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getEmployeee() {
        return employeee;
    }

    public void setEmployeee(String employeee) {
        this.employeee = employeee;
    }
}

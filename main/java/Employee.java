import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Employee {
    private String name;
    private AtomicBoolean available;

    private List<Call> answeredCalls;

    public Employee(String name) {
        this.name = name;
    }

    public void getCall(Call call) {

    }

}

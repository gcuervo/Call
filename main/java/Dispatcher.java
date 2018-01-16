import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class Dispatcher {

  private ExecutorService executor;
  private BlockingQueue<Call> waitingCalls;
  private EmployeeBusiness employeeBusiness;
  private ConcurrentLinkedQueue<Call> receiveCalls;

  private Logger logger = Logger.getLogger(Dispatcher.class.getName());

  public Dispatcher(Integer threads) {
    executor = Executors.newFixedThreadPool(threads);
    waitingCalls = new LinkedBlockingQueue<Call>();
    employeeBusiness = new EmployeeBusiness();
  }

  public void ready(List<Call> calls) {
    receiveCalls.addAll(calls);
  }

  public void addCall(Call call) {
    receiveCalls.add(call);
  }

  public void dispatchCall(final Employee employee, final Call call) {
    executor.execute(
        new Runnable() {
          public void run() {
            System.out.println("entro ");
            employee.answerCall(call);
            waitingCalls();
          }
        });
  }

  private void waitingCalls() {
    if (waitingCalls.isEmpty()) {
      executor.shutdown();
    }
    Call call = waitingCalls.remove();
    callHandler(call);
  }

  public void callHandler(Call call) {
    try {
      Employee employee = employeeBusiness.getAvailableEmployee();
      dispatchCall(employee, call);
    } catch (CallCenterException ex) {
      logger.info(ex.getMessage());
      waitingCalls.add(call);
    }
  }
}

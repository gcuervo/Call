import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Dispatcher {

    private ExecutorService executor;
    private BlockingQueue waitingCalls;

    private List<Director> directors;
    private List<Operator> operators;
    private List<Supervisor> supervisors;

    public Dispatcher(Integer threads) {
        executor = Executors.newFixedThreadPool(threads);
        waitingCalls = new LinkedBlockingQueue();

        directors = new ArrayList<Director>();
        operators = new ArrayList<Operator>();
        supervisors = new ArrayList<Supervisor>();

    }

    private void employ(Long cantDir, Long cantSup, Long cantOp) {
        int index = 0;

        while (index < cantDir) {
            directors.add(new Director("Director " + String.valueOf(index++)));
        }
        index = 0;
        while (index < cantSup) {
            supervisors.add(new Supervisor("Supervisor " + String.valueOf(index++)));
        }
        index = 0;
        while (index < cantOp) {
            operators.add(new Operator("Operator " + String.valueOf(index++)));
        }
    }

    public void callHandler(Call call) throws CallCenterException {

        Employee availableEmployee =
    }
}

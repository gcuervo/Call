import java.util.List;
import java.util.logging.Logger;

public class EmployeeBusiness {

  private List<Director> directors;
  private List<Operator> operators;
  private List<Supervisor> supervisors;

  private Logger logger = Logger.getLogger(EmployeeBusiness.class.getName());

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

  public Operator getAvailableOperator() throws CallCenterException {
    Operator operator = null;
    for (Operator op : operators) {
      if (op.getisAvailable()) {
        operator = op;
      }
    }
    if (operator == null) {
      throw new CallCenterException(ErrorConstants.NO_AVAILABLE_OPERATOR);
    }
    return operator;
  }

  public Supervisor getAvailableSupervisor() throws CallCenterException {
    Supervisor supervisor = null;
    for (Supervisor op : supervisors) {
      if (op.getisAvailable()) {
        supervisor = op;
      }
    }
    if (supervisor == null) {
      throw new CallCenterException(ErrorConstants.NO_AVAILABLE_SUPERVISOR);
    }
    return supervisor;
  }

  public Director getAvailableDirector() throws CallCenterException {
    Director director = null;
    for (Director op : directors) {
      if (op.getisAvailable()) {
        director = op;
      }
    }
    if (director == null) {
      throw new CallCenterException(ErrorConstants.NO_AVAILABLE_DIRECTOR);
    }
    return director;
  }

  public synchronized Employee getAvailableEmployee() throws CallCenterException {
    Employee employee = null;
    try {
      employee = getAvailableOperator();
    } catch (CallCenterException ex) {
      logger.info(ex.getMessage());
    }
    try {
      employee = getAvailableSupervisor();
    } catch (CallCenterException ex) {
      logger.info(ex.getMessage());
    }
    try {
      employee = getAvailableDirector();
    } catch (CallCenterException ex) {
      logger.info(ex.getMessage());
    }
    if (employee == null) {
      throw new CallCenterException(ErrorConstants.NO_AVAILABLE_EMPLOYEE);
    } else {
        employee.setisAvailable(Boolean.FALSE);
    }

    return employee;
  }
}

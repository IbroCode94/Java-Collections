package service;

import org.example.Model.Applicant;
import org.example.Model.Cashier;
import org.example.Model.Mall;
import org.example.Model.Manager;

public interface managerService {
    String hireCashier(Manager manager, Applicant applicant);
    boolean fireCashier (Mall mall, Cashier cashier);
}

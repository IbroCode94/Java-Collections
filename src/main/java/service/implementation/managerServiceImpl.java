package service.implementation;

import enums.Role;
import org.example.Model.Applicant;
import org.example.Model.Cashier;
import org.example.Model.Mall;
import org.example.Model.Manager;
import service.managerService;

public class managerServiceImpl implements managerService {

    @Override
    public String hireCashier(Manager manager, Applicant applicant) {
if(manager.getPosition() == Role.MANAGER) {
    if(applicant.getAge() >= 19 && applicant.getAge() <= 30) {
        applicant.setHired(true);
        return "Applicant " + applicant.getName() + " is now hired as a cashier";

    }else {
        return "Sorry Role not available  due to Age Limit";
    }

}
return  " You are not the  Manager ";
    }

    @Override
    public boolean fireCashier(Mall mall, Cashier cashier) {
      for(int i = 0; i < mall.getCashiersList().size(); i++) {
          if(mall.getCashiersList().get(i).getWorkID() == cashier.getWorkID()) {
              if(cashier.getNoOfDaysAbsent() > 4 ) {
                  mall.getCashiersList().remove(cashier);
                  System.out.println("Cashier " + cashier.getName() + "Has been fire");
                  return  true;
              }else {
                  System.out.println("You are doing well");
              }
              break;
          }
      }
      return false;
    }
}

package service.implementation;

import org.example.Model.Customer;
import org.example.Model.Mall;
import org.example.Model.Products;
import service.customerService;

import java.util.ArrayList;

public class customerServiceImpl implements customerService {
 private Customer customer;

  public customerServiceImpl(Customer customer){
      this.customer = customer;
  }

    public customerServiceImpl() {
    }

    @Override
    public void addGoods(Products products, int volume, Mall mall) {
        Products selected = new Products(products.getName(),products.getCategory(),products.getPrice(), volume);
        for (Products p: mall.getProductsList()) {
            if(p.getName().equals(selected.getName())){
                if(p.getQuantity() == 0){
                    System.out.println("OUT OF STOCK");
                }else if (p.getQuantity() < selected.getQuantity()) {
                    System.out.println("SORRY NOT ENOUGH");
                }else {
                   customer.getGoods().add(selected);
                    System.out.println(customer.getName() + " Added " + selected.getName() + " to the cart");

                    int remainder = p.getQuantity() - volume;
                    p.setQuantity(remainder);
                }
            }
        }
    }
}

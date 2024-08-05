package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Orders;
import com.SpringBoot.DemoProject.Model.User;
import com.SpringBoot.DemoProject.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository ;

    public List<Orders> OrdersGetApi() {
        return ordersRepository.findAll();
    }

    public String OrdersPostApi(Orders order) {
        ordersRepository.save(order);
        return " Orders Record Saved ! ";
    }

    public String OrdersPutApi(Orders order) {
        ordersRepository.save(order);
        return " Orders Record Update ! ";
    }

    public String OrdersDeleteApi(long orderId) {
        ordersRepository.deleteById(orderId);
        return " Delete Record Successfully !";
    }

    public String OrdersDeleteListApi(List<Long> ordersId) {
        for(Long orders :ordersId) {
            ordersRepository.deleteById(orders);
        }
        return " List of ID Deleted Successfully !";
    }

    public List<Orders> OrderRawGetApi(Set<Long> orderId) {
        List<Orders> rawOrder = ordersRepository.GetOrderId(orderId);
        return rawOrder;
    }

}


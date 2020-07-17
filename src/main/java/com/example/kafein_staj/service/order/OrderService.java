package com.example.kafein_staj.service.order;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityNotFoundException;

import java.util.ArrayList;

public interface OrderService {
    Order findById(Long order_id) throws EntityNotFoundException;
    void updateOrder(Order order,Long order_id);
    void deleteById(Long order_id) throws EntityNotFoundException;

}

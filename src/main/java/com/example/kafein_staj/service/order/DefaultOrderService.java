package com.example.kafein_staj.service.order;

import com.example.kafein_staj.entity.Order;
import com.example.kafein_staj.entity.User;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.repository.OrderRepository;
import com.example.kafein_staj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;
@Service
public class DefaultOrderService implements OrderService {
   private OrderRepository orderRepository;
   private UserRepository userRepository;
    @Autowired
    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long order_id) throws EntityNotFoundException {
        return orderRepository.findById(order_id).orElseThrow(
                () -> new EntityNotFoundException("Order with id " + order_id + " does not exist"));

    }

    @Override
    public void updateOrderStatus(Order order,String newStatus) throws EntityNotFoundException {
       long order_id=order.getOrderId();
        if(orderRepository.findById(order_id).isPresent()){//bana verilen order mevcut mu kontrol ediyorum
            order.setStatus(newStatus); // eğer öyle bir order varsa order'ın yeni durumunu update ediyorum.
        }else
        {
            throw new EntityNotFoundException("Order with "+ order_id+ "does not exists");
        }
    }


    @Override
    public void deleteById(Long order_id) throws EntityNotFoundException {
        try {
            orderRepository.deleteById(order_id);

        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Order with "+order_id+" has already been deleted");
        }


    }


}

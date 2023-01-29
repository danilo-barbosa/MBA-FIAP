
package br.com.fiap.abctechapi.application.impl;

import br.com.fiap.abctechapi.application.OrderApplication;
import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDto;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.model.OrderLocation;
import br.com.fiap.abctechapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderApplicationImpl implements OrderApplication {

    private final OrderService orderService;

    @Override
    public void createOrder(OrderDto orderDto) throws Exception {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromDto(orderDto.getStart()));
        order.setEndOrderLocation(getOrderLocationFromDto(orderDto.getEnd()));
        orderService.saveOrder(order, orderDto.getAssists());
    }

    private OrderLocation getOrderLocationFromDto (OrderLocationDto orderLocationDto) {
        OrderLocation orderLocation = new OrderLocation();
        orderLocation.setLatitude(orderLocationDto.getLatitude());
        orderLocation.setLongitude(orderLocationDto.getLongitude());
        orderLocation.setDate(orderLocationDto.getDateTime());
        return orderLocation;
    }
}
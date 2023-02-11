
package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.handler.exception.CoordinatesException;
import br.com.fiap.abctechapi.handler.exception.InvalidAssistException;
import br.com.fiap.abctechapi.handler.exception.MaxAssistsException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistsException;
import br.com.fiap.abctechapi.model.Assist;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.model.OrderLocation;
import br.com.fiap.abctechapi.repository.AssistRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AssistRepository assistRepository;

    @Autowired
    public OrderServiceImpl (OrderRepository orderRepository, AssistRepository assistRepository){
        this.orderRepository = orderRepository;
        this.assistRepository = assistRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) {
        ArrayList<Assist> assists = new ArrayList<>();
        arrayAssists.forEach( i -> {
            Assist assist = assistRepository.findById(i)
                    .orElseThrow(() -> new InvalidAssistException("Invalid Request","Invalid Assist.") );
            assists.add(assist);
        });
        order.setServices(assists);

        if(!order.hasMinAssists()) {
            throw new MinimumAssistsException("Invalid Request.","Minimum assists required.");
        }

        if(order.exceedsMaxAssists()){
            throw new MaxAssistsException("Invalid request.","Maximum assists exceeded.");
        }

        OrderLocation startOrderLocation = order.getStartOrderLocation();
        OrderLocation endOrderLocation = order.getEndOrderLocation();

        if (!startOrderLocation.validLatitude() || !startOrderLocation.validLongitude()) {
            throw new CoordinatesException("Coordenadas Inválidas", "As coordenadas de entrada são inválidas.");
        }

        if (!endOrderLocation.validLatitude() || !endOrderLocation.validLongitude()) {
            throw new CoordinatesException("Coordenadas Inválidas", "As coordenadas de saída são inválidas.");
        }

        if (!startOrderLocation.validDistance(endOrderLocation.getLatitude(), endOrderLocation.getLongitude())) {
            throw new CoordinatesException("Coordenadas Inválidas", "Distância entre entrada e saída de serviço não permitida (" + startOrderLocation.getMaxDistance() + " metros).");
        }

        orderRepository.save(order);
    }
}

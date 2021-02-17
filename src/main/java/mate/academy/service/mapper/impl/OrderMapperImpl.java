package mate.academy.service.mapper.impl;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import mate.academy.model.Order;
import mate.academy.model.Ticket;
import mate.academy.model.dto.response.OrderResponseDto;
import mate.academy.service.mapper.OrderMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    private static final String FORMATTER = "dd.MM.yyyy HH:mm";

    @Override
    public OrderResponseDto convertToDto(Order entity) {
        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(entity.getId());
        orderDto.setUserId(entity.getUser().getId());
        orderDto.setTicketIds(entity.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderDto.setOrderTime(entity.getOrderTime().format(DateTimeFormatter.ofPattern(FORMATTER)));
        return orderDto;
    }
}

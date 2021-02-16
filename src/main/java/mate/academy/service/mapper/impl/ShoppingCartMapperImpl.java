package mate.academy.service.mapper.impl;

import java.util.stream.Collectors;
import mate.academy.model.ShoppingCart;
import mate.academy.model.Ticket;
import mate.academy.model.dto.response.ShoppingCartResponseDto;
import mate.academy.service.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto convertToDto(ShoppingCart entity) {
        ShoppingCartResponseDto shoppingCartDto = new ShoppingCartResponseDto();
        shoppingCartDto.setId(entity.getId());
        shoppingCartDto.setTicketIds(entity.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartDto;
    }
}

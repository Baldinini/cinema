package mate.academy.service.mapper;

public interface GenericMapperRequestToEntity<T, I> {
    I convertToEntity(T requestDto);
}

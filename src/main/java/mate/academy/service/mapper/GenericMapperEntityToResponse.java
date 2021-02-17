package mate.academy.service.mapper;

public interface GenericMapperEntityToResponse<I, T> {
    T convertToDto(I entity);
}

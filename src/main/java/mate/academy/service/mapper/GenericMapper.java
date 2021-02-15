package mate.academy.service.mapper;

public interface GenericMapper<I, T, K> {
    I convertToDto(T entity);

    T convertToEntity(K requestDto);
}

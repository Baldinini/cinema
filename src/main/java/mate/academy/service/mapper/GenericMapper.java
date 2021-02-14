package mate.academy.service.mapper;

public interface GenericMapper<I,T,K> {
    I convertToDto(T t);

    T convertToEntity(K k);
}

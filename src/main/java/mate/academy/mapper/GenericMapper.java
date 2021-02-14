package mate.academy.mapper;

public interface GenericMapper<I,T,K> {
    I convertToDto(T t);

    T convertToEntity(K k);
}

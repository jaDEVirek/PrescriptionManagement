package src.main.java.com.jadevirek.prescriptionapp.utils;


import org.springframework.stereotype.Component;

@Component
public interface IObjectServiceUtils<T> {

    public T convertToDto(Object object);
    public void validateObjectFields(T typeObject);

}

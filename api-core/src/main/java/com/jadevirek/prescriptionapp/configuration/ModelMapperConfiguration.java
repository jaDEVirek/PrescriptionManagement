package src.main.java.com.jadevirek.prescriptionapp.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.modelmapper.config.Configuration.AccessLevel;

import java.util.Objects;

@Configuration
public class ModelMapperConfiguration {

    private static ModelMapper modelMapper;

    public ModelMapperConfiguration() throws Exception {
        if (modelMapper != null) {
            throw new Exception("Object already exist");
        }
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static ModelMapper getModelMapperInstance() {
        if (Objects.isNull(modelMapper)) {
            synchronized (ModelMapperConfiguration.class) {
                if (Objects.isNull(modelMapper)) {
                    modelMapper = new ModelMapper();
                }
            }
        }
        modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)  .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        return modelMapper;
    }
}

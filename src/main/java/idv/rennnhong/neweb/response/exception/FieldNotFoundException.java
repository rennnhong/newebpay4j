package idv.rennnhong.neweb.response.exception;

import java.text.MessageFormat;

public class FieldNotFoundException extends RuntimeException {

    public FieldNotFoundException(String fieldName) {
        super(MessageFormat.format("the field:{0} not found!", fieldName));
    }
}

package Model.vals;

import Model.types.StringType;
import Model.types.Type;

public class StringValue implements Value{
    String value;

    public StringValue(String value){
        this.value = value;
    }
    @Override
    public Type getType() {
        return new StringType();
    }

    public String getValue() {
        return value;
    }
}

package Model.vals;

import Model.types.BoolType;
import Model.types.Type;

public class BoolValue implements Value{
    boolean value;

    public BoolValue(boolean value){
        this.value = value;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
    public boolean getValue(){
        return this.value;
    }

}

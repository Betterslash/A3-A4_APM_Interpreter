package Model.vals;

import Model.types.IntType;
import Model.types.Type;

public class IntValue implements Value{
    int value;
    public IntValue(int value){
        this.value = value;
    }
    @Override
    public Type getType() {
        return new IntType();
    }
    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

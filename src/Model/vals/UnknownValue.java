package Model.vals;

import Model.types.Type;

public class UnknownValue implements Value {
    Type type;
    public UnknownValue(Type type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "Unknown "+type.toString()+"@value";
    }

    @Override
    public Type getType() {
        return this.type;
    }
}

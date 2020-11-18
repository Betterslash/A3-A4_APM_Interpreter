package Model.vals;

import Model.types.RefType;
import Model.types.Type;

public class RefValue implements Value{
    final Type locationType;
    int address;


    public RefValue(Type locationType, int address) {
        this.locationType = locationType;
        this.address = address;
    }

    @Override
    public Type getType() {
        return new RefType(this.locationType);
    }

    public int getAddress() {
        return address;
    }

    public Type getLocationType() {
        return locationType;
    }

    public final int getAndIncrement(){return address;}

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "(" + this.address + ", "+ this.getLocationType() + ")";
    }
}

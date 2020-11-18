package Model.types;

public class BoolType implements Type{
    @Override
    public String toString() {
        return "bool ";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoolType;
    }
}

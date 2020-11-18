package Model.types;

public class IntType implements Type{
    @Override
    public String toString() {
        return "int ";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntType;
    }
}

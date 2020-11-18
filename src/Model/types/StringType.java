package Model.types;

public class StringType implements Type{
    @Override
    public String toString() {
        return "str ";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StringType;
    }
}

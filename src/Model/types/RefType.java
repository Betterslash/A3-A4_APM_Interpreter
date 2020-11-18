package Model.types;

import Model.vals.Value;

public class RefType implements Type{
    Type inner;
    public RefType(Type inner){
        this.inner = inner;
    }
    public RefType(){}
    public Type getInner() {
        if (inner instanceof RefType){

        }
        return inner;
    }

    public boolean equals(Object obj){
        if(obj instanceof RefType){
            return ((RefType) obj).inner.equals(this.inner);
        }
        else {
            return this.inner.equals(obj);
        }
    }

    @Override
    public String toString() {
        return "Ref("+ inner.toString() +")";
    }

}

package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.types.Type;
import Model.vals.UnknownValue;
import Model.vals.Value;

public class VarDeclStmt implements IStmt{
    final Type type;
    final String id;

    public VarDeclStmt(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IDict<String, Value> symTable = state.getSymTable();
        if(symTable.lookup(id) == null){
            symTable.add(id, new UnknownValue(this.type));
        }
    return state;
    }

    @Override
    public String toString() {
        return type  + id;
    }
}

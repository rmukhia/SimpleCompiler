package alang.semantic;

import java.util.HashMap;

public class SymbolTable {
    private SymbolTable parent;
    private HashMap<String, SymbolTableRow> entries;

    public SymbolTable(SymbolTable parent) {
        entries = new HashMap<>();
        this.parent = parent;
    }

    public void add(String id, SymbolTableRow row) {
        entries.put(id, row);
    }

    public SymbolTableRow lookup(String id) {
        return entries.get(id);
    }
}


package br.com.digitalhouse.aleatoryapp.model;

import com.google.gson.annotations.Expose;

public class Id {

    @Expose
    private String name;
    @Expose
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}

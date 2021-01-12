package com.company.java.io.serial;


import java.io.Serializable;

public class Wolf implements Serializable {
    private static final long serialVersionUID=519067123721295773L;

    private String id;
    private String name;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getType() {
        return type;
    }

    public void setType(String pType) {
        type = pType;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

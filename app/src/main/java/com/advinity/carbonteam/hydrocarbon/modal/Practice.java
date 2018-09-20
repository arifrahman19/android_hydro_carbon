package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 18/01/17.
 */

public class Practice {
    private int index;
    private String name, formula, other;

    public Practice(int index, String name, String formula, String other) {
        this.index = index;
        this.name = name;
        this.formula = formula;
        this.other = other;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

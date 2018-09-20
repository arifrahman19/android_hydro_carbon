package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 23/11/16.
 */

public class Alkana {
    private String name, formula, density, molar, boiling, melting, example;
    private int image;

    public Alkana(String name, String formula, String density, String molar, String boiling, String melting, String example, int image) {
        this.name = name;
        this.formula = formula;
        this.density = density;
        this.molar = molar;
        this.boiling = boiling;
        this.melting = melting;
        this.example = example;
        this.image = image;
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

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getMolar() {
        return molar;
    }

    public void setMolar(String molar) {
        this.molar = molar;
    }

    public String getBoiling() {
        return boiling;
    }

    public void setBoiling(String boiling) {
        this.boiling = boiling;
    }

    public String getMelting() {
        return melting;
    }

    public void setMelting(String melting) {
        this.melting = melting;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

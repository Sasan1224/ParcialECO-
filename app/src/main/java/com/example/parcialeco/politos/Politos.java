package com.example.parcialeco.politos;

public class Politos {

        private int xPos, yPos;
        private String name;
        private int quant;
        private int r, g, b;
        private Boolean delete;


        public Politos(int xPos, int yPos, String name, int quant, int r, int g, int b, boolean delete) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.name = name;
            this.quant = quant;
            this.r = r;
            this.g = g;
            this.b = b;
            this.delete = delete;

        }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Politos() {

        }



    }

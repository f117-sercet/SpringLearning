package com.Demo04;

public class BookWormOracle implements Oracle{
    private Encyclopedia encyclopedia;
    private void setEncyclopedia(Encyclopedia encyclopedia){
        this.encyclopedia=encyclopedia;
    }
    @Override
    public String defineMeaningOfLife() {
        return "Hello,world";
    }
}

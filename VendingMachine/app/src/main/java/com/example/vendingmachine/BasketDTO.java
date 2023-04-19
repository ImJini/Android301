package com.example.vendingmachine;

import java.io.Serializable;
import java.util.ArrayList;

public class BasketDTO implements Serializable {
    private SodaDTO cola = new SodaDTO("cola",0,0 );
    private SodaDTO cider = new SodaDTO("cider",0,0 );
    private SodaDTO fanta =new SodaDTO("fanta",0,0 );
    private SodaDTO demisoda = new SodaDTO("demisoda",0,0 );

    public SodaDTO getCola() {
        return cola;
    }

    public void setCola(SodaDTO cola) {
        this.cola = cola;
    }

    public SodaDTO getCider() {
        return cider;
    }

    public void setCider(SodaDTO cider) {
        this.cider = cider;
    }

    public SodaDTO getFanta() {
        return fanta;
    }

    public void setFanta(SodaDTO fanta) {
        this.fanta = fanta;
    }

    public SodaDTO getDemisoda() {
        return demisoda;
    }

    public void setDemisoda(SodaDTO demisoda) {
        this.demisoda = demisoda;
    }
}

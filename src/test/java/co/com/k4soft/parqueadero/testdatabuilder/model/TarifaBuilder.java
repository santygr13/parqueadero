package co.com.k4soft.parqueadero.testdatabuilder.model;

import co.com.k4soft.parqueadero.model.Tarifa;

public class TarifaBuilder {
    private Integer id;
    private String nombre;
    private double precio;

    public TarifaBuilder() {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public TarifaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public TarifaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TarifaBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Tarifa build(){
        return new Tarifa(this.id,this.nombre,this.precio);
    }
}

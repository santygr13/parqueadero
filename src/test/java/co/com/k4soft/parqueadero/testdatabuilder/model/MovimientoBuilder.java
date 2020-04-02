package co.com.k4soft.parqueadero.testdatabuilder.model;

import co.com.k4soft.parqueadero.model.Movimiento;
import co.com.k4soft.parqueadero.model.Tarifa;


import java.util.Date;

public class MovimientoBuilder {




    private Integer idMoviento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String placa;
    private Tarifa tarifa;

    public MovimientoBuilder() {
        this.idMoviento = idMoviento;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.placa = placa;
        this.tarifa = tarifa;
    }

    public MovimientoBuilder setIdMoviento(Integer idMoviento) {
        this.idMoviento = idMoviento;
        return this;
    }

    public MovimientoBuilder setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public MovimientoBuilder setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public MovimientoBuilder setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public MovimientoBuilder setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public Movimiento build()  {
       return new Movimiento(this.idMoviento,this.fechaIngreso,this.fechaSalida,this.placa,this.tarifa);
    }
}

package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.util.DateUtil;
import co.com.k4soft.parqueadero.model.util.Validator;

import java.util.Date;

public class Movimiento {

    public static final String FECHA_INGRESO_REQUERIDA = "La fecha de ingreso es requerida";
    public static final String FECHA_SALIDA_REQUERIDA = "La fecha de salida es requerida";
    public static final String PLACA_REQUERIDA = "La placa es requerida" ;
    public static final String TARIFA_NO_CONFIGURADA = "La tarifa no está configurada";
    public static final String VALOR_TARIFA_ES_REQUERIDO = "El valor de la tarifa es requerido";
    public static final String FECHA_IGUAL="las fechas no pueden ser iguales";
    public static final String FECHA_SALIDA_MENOR="la fecha de salida no puede ser antes que la de entrada";

    private Integer idMoviento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String placa;
    private Tarifa tarifa;

    public Movimiento(Integer idMoviento, Date fechaIngreso, Date fechaSalida, String placa, Tarifa tarifa) {


        Validator.validarFechaNula(fechaIngreso,FECHA_INGRESO_REQUERIDA);
        Validator.validarFechaNula(fechaSalida,FECHA_SALIDA_REQUERIDA);
        Validator.validarPlacaNula(placa,PLACA_REQUERIDA);
        Validator.validarPlacaVacia(placa,PLACA_REQUERIDA);
        Validator.validarObjetoNulo(tarifa,TARIFA_NO_CONFIGURADA);
        //Validator.validarValorCero(tarifa.getPrecio(),VALOR_TARIFA_ES_REQUERIDO);
        Validator.validarFechaIgual(fechaIngreso,fechaSalida,FECHA_IGUAL);
        Validator.validarFechaSalidaAntes(fechaIngreso,fechaSalida,FECHA_SALIDA_MENOR);


        this.idMoviento = idMoviento;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.placa = placa;
        this.tarifa = tarifa;
    }

    public double calcularValorTotal() {
        return  tarifa.getPrecio() * DateUtil.minutesDiff(fechaIngreso,fechaSalida);
    }



}

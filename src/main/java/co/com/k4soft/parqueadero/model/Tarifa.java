package co.com.k4soft.parqueadero.model;


import co.com.k4soft.parqueadero.model.util.Validator;

public class Tarifa {


    public static final String VALOR_TARIFA_ES_REQUERIDO = "El precio  es requerido";
    public static final String NOMBRE_REQUERIDO="El nombre es requerido";
    private Integer id;
    private String nombre;
    private double precio;


    public Tarifa(Integer id, String nombre, double precio) {

        Validator.validarValorCero(precio,VALOR_TARIFA_ES_REQUERIDO);
        Validator.validarNombreObligatorio(nombre,NOMBRE_REQUERIDO);

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

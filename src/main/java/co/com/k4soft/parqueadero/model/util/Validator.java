package co.com.k4soft.parqueadero.model.util;


import co.com.k4soft.parqueadero.model.businessexception.BusinessException;

import java.util.Date;

public class Validator {

    public static void validarFechaNula(Date fecha, String mensaje)  {
        if(fecha == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaNula(String placa, String mensaje)  {
        if(placa == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaVacia(String placa, String mensaje) {
        if("".equals(placa)){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarObjetoNulo(Object object, String mensaje)  {
        if(object == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarValorCero(double valor, String mensaje)  {
        if(valor == 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarFechaIgual(Date fechaIngreso,Date fechaSalida,String mensaje){
        if(fechaIngreso.equals(fechaSalida)){
            throw new BusinessException(mensaje);
        }
    }
    public static void validarFechaSalidaAntes(Date fechaIngreso,Date fechaSalida,String mensaje ){
        if (fechaSalida.before(fechaIngreso)){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarNombreObligatorio(String nombre, String mensaje){
        if(nombre==null){
            throw new BusinessException(mensaje);
        }
    }







}

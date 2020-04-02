package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.businessexception.BusinessException;
import co.com.k4soft.parqueadero.model.util.DateUtil;
import co.com.k4soft.parqueadero.testdatabuilder.model.MovimientoBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoTest {


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void crearObjetoSinFechaEntradaTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_INGRESO_REQUERIDA);
        Movimiento movimiento = new MovimientoBuilder()
                .build();
    }


    @Test
    public void crearObjetoSinFechaSalidaTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_SALIDA_REQUERIDA);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(new Date())
                .build();
    }


    @Test
    public void crearObjetoConPlacaNulaTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.PLACA_REQUERIDA);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .build();
    }



    @Test
    public void crearObjetoConPlacaVaciaTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.PLACA_REQUERIDA);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("")
                .build();
    }

    @Test
    public void crearObjetoConTarifaSinConfigurarTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.TARIFA_NO_CONFIGURADA);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("MLG904")
                .build();
    }


    @Test
    public void crearObjetoConTarifaConPrecioCeroTest()  {
        exception.expect(BusinessException.class);
        exception.expectMessage(Tarifa.VALOR_TARIFA_ES_REQUERIDO);
        Movimiento movimiento= new MovimientoBuilder()
                .setIdMoviento(1)
                .setFechaIngreso(new Date())
                .setFechaSalida(new Date())
                .setPlaca("MLG904")
                .setTarifa(new Tarifa(1, "Motocicletas", 0)).build();

    }


    @Test
    public void calcularTarifaMotocicletaTest()  {
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-18 08:00:00");
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTarifa(new Tarifa(1, "Motocicletas", 1500))
                .build();
        double valorReal = movimiento.calcularValorTotal();
        double valorEsperado = 1500;
        Assert.assertEquals(valorEsperado, valorReal, 1);

    }


    @Test
    public void calcularTarifaAutomovilTest()  {
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-18 09:00:00");
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTarifa(new Tarifa(2, "Automóvil", 2500))
                .build();
        double valorReal = movimiento.calcularValorTotal();
        double valorEsperado = 5000;
        Assert.assertEquals(valorEsperado, valorReal, 1);
    }

    @Test
    public void verificarFechaIgualTest(){
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-18 07:00:00");

        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_IGUAL);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTarifa(new Tarifa(1, "Motocicletas", 1500))
                .build();
    }

    @Test
    public void verificarFechaSalidaMenorFechaEntradaTest(){
        Date fechaEntrada = DateUtil.convertStringToDate("2020-02-18 07:00:00");
        Date fechaSalida = DateUtil.convertStringToDate("2020-02-17 07:00:00");

        exception.expect(BusinessException.class);
        exception.expectMessage(Movimiento.FECHA_SALIDA_MENOR);
        Movimiento movimiento = new MovimientoBuilder()
                .setFechaIngreso(fechaEntrada)
                .setFechaSalida(fechaSalida)
                .setPlaca("MLG904")
                .setTarifa(new Tarifa(1, "Motocicletas", 1500))
                .build();
    }

}
package co.com.k4soft.parqueadero.model;

import co.com.k4soft.parqueadero.model.businessexception.BusinessException;

import co.com.k4soft.parqueadero.testdatabuilder.model.TarifaBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TarifaTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public  void validarPrecioTarifaCeroTest(){

        exception.expect(BusinessException.class);
        exception.expectMessage(Tarifa.VALOR_TARIFA_ES_REQUERIDO);
        Tarifa tarifa = new TarifaBuilder().setPrecio(0).build();
    }

    @Test
    public  void validarNombreRequeridoTest(){

        exception.expect(BusinessException.class);
        exception.expectMessage(Tarifa.NOMBRE_REQUERIDO);
        Tarifa tarifa = new TarifaBuilder().setPrecio(200).build();
    }


}

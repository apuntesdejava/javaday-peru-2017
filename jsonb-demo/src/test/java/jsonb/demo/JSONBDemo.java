/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonb.demo;

import com.apuntesdejava.jsonb.demo.Libro;
import java.util.Date;
import java.util.Locale;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class JSONBDemo {

    private JsonbConfig config;

    public JSONBDemo() {
    }

    @Before
    public void setUp() {
        config=new JsonbConfig()
                .withFormatting(true)
                .withDateFormat("dd-MMMM-yyyy", Locale.getDefault())
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES)
                ;
    }

    @After
    public void tearDown() {

    }

    @Test
    public void toJson() {
        System.out.println("--- tojson ---");
        Libro libro = new Libro();
        libro.setAnio(2014);
        libro.setNombre("Los gatos no ladran");
        libro.setIsbn("123-456-789");
        libro.setFechaPublicacion(new Date());
        libro.setPrecio(13456.0);

        String json = JsonbBuilder.create(config).toJson(libro);

        System.out.println("json:" + json);
    }

    @Test
    public void fromJson() {
        System.out.println("--- fromJson ---");
        String json = "{\"nombre\":\"Los gatos caen de pie\",\"anio\":1234 }";

        Libro libro = JsonbBuilder.create().fromJson(json, Libro.class);
        System.out.println("libro:" + libro);
    }

}

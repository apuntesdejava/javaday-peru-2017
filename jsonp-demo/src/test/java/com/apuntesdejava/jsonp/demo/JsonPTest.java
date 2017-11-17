package com.apuntesdejava.jsonp.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonCollectors;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author diego
 */
public class JsonPTest {

    private final String jsonUrl
            = "https://next.json-generator.com/api/json/get/NJjcYQPkV";
    private final String json2Url = "https://next.json-generator.com/api/json/get/EyIl07Dy4";
    private JsonArray json, json2;

    public JsonPTest() {
    }

    @Before
    public void before() throws MalformedURLException, IOException {
        json = getJson(jsonUrl);
        json2 = getJson(json2Url);

    }

    @Test
    public void testPointer() throws FileNotFoundException, IOException {
        JsonValue data = Json.createPointer("/3/name/last").getValue(json);
        System.out.println("data:" + data);

        JsonArray val = Json.createPointer("/0/company")
                .replace(json, Json.createValue("Bienvenidos a Java Day"));

        save("json-pointer.json", val);

    }

    @Test
    public void testPatch() throws IOException {
        JsonArray val = Json.createPatchBuilder()
                .replace("/0/age", 41)
                .copy("/1", "/2")
                .move("/3", "/4")
                .build()
                .apply(json);
        save("json-patch.json", val);
    }

    @Test
    public void testJsonCollectors() {
        JsonArray tags = ((JsonObject) json2.get(1)).getJsonArray("tags")
                .stream().filter(tag -> ((JsonString) tag).getString().startsWith("e"))
                .collect(JsonCollectors.toJsonArray());
        tags.forEach((x) -> {
            System.out.println("-->" + x);
        });
    }

    private void save(String fileName, JsonStructure json) throws FileNotFoundException, IOException {
        try (OutputStream os = new FileOutputStream(fileName);
                JsonWriter jsonWriter = Json.createWriter(os)) {
            jsonWriter.write(json);
        }
    }

    private JsonArray getJson(String jsonUrl) throws MalformedURLException, IOException {
        String jsonStr = new Scanner(new URL(jsonUrl)
                .openStream(), "UTF-8").useDelimiter("\\A").next();
        try (Reader reader = new StringReader(jsonStr)) {
            JsonReader jsonReader = Json.createReader(reader);
            return jsonReader.readArray();
        }

    }

}

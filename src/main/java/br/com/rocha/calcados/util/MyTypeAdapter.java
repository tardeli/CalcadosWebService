package br.com.rocha.calcados.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 *
 * @author DaRocha
 */
public class MyTypeAdapter <T> extends TypeAdapter<T>{

    @Override
    public void write(JsonWriter writer, T t) throws IOException {
        if (t == null) {
            writer.nullValue();
            return;
        }
        writer.value(t.toString());
    }

    @Override
    public T read(JsonReader reader) throws IOException {
        return null;
    }
     
}

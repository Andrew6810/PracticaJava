import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "Title": "Inception",
                    "Year": "2010",
                    "Runtime": "148min"
                }
                """;

        System.out.println(json);

        //convertir JSON a objeto Record
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES)
                .create();

        Pelicula pelicula1 = gson.fromJson(json, Pelicula.class);

        System.out.println(pelicula1);

    }
}
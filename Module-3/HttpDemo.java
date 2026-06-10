import java.net.URI;
import java.net.http.*;
public class HttpDemo {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req =
                HttpRequest.newBuilder()
                        .uri(new URI("https://api.github.com"))
                        .build();
        HttpResponse<String> res =
                client.send(req,
                        HttpResponse.BodyHandlers.ofString());
        System.out.println(res.statusCode());
        System.out.println(res.body());
    }
}
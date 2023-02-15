import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();
            HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=qbWIscojcbFTrSJyOpdBMx3JwUlOd08ULkFH4X2u");
            CloseableHttpResponse response = httpClient.execute(request);
            InputStream contentStream = response.getEntity().getContent();
            var strResponse = new String(contentStream.readAllBytes());
            NasaInfo nasaInfo = new ObjectMapper().readValue(strResponse, new TypeReference<>() {
            });
            request = new HttpGet(nasaInfo.getUrl());
            response = httpClient.execute(request);
            byte[] picture = response.getEntity().getContent().readAllBytes();
            try (FileOutputStream outputStream = new FileOutputStream(new File("NasaDailyPicture.jpg"))) {
                outputStream.write(picture);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

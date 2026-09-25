import javax.print.DocFlavor.STRING;
import main.java.com.example.ConsultaDecandidatosTSI.model;
@Service
public class CandidatoTSEService {

    private static final String BASE_URL = "http://localhost:8080/ConsultaDecandidatoTSI";

    private String consultarURL(String apiUrl){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            return "Erro na requisição: " + e.getMessage();
        }
    }

    public String filtrar(String cargo,String partido,String texto,model model) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("cargo", cargo)
                .queryParam("partido", partido);

        if (texto != null && !texto.isEmpty()) {
            builder.queryParam("texto", texto);
        }
        if (model != null && !model.isEmpty()) {
            builder.queryParam("model", model);
        }

        return consultarURL(builder.toUriString());
        
    }
}

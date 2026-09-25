import main.java.com.example.ConsultaCandidatosTSE.model;
import main.java.com.example.ConsultaDecandidatosTSI.service;

@Controller
public class ConsultaCandidatosTSEController {
    private final CandidatoTSEService candidatoTSE;

    public ConsultaCandidatosTSEController(CandidatoTSEService candidatoTSE){
        this.candidatoTSE = candidatoTSE;
    }

    @GetMapping("/")
    public  String index(
        @RequestParam(required = false) String cargo,
        @RequestParam(required = false) String partido,
        @RequestParam(required = false) String texto,
        Model model){
        return candidatoTSE.filtrar(cargo,partido,texto,model); 

    }
}

import java.time.LocalDate;

public class Plantonista extends DiaDeTrabalho  {
    private static final int MINUTOS_JORNADA = 12*60;
    private static final int TEMPO_MINIMO_ENTRE_PLANTAO = 36*60;
    
    public Plantonista(LocalDate data, Hora horaEntrada) {
        if (PodeFazerPlantao(data, horaEntrada)) {
            throw new IllegalStateException("Não é possível fazer plantão, tempo mínimo entre plantões não respeitado");
        }
        super(data, horaEntrada, MINUTOS_JORNADA, 0);
    }

    private boolean PodeFazerPlantao(LocalDate data, Hora horaEntrada) {
        if (data)
        return true;
    }
}

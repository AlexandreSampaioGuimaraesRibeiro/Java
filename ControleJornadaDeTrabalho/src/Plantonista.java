import java.time.LocalDate;

public class Plantonista extends DiaDeTrabalho  {
    private static final int MINUTOS_JORNADA = 12*60;
    private static final int TEMPO_MINIMO_ENTRE_PLANTAO = 36*60;
    private static final int TOLERANCA = 5;
    private Hora proxInicio;
    
    public Plantonista(Hora horaEntrada) {
        if (pronInicio.estaNaFrente(horaEntrada)) {
            throw new IllegalStateException("Não é possível fazer plantão, tempo mínimo entre plantões não respeitado");
        }
        localDate data = LocalDate.now();
        super(data, horaEntrada, MINUTOS_JORNADA,horaEntrada.incrementar(MINUTOS_JORNADA));
    }

    @Override
    public Hora registrarSaida(Hora saida){
        if(horaSaida !=null || horaEntrada.estaNaFrente(saida)){
            throw new IllegalArgumentException("Hora de saída inválida ou jornada já finalizada");
        }
        int saldo = saida.diferenciaEmMinutos(horaEntrada) - MINUTOS_JORNADA;
        if(saldo > TOLERANCA){
            throw new IllegalStateException("Tempo de tolerância excedido");
        }
        horaSaida = saida;
        proxInicio = horaSaida.incrementar(TEMPO_MINIMO_ENTRE_PLANTAO);
        return proxInicio;
    }
}

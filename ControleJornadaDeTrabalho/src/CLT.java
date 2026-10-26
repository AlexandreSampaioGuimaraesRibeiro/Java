import java.time.LocalDate;


public class CLT extends DiaDeTrabalho {
    private static final Hora INICIO = Hora.parse("07:30:00");
    private static final int MAX_EXTRA = 2*60;
    private int saldoHorasExtras;
    private static final int MINUTOS_JORNADA = 8*60;
    private static final int MINUTOS_ALMOCO = 60;
    private static final int MULTP_EXTRAS = 2;

    public CLT(Hora horaEntrada) {
        if (horaEntrada.estaNaFrente(INICIO)) {
            throw new IllegalArgumentException("Hora de entrada inválida");
        }
        localDate data = LocalDate.now();
        Hora saidaProgramada = horaEntrada.incrementar(MINUTOS_JORNADA + MINUTOS_ALMOCO);
        super(data, horaEntrada, MINUTOS_JORNADA, MINUTOS_ALMOCO, saidaProgramada);
    }

    @Override
    public Hora registrarSaida(Hora Saida) {
        if(horaSaida !=null || horaEntrada.estaNaFrente(Saida)){
            throw new IllegalArgumentException("Hora de saída inválida ou jornada já finalizada");
        }
        int saldo = Saida.diferenciaEmMinutos(horaEntrada) - minutosJonada - minutosAlmoco;
        if(saldo > MAX_EXTRA){
            saldo = MAX_EXTRA;
        }
        if(saldo>0){
            saldo*= MULTP_EXTRAS;
        }
        saldoHorasExtras = saldo;
        return saida;
    }



    
}

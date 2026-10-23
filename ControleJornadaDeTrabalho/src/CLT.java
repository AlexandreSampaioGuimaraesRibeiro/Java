import java.time.LocalDate;


public class CLT extends DiaDeTrabalho {
    private static final Hora inicioJornada = Hora.parse("07:30:00");
    private static final int limiteHorasExtrasDiarias = 2*60;
    private int saldoHorasExtras;
    private static final int MINUTOS_JORNADA = 8*60;
    private static final int MINUTOS_ALMOCO = 60;

    public CLT(LocalDate data, Hora horaEntrada) {
        super(data, horaEntrada, MINUTOS_JORNADA, MINUTOS_ALMOCO);
    }

    @Override
    protected Hora registrarSaida(Hora horaSaida) {
        super.registrarSaida(horaSaida);
        saldoHorasExtras = Math.min(super.retornaSaldoMinutos(), limiteHorasExtrasDiarias);
        return this.horaSaida;
    }



    
}

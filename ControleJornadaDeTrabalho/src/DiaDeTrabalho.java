abstract public class DiaDeTrabalho {
    private static final int MINUTOS_JORNADA = 8 * 60;
    private static final int MINUTOS_ALMOCO = 60;
    private LocalDate data;
    private Hora horaEntrada;
    private Hora horaSaida;
    private int saldoMinutos;

    public DiaDeTrabalho(LocalDate data, Hora horaEntrada) {
        this.data = data;
        this.horaEntrada = horaEntrada;
       
        
    }

    public Hora registrarSaida(Hora horaSaida) {
        this.horaSaida = horaSaida;
        return this.horaSaida;
    }

    public int retornaSaldoMinutos() {
        saldoMinutos = horaSaida.diferenciaEmMinutos(horaEntrada) - MINUTOS_JORNADA - MINUTOS_ALMOCO;
        return saldoMinutos;
    }

    public boolean finalizado() {
        return horaSaida != null;
    }
}

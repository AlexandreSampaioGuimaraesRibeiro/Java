public class App {

    public int lerNumero(String mensagem){ 
        int resposta = Integer.parseInt(IO.readln(mensagem));
        return resposta;
    }

    private void cabecalho() {
        IO.println("===================================");
        IO.println("Controle de Jornada de Trabalho");
        IO.println("===================================");
    }
    public void main(String[] args) throws Exception {
        cabecalho();
        int opcao = 0;
        while(opcao != 5){
            IO.println("1 - Registrar entrada CLT");
            IO.println("2 - Registrar entrada PJ");
            IO.println("3 - Registrar entrada Plantonista");
            IO.println("4 - Registrar saída");
            IO.println("5 - Sair");
            opcao = lerNumero("Escolha uma opção: ");
            switch(opcao){
                case 1 -> registrarEntradaCLT();                    
                case 2 -> registrarEntradaPJ();
                case 3 -> registrarEntradaPlantonista(); 
                case 4 -> registrarSaida(); // Implementar lógica para registrar saída
                case 5 -> IO.println("Saindo do sistema...");
                default -> IO.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

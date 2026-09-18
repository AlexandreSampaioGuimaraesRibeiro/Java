import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

 
public class CampeonatoTest {
    Campeonatos campeonato = new Campeonatos("Campeonato Teste", 2, Arrays.asList("Equipe A", "Equipe B"));
    Partida partida;
    @Test
    public void novaPartida() {
        //Arrange
        
        //Act
        partida = campeonato.partida();
        //Assert
        assertEquals(0, partida.mandante.golsMarcados);
    }
}
import com.canofederico.validadorcorrelatividades.classes.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MateriaTest {

    @Test
    @DisplayName("Test para obtener listado de correlativas")
    void testObtenerListadoCorrelativasCompleto() {

        Materia materia1 = new Materia("Analisis I", List.of());
        Materia materia2 = new Materia("Analisis II", List.of(materia1));
        Materia materia3 = new Materia("Probabilidad y Estadistica", List.of(materia1));
        Materia materia4 = new Materia("Matematica Superior", List.of(materia2, materia3));

        assertEquals(3, materia4.obtenerListadoCorrelativasCompleto().size());
        assertTrue(materia4.obtenerListadoCorrelativasCompleto().containsAll(List.of(materia1, materia2, materia3)));
    }
}

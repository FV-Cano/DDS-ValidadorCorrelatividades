import com.canofederico.validadorcorrelatividades.classes.Alumno;
import com.canofederico.validadorcorrelatividades.classes.Inscripcion;
import com.canofederico.validadorcorrelatividades.classes.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InscripcionTest {

    private Materia materia1, materia2, materia3, materia4;

    @BeforeEach
    void setUp() {
        materia1 = new Materia("Análisis I", List.of());
        materia2 = new Materia("Análisis II", List.of(materia1));
        materia3 = new Materia("Probabilidad y Estadística", List.of(materia1));
        materia4 = new Materia("Matemática Superior", List.of(materia2, materia3));
    }

    @Test
    @DisplayName("Inscripción aprobada cuando el alumno cumple con las correlativas necesarias")
    void testInscripcionAprobada() {
        Alumno alumno1 = new Alumno("Federico", List.of(materia1, materia2, materia3));
        Inscripcion inscripcion = new Inscripcion(alumno1, List.of(materia4));

        assertTrue(inscripcion.aprobada(), "El alumno cumple con los requisitos de correlativas");
    }

    @Test
    @DisplayName("Test para inscripción rechazada por no cumplir con correlativas")
    void testInscripcionRechazada_Correlativas() {
        Alumno alumno1 = new Alumno("Federico", List.of(materia1, materia2));
        Inscripcion inscripcion = new Inscripcion(alumno1, List.of(materia4));

        assertFalse(inscripcion.aprobada(), "El alumno NO cumple con los requisitos de correlativas");
    }

    @Test
    @DisplayName("Test para inscripción rechazada por inscribirse a materia ya aprobada")
    void testInscripcionRechazada_MateriaAprobada() {
        Alumno alumno1 = new Alumno("Federico", List.of(materia2));
        Inscripcion inscripcionP = new Inscripcion(alumno1, List.of(materia2, materia3));

        assertFalse(inscripcionP.aprobada(), "El alumno no debería poder inscribirse a una materia ya aprobada");
    }
}

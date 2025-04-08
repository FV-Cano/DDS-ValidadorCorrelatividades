package com.canofederico.validadorcorrelatividades.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> listaMaterias;

    public boolean aprobada() {
        List<Materia> materiasAprobadas = alumno.getMateriasAprobadas();
        Set<Materia> materiasNecesarias = new HashSet<>();

        // Corrobora si el alumno quiere realizar una inscripción a una materia que ya aprobó
        if (listaMaterias.stream().anyMatch(materiasAprobadas::contains)) {
            System.out.println("El alumno ya aprobó una de las materias que desea inscribir.");
            return false;
        }

        for (Materia materia : listaMaterias) {
            materiasNecesarias.addAll(materia.obtenerListadoCorrelativasCompleto());
        }

        return new HashSet<>(materiasAprobadas).containsAll(materiasNecesarias);
    }
}

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
public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Set<Materia> obtenerListadoCorrelativasCompleto() {
        Set<Materia> listadoCorrelativas = new HashSet<>();
        agregarCorrelativasAListado(this, listadoCorrelativas);
        return listadoCorrelativas;
    }

    private void agregarCorrelativasAListado(Materia materia, Set<Materia> listadoCorrelativas) {
        for (Materia correlativa : materia.getCorrelativas()) {
            if (listadoCorrelativas.add(correlativa)) {
                agregarCorrelativasAListado(correlativa, listadoCorrelativas);
            }
        }
    }
}


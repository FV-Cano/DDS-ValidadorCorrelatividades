package com.canofederico.validadorcorrelatividades.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alumno {
    private String nombre;
    private List<Materia> materiasAprobadas;
}

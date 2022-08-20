package com.example.sistemaempresa;

import java.util.Arrays;
import java.util.List;

public class Cargo {

 List<String> cargos = Arrays.asList("Gerente", "Promotor", "Tesoureiro", "Vendedor");

    public List<String> getCargos() {
        return cargos;
    }

    public void setCargos(List<String> cargos) {
        this.cargos = cargos;
    }
}

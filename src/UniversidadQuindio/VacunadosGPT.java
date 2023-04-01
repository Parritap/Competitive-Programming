package UniversidadQuindio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VacunadosGPT {
    List<Departamento> listaDepartamentos;

    long cantidadInfantesPorSexo(Sexo sexo) {
        return listaDepartamentos.stream()
                .flatMap(d -> d.listaCiudades.stream())
                .flatMap(c -> c.listaInfantes.stream())
                .filter(i -> i.sexo == sexo)
                .count();
    }

    String cantidadInfantesPorDepartamento() {
        return listaDepartamentos.stream()
                .map(d -> d.nombre + " : " + d.getPoblacion())
                .collect(Collectors.joining("\n"));
    }

    long cantidadInfantesPais() {
        return listaDepartamentos.stream()
                .flatMap(d -> d.listaCiudades.stream())
                .flatMap(c -> c.listaInfantes.stream())
                .count();
    }

    String ciudadesEnQueSeVacuno() {
        return listaDepartamentos.stream()
                .map(d -> d.nombre + ": "
                        + d.ciudadesEnQueSeVacuno().stream()
                        .map(c -> c.nombre)
                        .collect(Collectors.joining(", "))
                )
                .collect(Collectors.joining("\n"));
    }

    class Departamento {
        String nombre;
        List<Ciudad> listaCiudades;

        int getPoblacion() {
            return listaCiudades.stream()
                    .mapToInt(c -> c.listaInfantes.size())
                    .sum();
        }

        List<Ciudad> ciudadesEnQueSeVacuno() {
            return listaCiudades.stream()
                    .filter(Ciudad::seVacuno)
                    .collect(Collectors.toList());
        }
    }

    class Ciudad {
        String nombre;
        List<Infante> listaInfantes;

        boolean seVacuno() {
            return listaInfantes.stream()
                    .anyMatch(i -> i.estaVacunado);
        }
    }

    class Infante {
        String nombre;
        Sexo sexo;
        boolean estaVacunado;
    }

    enum Sexo {
        M, F;
    }
}


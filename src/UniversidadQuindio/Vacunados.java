package UniversidadQuindio;

import java.util.ArrayList;
import java.util.Arrays;


public class Vacunados {
    ArrayList<Departamento> listaDepartamentos;

    int cantidadInfantesMasculinos() {
        int aux = 0;
        for (Departamento d :listaDepartamentos) {
            for (Ciudad c : d.listaCiudades) {
                for (Infante i : c.listaInfantes) {
                    if (i.sexo == Sexo.M) aux++;
                }
            }
        }
        return aux;
    }

    int cantidadInfantesFemeninos() {
        int aux = 0;
        for (Departamento d :listaDepartamentos) {
            for (Ciudad c : d.listaCiudades) {
                for (Infante i : c.listaInfantes) {
                    if (i.sexo == Sexo.F) aux++;
                }
            }
        }
        return aux;
    }


    String cantidadInfantesPorDepartamento () {
        StringBuilder str = new StringBuilder();
        for (Departamento d: listaDepartamentos){
            str.append(d.nombre).append(" : ").append(d.getPoblacion());
        }
        return str.toString();
    }

    int cantidadInfantesPais (){
        int i = 0;
        for (Departamento d: listaDepartamentos){
            i+=d.getPoblacion();
        }
        return i;
    }

    String ciudadesEnQueSeVacuno (){
        String str = new String();
        for (Departamento d: listaDepartamentos) {
            str+= d.nombre +": ";
            for (Ciudad c : d.listaCiudades)
                 if (c.seVacuno()) {
                    str+= c.nombre + ", ";
            }
            str+="\n";
        }
        return str;
    }


    class Departamento {
        String nombre;
        public ArrayList<Ciudad> listaCiudades;

        int getPoblacion (){
            int i =0;
            for (Ciudad c : listaCiudades) {
                i+=c.listaInfantes.size();
            }
            return i;
        }

        ArrayList<Ciudad> ciudadesEnQueSeVacuno (){
            ArrayList<Ciudad> l = new ArrayList<>();
            for (Ciudad c : listaCiudades) {
                if (c.seVacuno()) l.add(c);
            }
            return l;
        }

    }

    class Ciudad {
        String nombre;
        ArrayList<Infante> listaInfantes;

        boolean seVacuno (){
            for (Infante i: listaInfantes) {
                if (i.estaVacunado) return true;
            }
            return false;
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

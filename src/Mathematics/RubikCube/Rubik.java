package Mathematics.RubikCube;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

class Rubik {
    Edge[] edges = new Edge[12];
    Corner[] corners = new Corner[8];
    ArrayList<Integer> upperPositions = new ArrayList<>(Arrays.asList(0,1,2,3));



    public static void main(String[] args) {
        Rubik rubik = new Rubik();
        String s = Arrays.toString(rubik.edges);
        System.out.println(s);
    }

    public Rubik() {
        //Se inicializan las 8 esquinas.
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) corners[i] = new Corner(i, i, AXIS.Y); //Positive y axis.
            else corners[i] = new Corner(i, i, AXIS._y); //Negative y axis.
        }

        for (int i = 0; i < 12; i++) {
            if (i < 8) {
                if (i % 2 == 0) edges[i] = new Edge(i, i, AXIS.Y); //Positive y axis.
                else edges[i] = new Edge(i, i, AXIS._y); //Negative y axis.
            } else {
                switch (i) {
                    case 8 -> edges[i] = new Edge(i, i, AXIS.Z);
                    case 9 -> edges[i] = new Edge(i, i, AXIS.Z);
                    case 10 -> edges[i] = new Edge(i, i, AXIS._z);
                    case 11 -> edges[i] = new Edge(i, i, AXIS._z);
                }
            }
        }
    }


    void moveCorner (Corner corner){
        if (corner.getPos()==0){

        }
    }

    void move_F (){

    }

    boolean cornerIsUp (Corner corner){
        return upperPositions.contains(corner.pos);
    }
}

class Edge {
    int id;
    int pos; //Number between 0 and 11
    AXIS axis;


    public Edge(int id, int pos, AXIS axis) {
        this.id = id;
        this.pos = pos;
        this.axis = axis;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public AXIS getAxis() {
        return axis;
    }

    public void setAxis(AXIS axis) {
        this.axis = axis;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", pos=" + pos +
                ", axis=" + axis +
                '}';
    }
}

class Corner {
    int id;
    int pos;//Number between 1 and 8
    AXIS axis;

    public Corner(int id, int pos, AXIS axis) {
        this.id = id;
        this.pos = pos;
        this.axis = axis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public AXIS getAxis() {
        return axis;
    }

    public void setAxis(AXIS AXIS) {
        this.axis = AXIS;
    }

    @Override
    public String toString() {
        return "Corner{" +
                "id=" + id +
                ", pos=" + pos +
                ", axis=" + axis +
                '}';
    }
}

enum AXIS {
    X, _x, Y, _y, Z, _z;
}

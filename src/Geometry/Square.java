
public class Square {

  int h;
  int w;
  static final String nombre = "Rigby";

  public Square (int h, int w) {
    this.h = h; this.w = w;
  }

  public static void main(String[] args) {
    Square rec = new Square(3,4);
    int res1 = rec.getArea();


   // int res1 = Square.getArea(7,10);
    System.out.println(res1);
   //Square.printName();
  }


 //Función no estática
 int getArea (){
  System.out.println(nombre);
   return (this.h * this.w);
 }

 // Funcion estática
 //static int getArea(int h, int w){
 //   return (h * w);
 // }

  static void printName () {
    System.out.println(nombre);
  }
} 

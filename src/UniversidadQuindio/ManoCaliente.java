public class ManoCaliente {

    public static void main(String[] args) {
        String str = "11110001101101111111100111"; //Aqui hay 3 manos calientes;
        int manos = calcular_N_ManosCalientes(str);
       // System.out.println(manos);

        String partidos  =
				"11000001011000111110100100101100110011010110001010\n" +
                "101001111100000100011100000111111010000111010010010101\n" +
                "111101000000100001100100011100001100100000110\n" +
                "1000000110111011101101001000001111101111011011100111111\n"+
						"1111011011001111010110\n"+"1111111111111111111111";

		int manos2 = calcular_N_ManosCalientes(partidos);
		String[] arrPartidos = partidos.split("\n");

		//for (String p : arrPartidos){
		//	System.out.println(calcular_N_ManosCalientes(p));
		//}

		System.out.println(calcularPorcentajeManosCalientes(partidos));


    }

    public static int calcular_N_ManosCalientes(String str) {
        int manosCalientes = 0;
        boolean bool;
        int counter = 0;
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '1') counter++;

            if (array[i] == '0') {
				if (counter > 4) manosCalientes++;
				counter = 0;
			}
        }
        return manosCalientes;
    }


    static float calcularPorcentajeManosCalientes(String str) {
        String[] partidos = str.split("\n");


        float i = 0;
        for (String s : partidos) {
			//System.out.println(s);
			//System.out.println(calcular_N_ManosCalientes(s));
            if (calcular_N_ManosCalientes(s) > 0) i++;
        }
//		System.out.println(i);
        float unit = (float) partidos.length / 100;
        return (float) ((i / partidos.length))*100;
    }
}
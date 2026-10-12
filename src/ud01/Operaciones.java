package ud01;

public class Operaciones {
	public static void main(String[] args) {
		int operandoA=10;
		int operandoB=5;
		
		System.out.println("El operando A es: " +operandoA);
		System.out.println("El operando B es: " +operandoB);
		
		System.out.println(operandoA+" + "+operandoB+" = "+(operandoA+operandoB));
		System.out.println(operandoA+" - "+operandoB+" = "+(operandoA-operandoB));
		System.out.println(operandoA+" * "+operandoB+" = "+(operandoA*operandoB));
		System.out.println(operandoA+" / "+operandoB+" = "+(operandoA/operandoB));
		System.out.println(operandoA+" % "+operandoB+" = "+(operandoA%operandoB));
		
		int resultadosuma;
		int resultadoresta;
		int resultadomulti;
		
		resultadosuma=operandoA+operandoB;
		resultadoresta=operandoA-operandoB;
		resultadomulti=resultadosuma*resultadoresta;
		System.out.println("El resultadosuma opA+opB es: " +resultadosuma);
		System.out.println("El resultadoresta opA-opB es: " +resultadoresta);
		System.out.println("El resultadomulti resultadosuma*resultadoresta es: " +resultadomulti);
	
		System.out.println(resultadosuma+" * "+resultadoresta+" = "+(resultadosuma*resultadoresta));
		System.out.println(resultadomulti);
		
		System.out.println("El operando A es: " +operandoA);
		System.out.println("El operando B es: " +operandoB);
		operandoA++;
		System.out.println("El operando A + 1 (OperandoA++) es: "+operandoA);
		operandoB--;
		System.out.println("El operando B - 1 (OperandoB--) es: " +operandoB);
		System.out.println("Ahora el operando A es: " +operandoA);
		System.out.println("Ahora el operando B es: " +operandoB);
	}

}

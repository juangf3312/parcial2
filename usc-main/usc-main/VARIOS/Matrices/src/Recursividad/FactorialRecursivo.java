package Recursividad;

public class FactorialRecursivo {
	
	public int devuelveFactorialRecursiva(int n) {
	// Esto es un m�todo recursivo

        int resultado;
        if (n==1) return 1;
        resultado=devuelveFactorialRecursiva(n-1)*n;
        return resultado;
    }
  
    
}

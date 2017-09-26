/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

/**
 *
 * @author Manuel
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 1989;
        int b = 867;   
        int res = 0;
        
        res = gcdPrimeFactors(a,b);
        System.out.print("Result PF: " + res + "\n");
        res = gcdEucledian(a,b);        
        System.out.print("Result EU: " + res + "\n");
    }
    
    public static int gcdPrimeFactors(int a, int b)
    {
        int prime1 = 2;
        int prime2 = 2;
        int res = 1;
        
        while(a > 1 || b > 1)
        {
            while(a % prime1 != 0 && a > 1)
                prime1 = getNextPrimeNumber(prime1);
            while(b % prime2 != 0 && b > 1)
                prime2 = getNextPrimeNumber(prime2);
            
            a = a / prime1;
            b = b / prime2;
            if(prime1 == prime2)
                    res *= prime1;
        }
        return res;
    }
    
    public static int getNextPrimeNumber(int number)
    {
        do
            number++;
        while(!isPrime(number));
        return number;
            
    }
    public static boolean isPrime(int numberToBeChecked)
    {
        for (int i = 2; i <= numberToBeChecked / 2; i++) 
        {
            if(numberToBeChecked % i == 0)
                return false;
        }      
        return true;
    }
    
    public static int gcdEucledian(int a, int b)
    {             
        return a % b != 0 ? gcdEucledian(b,a%b) : b;
    }
}

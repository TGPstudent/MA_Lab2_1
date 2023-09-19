//Програма заповнення одновимірного масиву, його сортування та вилучення дублікатів
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

public class Main
{
    public static int Inp_N ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введи кількість елементів n в векторі A[n]:");
        int n = sc.nextInt();
        return (n);
    }
    public static void ArgGenerator(int[] A)//Генерування елементів вектору
    {
        Random random = new Random();
        // A= random.nextBytes(byte[] buf);
        for (int i = 0; i < A.length; i++)
        {
            A[i] = (int) random.nextInt(200+1);
        }
    }
    public static void ArgPrint (int[] A)
    {
        System.out.print("A ={");
        for (int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+", ");
        }
        System.out.print("\b\b}\n");
    }
    public static void Sort (int[] A)
    {
        int buf;
        boolean isSorted = false;
        while(!isSorted)
        {
            isSorted = true;
            for (int i = 0; i < A.length-1; i++)
            {
                if (A[i] > A[i + 1])
                {
                    isSorted = false;
                    buf = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = buf;
                }
            }
        }
    }
    public static int[] ArgDelDub (int[] A)
    {
        for(int i=0; i<A.length-1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j])
                {
                    A = ArrayUtils.remove(A,j);

                }
            }
        }
        return (A);
    }

    public static void main(String[] args)
    {
        int n = Inp_N();
        int[] A = new int[n];
        ArgGenerator (A);
        System.out.print("Вектор розміром " + n + " згенеровано: ");
        ArgPrint(A);

        Sort (A);
        System.out.print("Відсортований за зростанням вектор: ");
        ArgPrint(A);

        A=ArgDelDub(A);
        System.out.print("Вектор з влученими повторами: ");
        ArgPrint(A);
    }
}

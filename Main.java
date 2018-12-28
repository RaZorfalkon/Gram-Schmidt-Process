import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int dimension = GetDimension(scanner);

        ArrayList<Vector<Double>> vectors = GetVectorInput(dimension, scanner);

        ArrayList<Vector<Double>> outVectors = Algorithm.Calculate(vectors);
        
        PrintOutput(outVectors, dimension);
    
        scanner.close();
    }

    private static int GetDimension(Scanner scanner) {
       
        System.out.print("Set Dimension: ");       
        return Integer.parseInt(scanner.nextLine());
    }

    private static ArrayList<Vector<Double>> GetVectorInput(int dimension, Scanner scanner) {
        
        ArrayList<Vector<Double>> vectors = new ArrayList<Vector<Double>>();

        int x = 0;
        while(x < dimension)
        {           
            System.out.printf("Insert %d. Vector in the following format: '1,2,...': ", x + 1);

            String line = scanner.nextLine();

            if(!Pattern.matches("^[-+]?[0-9]+,[-+]?[0-9]+,[-+]?[0-9]+$", line))
            {
                System.out.println("Input in wrong format!");
                continue;
            }

            Vector<Double> vec = new Vector<Double>(dimension);
            String[] str = line.split(",");
            
            for (String s : str)
            {
                vec.add(Double.parseDouble(s));            
            }
    
            vectors.add(vec);
            x++;
        }
        return vectors;
    }

    private static void PrintOutput(ArrayList<Vector<Double>> outVectors, int dimension) {
        System.out.println();
        for (int i = 0; i < dimension; i++) {

            for (int k = 0; k < outVectors.size(); k++) {
                System.out.printf("%7.3f ", outVectors.get(k).get(i));
            }
            System.out.println();
        }
    }
}
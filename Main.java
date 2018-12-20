import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int dimension = 0;
        ArrayList<Vector<Double>> vectors = new ArrayList<Vector<Double>>();

        System.out.print("Set Dimension: ");
        
        dimension = Integer.parseInt(scanner.nextLine());

        int x = 0;
        while(x < dimension)
        {           
            System.out.printf("Insert %d. Vector in the following format: '1,2,...': ", x + 1);

            String line = scanner.nextLine();

            if(!Pattern.matches("^[-+]?[0-9]+,[-+]?[0-9]+,[-+]?[0-9]+$", line))
            {
                System.out.println("Wrong input!");
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
      
        ArrayList<Vector<Double>> outVectors = Algorithm.Calculate(vectors);
        
        PrintOutput(outVectors, dimension);
    
        scanner.close();
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
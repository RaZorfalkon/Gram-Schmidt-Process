import java.util.ArrayList;
import java.util.Vector;

/**
 * Algorithm
 */
public class Algorithm 
{
    public static ArrayList<Vector<Double>> Calculate(ArrayList<Vector<Double>> inVectors) 
    {
        ArrayList<Vector<Double>> outVectors = new ArrayList<Vector<Double>>();
        
        for(int outerIndex = 0; outerIndex < inVectors.size(); outerIndex++)
        {
            if(outerIndex == 0)
            {     
                outVectors.add(Normalize(inVectors.get(outerIndex)));
                continue;
            }
            
            Vector<Double> vec = inVectors.get(outerIndex);
            //Vector<Double> SubSumVector = new Vector<Double>();

            //for (int i = 0; i < vec.size(); i++) {
            //    SubSumVector.add(0.0);
            //}

            for (int innerIndex = 0; innerIndex < outerIndex; innerIndex++) 
            {
                Vector<Double> SubVector = GetSubVector(innerIndex, outerIndex, inVectors, outVectors);

                vec = GetSubtractedVector(vec, SubVector);
            }     
            outVectors.add(Normalize(vec));
        }
        return outVectors;
    }

    private static Vector<Double> GetSubVector(int innerIndex, int outerIndex, ArrayList<Vector<Double>> inVectors, ArrayList<Vector<Double>> outVectors)
    {
        double scalar = CalcScalar(outVectors.get(innerIndex), inVectors.get(outerIndex));
        double mag = CalcScalar(outVectors.get(innerIndex), outVectors.get(innerIndex)); 

        double div = scalar / mag;
        
        Vector<Double> vec = new Vector<Double>();

        for (int i = 0; i < outVectors.get(innerIndex).size(); i++) {
            // Axthelm mit nur Skalar
            vec.add(outVectors.get(innerIndex).get(i) * scalar);
        }  
        return vec;
    }

    private static Vector<Double> GetSubtractedVector(Vector<Double> first, Vector<Double> second)
    {
        Vector<Double> vec = new Vector<Double>();

        for (int i = 0; i < first.size(); i++) {
            vec.add(first.get(i) - second.get(i));
        }
        return vec;
    }

    private static double CalcScalar(Vector<Double> vec1, Vector<Double> vec2)
    {
        double scalar = 0;

        for (int i = 0; i < vec1.size(); i++)
        {
            scalar += vec1.get(i) * vec2.get(i);
        }

        return scalar;
    }  

    private static Vector<Double> Normalize(Vector<Double> vec)
    {
        Vector<Double> nVec = new Vector<Double>();
        double d = 0;

        for (double var : vec) {
            d += Math.pow(var, 2);
        }

        double scalar = 1 / Math.sqrt(d);

        for (double v : vec) {
            nVec.add(v * scalar);
        }

        return nVec;
    }
}
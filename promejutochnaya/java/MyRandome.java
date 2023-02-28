import java.util.Arrays;
import java.util.Random;

public class MyRandome {
    
        /// <summary>
        /// Возвращает случайное число из массива vals с вероятностью из массива probs
        /// </summary>
        /// <param name="vals"></param>
        /// <param name="probs"></param>
        /// <returns></returns>
        public static int GetRandom(ToyListInMachine list)
        {
            int[] vals = getVals(list);
            double[] probs = getProbs(list);

            double[] vers = new double[probs.length];
            double sum = Arrays.stream(probs).sum();
            
            vers[0] = probs[0]/ sum;
            for (int i = 1; i < vers.length-1; i++)
            {
                vers[i] = probs[i] / sum + vers[i - 1];
            }
            vers[vers.length - 1] = 1.0;
 
            double rndval = new Random().nextDouble();
            for (int i = 0; i < vers.length; i++)
                if (vers[i] >= rndval)
                    return vals[i];
            return vals[vals.length - 1];
        }

        private static double[] getProbs(ToyListInMachine list){
            double[] probs = new double[list.size()];
            for (int i = 0; i < probs.length; i++){
                probs[i] = list.get(i).getWeight();
            }
            return probs;
        }

        private static int[] getVals(ToyListInMachine list){
            int[] vals = new int[list.size()];
            for (int i = 0; i < vals.length; i++){
                vals[i] = i;
            }
            return vals;
        }






}

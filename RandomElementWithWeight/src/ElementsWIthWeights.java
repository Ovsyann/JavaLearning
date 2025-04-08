public class ElementsWIthWeights {

    private final int[] extended_values;
    private int sum = 0;

    public ElementsWIthWeights(int[] values, int[] weights) {

        for(int weight : weights){
            sum += weight;
        }

        extended_values = new int[sum];
        int valuesCursor = 0;
        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < weights[i]; j++){
                extended_values[valuesCursor++] = values[i];
            }
        }
    }

    public int getRandomByWeight(){
        return extended_values[(int)(Math.random()*(sum - 1))];
    }
}

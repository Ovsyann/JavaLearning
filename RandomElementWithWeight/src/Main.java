public class Main {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weights = {1, 3, 5};

        ElementsWIthWeights elements = new ElementsWIthWeights(values, weights);

        System.out.println(elements.getRandomByWeight());
    }
}
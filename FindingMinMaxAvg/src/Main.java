//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int length = 100;
        double[] randomArray = new double[length];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = Math.random();
        }

        double min = randomArray[0];
        double max = randomArray[0];
        double avg = 0;

        for (double v : randomArray) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }

            avg += v;
        }

        avg = avg/ randomArray.length;

        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("avg = " + avg);
    }
}
public class Print {
    public static void main(String[] args) {
        String[] ph = new String[5];
        String x = "*";
        for (int i = 0; i < 5; i++) {
            if(i == 0)
                ph[i] = "*";
            else ph[i] = x + "*";
            x += "*";
            System.out.println(ph[i]);
        }
    }
}

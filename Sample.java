public class Sample extends Table {

    Sample(int heigth, int width) {
        super(heigth, width);
    }

    public void addPoint(int x, int y) {
        Banana b = new Banana(x, y);
        super.coords.add(b);
    }

}

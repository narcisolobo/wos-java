public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 10);
        Rectangle rect2 = new Rectangle();

        rect2.setTopAndBottomLength(-8);
        rect2.setLeftAndRightLength(-8);

        System.out.println(rect2.getTopAndBottomLength());
        System.out.println(rect2.getLeftAndRightLength());

        rect.leftAndRightLength = 11;
    }
}

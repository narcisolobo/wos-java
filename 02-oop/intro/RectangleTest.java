public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle(7, 5);
        Rectangle square = new Rectangle(5, 5);

        rect2.leftAndRightLength = -10; // bad data

        System.out.println(rect.topAndBottomLength);
        System.out.println(rect.leftAndRightLength);

        System.out.println(rect2.topAndBottomLength);
        System.out.println(rect2.leftAndRightLength);

        System.out.println(rect.calculateArea());
        System.out.println(rect2.calculateArea());

        System.out.println(rect.isSquare());
        System.out.println(rect2.isSquare());

        System.out.println(square.isSquare());
    }
}

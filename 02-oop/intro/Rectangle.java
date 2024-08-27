public class Rectangle {
    public int topAndBottomLength;
    public int leftAndRightLength;

    public Rectangle(int topAndBottomLength, int leftAndRightLength) {
        this.topAndBottomLength = topAndBottomLength;
        this.leftAndRightLength = leftAndRightLength;
    }

    public int calculateArea() {
        return this.topAndBottomLength * this.leftAndRightLength;
    }

    public boolean isSquare() {
        return this.topAndBottomLength == this.leftAndRightLength;
    }
}

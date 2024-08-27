public class Rectangle {
    public int topAndBottomLength;
    public int leftAndRightLength;

    public Rectangle() {
        this.topAndBottomLength = 0;
        this.leftAndRightLength = 0;
    }

    public Rectangle(int topAndBottomLength, int leftAndRightLength) {
        this.topAndBottomLength = topAndBottomLength;
        this.leftAndRightLength = leftAndRightLength;
    }

    public int calculateArea() {
        return this.topAndBottomLength * this.leftAndRightLength;
    }

    public boolean isSquare() {
        if (this.topAndBottomLength == 0 || this.leftAndRightLength == 0) {
            return false;
        }
        return this.topAndBottomLength == this.leftAndRightLength;
    }
}

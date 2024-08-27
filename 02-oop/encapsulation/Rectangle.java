public class Rectangle {
    private int topAndBottomLength;
    private int leftAndRightLength;

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

    public int getTopAndBottomLength() {
        return topAndBottomLength;
    }

    public void setTopAndBottomLength(int topAndBottomLength) {
        if (topAndBottomLength > 0) {
            this.topAndBottomLength = topAndBottomLength;
        }
        this.topAndBottomLength = 5;
    }

    public int getLeftAndRightLength() {
        return leftAndRightLength;
    }

    public void setLeftAndRightLength(int leftAndRightLength) {
        if (leftAndRightLength > 0) {
            this.leftAndRightLength = leftAndRightLength;
        }
        this.leftAndRightLength = 7;
    }
}

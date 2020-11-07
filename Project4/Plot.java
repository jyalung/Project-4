package Project4;
public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        x = 0;
        y = 0;
        width = 1;
        depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot p) {
        this.x = p.getX();
        this.y = p.getY();
        this.width = p.getWidth();
        this.depth = p.getDepth();
    }

    public boolean overlaps(Plot plot) {
        if (this.encompasses(plot)) {
            return true;
        }
        
        if ((this.x > plot.x) && (this.x < (plot.x + plot.width))
        || ((this.x + this.width) > plot.x && (this.x + this.width) < (plot.x + plot.width))) {
            // if not outside on y, return true
            if (!((this.y + this.depth) <= plot.y || this.y >= (plot.y + plot.depth)))
                return true;
        
        } else if (this.y > plot.y && this.y < (plot.y + plot.depth)
            ||   ((this.y + this.depth) > plot.y && (this.y + this.depth) < (plot.y + plot.depth))) {
            if (!(this.x <= (plot.x + plot.width) || (this.x + this.width) >= plot.x))
                return true;
        } else {
            return false;
        }
        return false;
    }

    
    public boolean encompasses(Plot plot) {
        return (this.x <= plot.x && (this.x + this.width) >= (plot.x + plot.width))
            && (this.y <= plot.y && (this.y + this.depth) >= (plot.y + plot.depth));

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    public String toString() {
        return String.format("Upper left: (%d,%d); Width: %d Depth: %d", x, y, width, depth);
    }
}
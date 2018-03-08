public class Terminal {
    private static final String CONTROL_CODE = "\033[";
    private static final String CLEAR = "2J";
    private static final String MOVE = "H";
    private static final String STYLE = "m";

    public void resetStyle() {
        setBgColor(Color.BLACK);
        setColor(Color.WHITE);
    }

    public void clearScreen() {
    }

    public void moveTo(Integer x, Integer y) {
        System.out.print((char)27 + "[" + y + ";" + x + "H");
    }

    public void setColor(Color color) {
        if (color == Color.BLACK) {
            System.out.print((char)27 + "[30m");
        } else if (color == Color.RED) {
            System.out.print((char)27 + "[31m");
        } else if (color == Color.GREEN) {
            System.out.print((char)27 + "[32m");
        } else if (color == Color.YELLOW) {
            System.out.print((char)27 + "[33m");
        } else if (color == Color.BLUE) {
            System.out.print((char)27 + "[34m");
        } else if (color == Color.MAGENTA) {
            System.out.print((char)27 + "[35m");
        } else if (color == Color.CYAN) {
            System.out.print((char)27 + "[36m");
        } else if (color == Color.WHITE) {
            System.out.print((char)27 + "[37m");
        } else {
            System.out.println("ERROR: Color not available");
        }
    }

    public void setBgColor(Color color) {
        if (color == Color.BLACK) {
            System.out.print((char)27 + "[40m");
        } else if (color == Color.RED) {
            System.out.print((char)27 + "[41m");
        } else if (color == Color.GREEN) {
            System.out.print((char)27 + "[42m");
        } else if (color == Color.YELLOW) {
            System.out.print((char)27 + "[43m");
        } else if (color == Color.BLUE) {
            System.out.print((char)27 + "[44m");
        } else if (color == Color.MAGENTA) {
            System.out.print((char)27 + "[45m");
        } else if (color == Color.CYAN) {
            System.out.print((char)27 + "[46m");
        } else if (color == Color.WHITE) {
            System.out.print((char)27 + "[47m");
        } else {
            System.out.println("ERROR: Color not available");
        }
    }

    public void setUnderline() {
    }

    public void moveCursor(Direction direction, Integer amount) {
        if (direction == Direction.UP) {
            System.out.print("\033[" + amount + "A");
        } else if (direction == Direction.DOWN) {
            System.out.print("\033[" + amount + "B");
        } else if (direction == Direction.RIGHT) {
            System.out.print("\033[" + amount + "C");
        } else if (direction == Direction.LEFT) {
            System.out.print("\033[" + amount + "D");
        } else {
            System.out.println("ERROR: Invalid direction");
        }
    }

    public void setChar(char c) {
    }

    private void command(String commandString) {
    }

    public String rgbColor(int r, int g, int b) {
        String colorCode;
        colorCode = "\033[38;2;" + r +";" + g + ";" + b + "m";

        return colorCode;
    }

    public String rgbColorBg(int r, int g, int b) {
        String colorCode;
        colorCode = "\033[48;2;" + r +";" + g + ";" + b + "m";

        return colorCode;
    }
}

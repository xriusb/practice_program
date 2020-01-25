package mars_rover;

public class Rover {

    private Direction directionType;
    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                if (faceNorth()) {
                    setDirection("W");
                } else if (faceSouth()) {
                    setDirection("E");
                } else if (faceWest()) {
                    setDirection("S");
                } else {
                    setDirection("N");
                }
            }

            if (command.equals("r")) {
                if (faceNorth()) {
                    setDirection("E");
                } else if (faceSouth()) {
                    setDirection("W");
                } else if (faceWest()) {
                    setDirection("N");
                } else {
                    setDirection("S");
                }
            }

            if (!(command.equals("l") || command.equals("r"))) {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (faceNorth()) {
                    y += displacement;
                } else if (faceSouth()) {
                    y -= displacement;
                } else if (faceWest()) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    private boolean faceWest() {
        return getDirection().equals("W");
    }

    private boolean faceSouth() {
        return getDirection().equals("S");
    }

    private boolean faceNorth() {
        return getDirection().equals("N");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return directionType == rover.directionType;
    }

    @Override
    public int hashCode() {
        int result = directionType != null ? directionType.hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + directionType +
                ", y=" + y +
                ", x=" + x +
                '}';
    }

    private String getDirection() {
        return direction;
    }

    private void setDirection(String direction) {
        this.direction = direction;
        this.directionType = Direction.create(direction);
    }
}

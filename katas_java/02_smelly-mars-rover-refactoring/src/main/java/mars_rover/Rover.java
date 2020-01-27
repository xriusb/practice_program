package mars_rover;

public class Rover {

    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        setCoordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                if (faceNorth()) {
                    this.direction = Direction.W;
                } else if (faceSouth()) {
                    this.direction = Direction.E;
                } else if (faceWest()) {
                    this.direction = Direction.S;
                } else {
                    this.direction = Direction.N;
                }
            }

            if (command.equals("r")) {
                if (faceNorth()) {
                    this.direction = Direction.E;
                } else if (faceSouth()) {
                    this.direction = Direction.W;
                } else if (faceWest()) {
                    this.direction = Direction.N;
                } else {
                    this.direction = Direction.S;
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
                    setCoordinates(getX(), getY() + displacement);
                } else if (faceSouth()) {
                    setCoordinates(getX(), getY() - displacement);
                } else if (faceWest()) {
                    setCoordinates(getX() - displacement, getY());
                } else {
                    setCoordinates(getX() + displacement, getY());
                }
            }
        }
    }

    private void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    private boolean faceWest() {
        return direction.equals(Direction.W);
    }

    private boolean faceSouth() {
        return direction.equals(Direction.S);
    }

    private boolean faceNorth() {
        return direction.equals(Direction.N);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (direction != rover.direction) return false;
        return coordinates != null ? coordinates.equals(rover.coordinates) : rover.coordinates == null;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", coordinates=" + coordinates +
                '}';
    }

    public int getY() {
        return coordinates.y();
    }

    public int getX() {
        return coordinates.x();
    }
}

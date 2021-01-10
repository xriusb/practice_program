package mars_rover;

public class Rover {

    private static final int DISPLACEMENT = 1;
    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String FORWARD = "f";
    private static final String BACKWARD = "b";

    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            execute(command);
        }
    }

    private void execute(String command) {
        if (LEFT.equals(command)) {
            direction = direction.rotateLeft();
        }
        if (RIGHT.equals(command)) {
            direction = direction.rotateRight();
        }
        if (FORWARD.equals(command)){
            coordinates = direction.move(coordinates, DISPLACEMENT);
        }
        if (BACKWARD.equals(command)){
            coordinates = direction.move(coordinates, -DISPLACEMENT);
        }
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

}

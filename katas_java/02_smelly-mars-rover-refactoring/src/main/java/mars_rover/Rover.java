package mars_rover;

public class Rover {

    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                rotateLeft();
            }
            if (command.equals("r")) {
                rotateRight();
            }
            if (command.equals("f")){
                moveForwards();
            }
            if (command.equals("b")){
                moveBackwards();
            }
        }
    }

    private void rotateLeft() {
        direction = direction.rotateLeft();
    }

    private void rotateRight() {
        direction = direction.rotateRight();
    }

    private void moveForwards(){
        int displacement = 1;
        move(displacement);
    }

    private void moveBackwards(){
        int displacement = -1;
        move(displacement);
    }

    private void move(int displacement) {
        coordinates = direction.move(coordinates, displacement);
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

package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.W;
        }

        @Override
        public Direction rotateRight() {
            return Direction.E;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongY(displacement);
        }
    },
    S {
        @Override
        public Direction rotateLeft() {
            return Direction.E;
        }

        @Override
        public Direction rotateRight() {
            return Direction.W;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongY(-displacement);
        }
    },
    E {
        @Override
        public Direction rotateLeft() {
            return Direction.N;
        }

        @Override
        public Direction rotateRight() {
            return Direction.S;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongX(displacement);
        }
    },
    W {
        @Override
        public Direction rotateLeft() {
            return Direction.S;
        }

        @Override
        public Direction rotateRight() {
            return Direction.N;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongX(-displacement);
        }
    };

    public static Direction create(String directionEncoding) {
        for(Direction d : Direction.values()){
            if(d.name().equals(directionEncoding)){
                return Direction.valueOf(directionEncoding);
            }
        }
        throw new IllegalArgumentException();
    }

    public abstract Direction rotateLeft();

    public abstract Direction rotateRight();

    public abstract Coordinates move(Coordinates coordinates, int displacement);
}

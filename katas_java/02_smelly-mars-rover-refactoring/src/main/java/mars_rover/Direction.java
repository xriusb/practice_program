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
}

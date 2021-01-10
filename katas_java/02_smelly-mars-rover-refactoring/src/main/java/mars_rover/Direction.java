package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.W;
        }
    },
    S {
        @Override
        public Direction rotateLeft() {
            return Direction.E;
        }
    },
    E {
        @Override
        public Direction rotateLeft() {
            return Direction.N;
        }
    },
    W {
        @Override
        public Direction rotateLeft() {
            return Direction.S;
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
}

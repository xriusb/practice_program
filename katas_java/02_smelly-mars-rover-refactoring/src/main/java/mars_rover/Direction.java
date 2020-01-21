package mars_rover;

public enum Direction {
    N, S, E, W;

    public static Direction create(String directionEncoding) {
        for(Direction d : Direction.values()){
            if(d.name().equals(directionEncoding)){
                return Direction.valueOf(directionEncoding);
            }
        }
        throw new IllegalArgumentException();
    }
}

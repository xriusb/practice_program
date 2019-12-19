package mars_rover;

public enum Direction {
    N, S, E, W;

    public static Direction create(String directionEncoding) {
        if ( "S".equals(directionEncoding)) {
            return S;
        }
        if ( "E".equals(directionEncoding)) {
            return E;
        }
        if ( "W".equals(directionEncoding)) {
            return W;
        }
        if ( "N".equals(directionEncoding)) {
            return N;
        }
        throw new IllegalArgumentException();
    }
}

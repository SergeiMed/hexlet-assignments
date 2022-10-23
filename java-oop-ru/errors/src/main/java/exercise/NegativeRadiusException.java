package exercise;

import exercise.exception.CustomException;

// BEGIN
public class NegativeRadiusException extends Exception{

    public static final CustomException NEGATIVE_RADIUS = new CustomException("001", "Negative radius");
}
// END

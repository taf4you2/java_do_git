package module;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Record representing immutable lottery draw result.
 * Contains the game configuration, generated numbers, and timestamp.
 * 
 * @param configuration the game configuration used for this draw
 * @param numbers the list of generated lottery numbers (immutable)
 * @param timestamp the date and time when numbers were generated
 * 
 * @author Wojciech Węglorz
 * @version 3.0
 */
public record DrawResult(
    GameConfiguration configuration,
    List<Integer> numbers,
    LocalDateTime timestamp
) {
    /**
     * Compact constructor ensuring immutability.
     * Creates defensive copy of the numbers list.
     */
    public DrawResult {
        numbers = List.copyOf(numbers); // defensive copy, immutable
    }
    
    /**
     * Creates a DrawResult with current timestamp.
     * Convenience constructor for when timestamp is not provided.
     * 
     * @param configuration the game configuration
     * @param numbers the generated numbers
     */
    public DrawResult(GameConfiguration configuration, List<Integer> numbers) {
        this(configuration, numbers, LocalDateTime.now());
    }
}
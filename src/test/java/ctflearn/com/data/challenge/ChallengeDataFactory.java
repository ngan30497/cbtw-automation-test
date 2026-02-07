package ctflearn.com.data.challenge;

import java.util.UUID;

/**
 * Factory class responsible for generating Challenge test data.
 * Centralized place for valid, negative and edge-case data.
 */
public class ChallengeDataFactory {

    // ===== Static business constants =====
    public static final String DEFAULT_CATEGORY = "Web";
    public static final int DEFAULT_POINTS = 10;

    private static final String DEFAULT_DESCRIPTION =
            "## Automation Test Challenge\n\n" +
                    "This challenge is created automatically for UI automation testing.\n" +
                    "It is used to validate the Create Challenge feature.";

    private static final String DEFAULT_SOLUTION =
            "Follow the instructions in the challenge description to retrieve the correct flag.";

    // ===== Positive data =====

    /**
     * Valid challenge data for happy-path tests.
     */
    public static ChallengeData validChallenge() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String uniqueId = UUID.randomUUID().toString().substring(0, 6);

        return new ChallengeData()
                .setTitle("Auto Challenge " + timestamp)
                .setFlag("CTFlearn{" + uniqueId + "}")
                .setDescription(DEFAULT_DESCRIPTION)
                .setCategory(DEFAULT_CATEGORY)
                .setPoints(DEFAULT_POINTS)
                .setSolution(DEFAULT_SOLUTION);
    }

    // ===== Negative data =====

    /**
     * Challenge data with missing title.
     */
    public static ChallengeData challengeWithoutTitle() {
        return validChallenge()
                .setTitle("");
    }

    /**
     * Challenge data with missing flag.
     */
    public static ChallengeData challengeWithoutFlag() {
        return validChallenge()
                .setFlag("");
    }

    /**
     * Challenge data with missing solution.
     */
    public static ChallengeData challengeWithoutSolution() {
        return validChallenge()
                .setSolution("");
    }
}


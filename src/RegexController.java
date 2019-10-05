import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Manages regular expressions
 */
class RegexController {

    /**
     * The text to run a regular expression against
     */
    private String text;

    /**
     * The regex to run against the text
     */
    private String regex;

    /**
     * Creates a new controller to manage regex expressions
     * @param text The text to run against the regular expression
     * @param regex The regex to run against the text
     */
    RegexController(String text, String regex) {
        this.text = text;
        this.regex = regex;
    }

    /**
     * Replaces all occurrences of a regex pattern is a string with another string
     * @param replace The string to replace the occurrences with
     * @return The new modified string
     */
    String replaceAll(String replace) {
        return this.text.replaceAll(this.regex, replace);
    }

    /**
     * Gets the first matched occurrence of a regular expression in a string
     * @return The first matched occurrence
     */
    String getFirstMatch() {
        String[] matches = getAllMatches();

        if (matches != null && matches.length != 0) {
            return matches[0];
        }

        return null;
    }

    /**
     * Gets all matched occurrences of a regular expression in a string
     * @return All of the matched occurrences in the string
     */
    String[] getAllMatches() {
        return Pattern.compile(this.regex)
                .matcher(this.text)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }

}

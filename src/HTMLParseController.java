/**
 * Manages the parsing of an HTML structure
 */
class HTMLParseController {

    /**
     * The HTML to parse
     */
    private String html;

    /**
     * Creates a new HTML parser
     * @param html The HTML to be parsed
     */
    HTMLParseController(String html) {
        this.html = html;
    }

    /**
     * Gets the string contents of the child from the first element found in the HTML
     * @param tag The HTML tag to search for
     * @param attribute The tag attribute to search for
     * @param value The value of the attribute to search for
     * @return The string contents of the HTML element
     */
    String getChildFromFirstElement(String tag, String attribute, String value) {
        String element = getFirstElement(tag, attribute, value);

        String stripTags = "<[^>]*>";
        RegexController regexController = new RegexController(element, stripTags);
        String tagContents = regexController.replaceAll("");

        String onlyLetters = "[A-z| ]*";
        regexController = new RegexController(tagContents, onlyLetters);
        return regexController.getFirstMatch();
    }

    /**
     * Gets the first matching element in the HTML
     * @param tag The HTML tag to search for
     * @param attribute The tag attribute to search for
     * @param value The value of the attribute to search for
     * @return The matched HTML element
     */
    String getFirstElement(String tag, String attribute, String value) {
        String regex = "<\\s*" + tag + "[^>]*\\s*" + attribute + "=\"" + value + "\"\\s*>(.*?)<\\s*/\\s*" + tag + ">";
        RegexController regexController = new RegexController(this.html, regex);
        return regexController.getFirstMatch();
    }

}

/**
 * Manages the parsing of an HTML structure
 */
class HTML {

    /**
     * The HTML to parse
     */
    private String text;

    /**
     * Creates a new HTML parser
     * @param text The HTML to be parsed
     */
    HTML(String text) {
        this.text = text;
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

        if (element == null) {
            return null;
        }

        String stripTags = "<[^>]*>";
        RegexController regexController = new RegexController(element, stripTags);
        String tagContents = regexController.replaceAll("");

        String onlyLettersAndNumbers = "[A-z0-9+@_.-| ]*";
        regexController = new RegexController(tagContents, onlyLettersAndNumbers);
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
        String regex = "<\\s*" + tag + "[^>]*\\s*" + attribute + "=[\"\']" + value + "[\"\']\\s*>(.*?)<\\s*/\\s*" + tag + ">";
        RegexController regexController = new RegexController(this.text, regex);
        return regexController.getFirstMatch();
    }

}

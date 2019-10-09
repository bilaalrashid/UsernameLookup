import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Manages HTTP network connections
 */
class NetworkController {

    /**
     * Fetches the HTML from a URL
     * @param url The URL to fetch
     * @return The HTML from the page
     */
    static HTML fetchHTML(URL url) {
        String contents = fetchURLContents(url);

        if (contents != null) {
            return new HTML(contents);
        }

        return null;
    }

    /**
     * Fetches the contents from a URL
     * @param url The URL to fetch
     * @return The contents of the page
     */
    static String fetchURLContents(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder response = new StringBuilder();

                String input = bufferedReader.readLine();

                while (input != null) {
                    response.append(input);
                    input = bufferedReader.readLine();
                }

                bufferedReader.close();

                return response.toString();
            }

            return null;
        } catch(Exception e) {
            return null;
        }
    }

}

package lab8;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/primes", (req, res) -> resultsPage(req, res));

    }



    private static String inputDataPage(Request req, Response res) {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>AUTO-SCALABILITY AREP 2020-2</h2>"
                + "<p> Insert two numbers separated by comma, the first one will represent <br/> " +
                "   the lower limit and the second one the upper limit. You'll get the primes between this range</p>"
                + "<form action=\"/primes\">"
                + "  Range:<br>"
                + "  <input type=\"text\" name=\"data\" >"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
    }

    private static String resultsPage(Request req, Response res) {
        String[] data = req.queryParams("data").split(",");
        PrimeFinder primeFinder = new PrimeFinder(Long.parseLong(data[0]),Long.parseLong(data[1]));
        ArrayList<Long> primes = primeFinder.find();
        return "<!DOCTYPE html>"
                + " <html>" +
                "<body>" +
                "<h2>Primes found: " + primes.toString() + "</h2>" +
                "<a href=\"/inputdata\" class=\"button\">Go back </a>"  +
                "</body>" +
                "</html>";
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e on localhost)
    }
}

package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter print = response.getWriter();
        List<String> companies = getCompanies();
        String param = request.getParameter("search");
        List<String> output = new ArrayList<>();
        if (request.getQueryString() == null) {
            for (String company : companies) {
                print.println(company);
            }
        } else {
            companies.stream()
                .filter(x -> x.contains(param))
                .forEach(y -> output.add(y));
            if (output.isEmpty()) {
                print.println("Companies not found");
            } else {
                for (String out : output) {
                    print.println(out);
                }
            }
        }
        // END
    }
}

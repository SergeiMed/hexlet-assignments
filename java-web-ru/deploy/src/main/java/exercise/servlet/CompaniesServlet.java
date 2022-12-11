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
        PrintWriter out = response.getWriter();
        List<String> companies = getCompanies();
        String searchString = request.getParameter("search");
        List<String> searchCompanies = new ArrayList<>();
        if (request.getQueryString() == null) {
            for (String company : companies) {
                out.println(company);
            }
        } else {
            companies.stream()
                .filter(company -> company.contains(searchString))
                .forEach(searchCompanies::add);
            if (searchCompanies.isEmpty()) {
                out.println("Companies not found");
            } else {
                for (String searchCompany : searchCompanies) {
                    out.println(searchCompany);
                }
            }
        }
        // END
    }
}

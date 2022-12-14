package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> users;
        users = mapper.readValue(new File("src/main/resources/users.json"), List.class);
        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        StringBuilder builder = new StringBuilder();
        List<Map<String, String>> users = getUsers();
        builder.append("""
                <!DOCTYPE html>
                <html lang=\\"ru\\">
                    <head>
                        <meta charset=\\"UTF-8\\">
                        <title>Test application | Users</title>
                    </head>
                        <body>
                            <table>
                """);
        for (Map<String, String> user : users) {
            String fullName = user.get("firstName") + " " + user.get("lastName");
            String id = user.get("id");
            builder.append("""
                    <tr>
                        <td>%s</td>
                        <td><a href="/users/%s">%s</a></td>
                    <tr>
                    """.formatted(id, id, fullName));
        }
        builder.append("""
                            </table>
                        </body>
                    </html>
                    """);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(builder);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        List<Map<String, String>> users = getUsers();
        for (Map<String, String> map : users) {
            if (map.get("id").equals(id)) {
                String firstName = map.get("firstName");
                String lastName = map. get("lastName");
                String email = map.get("email");
                        sb.append("""
                    <!DOCTYPE html>
                    <html lang=\\"ru\\">
                        <head>
                            <meta charset=\\"UTF-8\\">
                            <title>Test application | User</title>
                        </head>
                        <body>
                            <table>
                                <tr><td>Last name: %s</td></tr>
                                <tr><td>First name: %s</td></tr>
                                <tr><td>ID: %s</td></tr>
                                <tr><td>Email: %s</td></tr>    
                            </table>
                        </body>
                    </html>
                    """.formatted(firstName, lastName, id, email));
                response.setContentType("text/html;charset=UTF-8");
                out.println(sb);
                return;
            }
        }
        response.sendError(404, "Not found");
        // END
    }
}

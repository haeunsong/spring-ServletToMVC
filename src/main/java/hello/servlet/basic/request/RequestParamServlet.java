package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
        * <p>
* 2. 동일한 파라미터 전송 가능
* http://localhost:8080/request-param?username=hello&username=kim&age=20
*
* 3. post form 형식으로 전송해보기
* http://localhost:8080/basic/hello-form.html
*
* content-type 은 HTTP 메시지 바디의 데이터 형식을 지정한다.
* GET 방식은 content-type 이 없다.
* POST 방식은 content-type 을 꼭 지정해야한다. 이렇게 폼으로 데이터를 전송하는 형식을
* application/x-www-from-urlencoded 라고 한다.
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 모든 요청 파라미터를 꺼낸다.
        // 전체 파라미터 조회
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end"); System.out.println();
        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username"); System.out.println("request.getParameter(username) = " + username);
        String age = req.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        // `username=hello&username=kim`
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }
        resp.getWriter().write("ok");
    }
}

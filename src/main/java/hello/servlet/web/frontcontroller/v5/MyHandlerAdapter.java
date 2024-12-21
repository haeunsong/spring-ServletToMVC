package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {
    // 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
    boolean supports(Object handler);

    // 이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만, 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출된다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler);

}

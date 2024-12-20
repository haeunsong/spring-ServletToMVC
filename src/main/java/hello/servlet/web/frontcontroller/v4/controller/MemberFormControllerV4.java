package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

// V4 에서는 ModelView 가 없다.
// model 객체는 파라미터로 전달되기 때문에 그냥 사용하면 되고, 결과고 뷰의 이름만 반환해주면 된다.
public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}

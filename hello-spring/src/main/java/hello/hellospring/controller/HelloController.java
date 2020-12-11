package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data","hello!!~!@~");
		return "hello";
	}// 웹 어플리케이션에서 /hello  들어오면 이 메서드를 호출한다.

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {

		model.addAttribute("name" , name);
		return "hello-template";
	}//이번엔 외부에서  파라미터를 받을거임

	@GetMapping("hello-string")
	@ResponseBody //http에서 header 와 body 중 body에 return "hello" + name;를 직접 넣어주겠다.
	public String helloString(@RequestParam("name") String name, Model model) {

		return "hello " + name;
	}

	@GetMapping("hello-api") //json 방식 , 요청 http://localhost:8080/hello-api?name=abc
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	static class Hello {
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	} //{"name":"abc"} 
}

package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class ControllerTest {

    @GetMapping("sample/fibonacci/{n}")
    public int fibonacci(@PathVariable("n") int n) {
        return Lesson2.fibonacci(n);
    }

    @GetMapping("sample/min") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int min(@RequestParam("aUrlis") int a, @RequestParam("bUrlis") int b) {
        return Lesson1.min(a, b);
    }

    @GetMapping("sample/max/{a}/{b}")
    public int max(@PathVariable("a") int a, @PathVariable("b") int b) {
        return Lesson1.max(a, b);
    }

    @GetMapping("sample/abs/{n}")
    public int abs(@PathVariable("n") int n) {
        return Lesson1.abs(n);
    }

    @GetMapping("sample/isEven/{a}")
    public boolean isEven(@PathVariable("a") int a) {
        return Lesson1.isEven(a);
    }

    @GetMapping("sample/min3") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int min3(@RequestParam("aUrlis") int a,
                    @RequestParam("bUrlis") int b,
                    @RequestParam("cUrlis") int c) {
        return Lesson1.min3(a, b, c);
    }

    @GetMapping("sample/max3") //Níteks localhost:8080/sample/min?aUrlis=1&bUrlis=5cUrlis=9
    public int max3(@RequestParam("aUrlis") int a,
                    @RequestParam("bUrlis") int b,
                    @RequestParam("cUrlis") int c) {
        return Lesson1.max3(a, b, c);
    }

    @GetMapping("sample/reverseArray/{array}")
    public int[] reverseArray(@PathVariable("array") int[] a) {
        return Lesson2.reverseArray(a);
    }

    @GetMapping("sample/evenNumbers/{array}")
    public int[] evenNumbers(@PathVariable("array") int a) {
        return Lesson2.evenNumbers(a);
    }

    @GetMapping("sample/minArray/{array}")
    public int minArray(@PathVariable("array") int[] n) {
        return Lesson2.min(n);
    }

    @GetMapping("sample/sumArray/{array}")
    public int sumArray(@PathVariable("array") int[] n) {
        return Lesson2.sum(n);
    }

    @GetMapping("sample/sequence/") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int seq3(@RequestParam("aUrlis") int a,
                    @RequestParam("bUrlis") int b) {
        return Lesson2.sequence3n(a, b);
    }
    @GetMapping("sample/nextSeq/{a}")
    public int nextSeq(@PathVariable("a") int a) {
        return Lesson2.nextElement(a);
    }


}



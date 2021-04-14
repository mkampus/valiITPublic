package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController


public class ControllerTest {

    public List<Employee> employeeList = new ArrayList<>();


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

    @GetMapping("sample/getSeqLength/") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int getSeqLength(@RequestParam("aUrlis") int a) {
        return Lesson2.getSeqLength(a);
    }

    @GetMapping("sample/genArray/{a}")
    public int[] genArray(@PathVariable("a") int a) {
        return Lesson2b.generateArray(a);
    }

    @GetMapping("sample/decArray/{a}")
    public int[] decArray(@PathVariable("a") int a) {
        return Lesson2b.decreasingArray(a);
    }

    @GetMapping("sample/yl3") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int[] yl3(@RequestParam("aUrlis") int a) {
        return Lesson2b.yl3(a);
    }

    @GetMapping("sample/seq3n/{a}/{b}")
    public int sequence3n(@PathVariable("a") int a, @PathVariable("b") int b) {
        return Lesson2c.sequence3n(a, b);
    }

    @GetMapping("sample/nextElement")
    public int nextElement(@RequestParam("a") int a) {
        return Lesson2c.nextElement(a);
    }

    @GetMapping("sample/factorial") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int factorial(@RequestParam("aUrlis") int a) {
        return Lesson3.factorial(a);
    }

    @GetMapping("sample/reverseString/{lause}")
    public String reverseString(@PathVariable("lause") String a) {
        return Lesson3.reverseString(a);
    }

    @GetMapping("sample/isPrime/{a}")
    public boolean isPrime(@PathVariable("a") int a) {
        return Lesson3.isPrime(a);
    }

    @GetMapping("sample/sortArray/{a}")
    public int[] sortArray(@PathVariable("a") int[] a) {
        return Lesson3.sort(a);
    }

    @GetMapping("sample/evenFibonacci") //localhost:8080/sample/min?aUrlis=1&bUrlis=5
    public int evenFibonacci(@RequestParam("aUrlis") int a) {
        return Lesson3.evenFibonacci(a);
    }

    @GetMapping("sample/StringToMorse/{lause}")
    public String StringToMorse(@PathVariable("lause") String a) {
        return Lesson3.morseCode(a);
    }

    @GetMapping("sample/game/{a}")
    public String game(@PathVariable("a") int a) {
        return Lesson3Hard.game(a);
    }

    //GET ALL
    @GetMapping("sample/employees")
    public List<Employee> rosterGet() {
        return employeeList;
    }

    //GET SPECIFIC
    @GetMapping("sample/employees/{a}")
    public Employee rosterGet(@PathVariable("a") int a) {
        Employee tagastus = employeeList.get(a);
        return tagastus;
    }

    //POST TO LIST
    @PostMapping("sample/employees")
    public void rosterPost(@RequestBody Employee employeeData) {
        employeeList.add(employeeData);
    }

    /// PUT TO LIST
    @PutMapping("sample/employees/{a}")
    public void rosterPut(@RequestBody Employee employeeData, @PathVariable("a") int a) {
        employeeList.set(a, employeeData);
    }

    ///Delete from list
    @DeleteMapping("sample/employees/{a}")
    public void rosterDelete(@PathVariable("a") int a) {
        employeeList.remove(a);
    }

}
// Get; localhost8080/employee
//0 sisendit tagastab k]ik t;;tajad

//GET: employee/{id} sisendiks path variable (id = index)
//tagastab yhe t;;taja vastaval indeksil
// POST employee
//sisendiks request body
//v'ljund puudub (salvestab listi info)
//PUT: employee/{id}
//sisendiks request body ja path variable (id = index)
// V'ljund puudub (kirjutaab [le vastaval indekil t;;taja request body sisuga
//DELETE /employee/{id}
//Sisendiks ainult pathh variable (id = index)
//V'ljund puududb (kustutab listsist vastaval indeksil elemendi)

//        Employee employee = new Employee();
//        employee.setName("Mart");
//        employee.setAddress("VabaduseV'ljak");
//        employee.setLivesAlone("Yes");
//        employee.setName("Ivara");
//        employee.setAddress("Vanalinn");
//        employee.setLivesAlone("no");
//        Employee employee = new Employee();
//        employee.setName("Mart");
//        employee.setAddress("VabaduseV'ljak");
//        employee.setLivesAlone("Yes");
//        employee.setName("Ivara");
//        employee.setAddress("Vanalinn");
//        employee.setLivesAlone("no");
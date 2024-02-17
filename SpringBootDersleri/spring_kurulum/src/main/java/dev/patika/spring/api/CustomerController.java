package dev.patika.spring.api;


import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dto.CustomerResponse;
import dev.patika.spring.dto.CustomerSaveRequest;
import dev.patika.spring.dto.CustomerUpdateRequest;
import dev.patika.spring.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    @Autowired
//    private CustomerDtoConverter customerDtoConverter;   // dto ile entity arası transfer işlemi tanımladık

    @Autowired
    private ModelMapper modelMapper;                    // dto ya gerek duymadan kullanılan eklenti


//    @GetMapping("/customers")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CustomerDto> findAll() {
//        List<Customer> customerList = this.customerService.findAll();
//        List<CustomerDto> customerDtoList = customerList.stream().map(               //converter dto
//                customer -> this.customerDtoConverter.converDto(customer)
//        ).collect(Collectors.toList());
//
//        return customerDtoList;
    //   }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {


        List<CustomerResponse> customerDtoList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponse.class)
        ).collect(Collectors.toList());

        return customerDtoList;
    }


    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest) {       // save işlemi için request oluştu
        Customer newCustomer = this.modelMapper.map(
                customerSaveRequest, Customer.class
        );
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest) {
        Customer updateCustomer = this.customerService.getById(customerUpdateRequest.getId());
        updateCustomer.setName(customerUpdateRequest.getName());
        updateCustomer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(updateCustomer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
    }

//    @GetMapping("/customer/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void getById(@PathVariable("id")int id){
//        this.customerService.delete(id);
//    }

//    @GetMapping("/customer/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public CustomerDto getById(@PathVariable("id") int id) {
//        Customer customer = this.customerService.delete(id);
//        CustomerDto customerDto = this.modelMapper.converDto(customer);
//        return customerDto;
//    }


    // --------------------------  IoC Uygulaması

    // Constructor //

//    private final ICustomerService customerService;
//
//    @Autowired
//    public CustomerController(ICustomerService customerService) {
//        this.customerService = customerService;
//    }

    // Setter //
//
//    private ICustomerService customerService;
//
//    @Autowired
//    public void setCustomerService(ICustomerService customerService) {
//        this.customerService = customerService;
//    }

    //Field //

    //  private ICustomerService customerService;


    //-------------------------------------

//    private final ICustomerService customerService;
//
//    public CustomerController(ICustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/{id}")
//    public Customer getById(@PathVariable("id") int id){
//        return this.customerService.getById(id);
//    }

    //----------------------------


//    @GetMapping("/{id}")
//    public Customer findById(@PathVariable("id") int id) {
//        return this.customerRepo.findById(id).orElseThrow();
//    }
//
//    @GetMapping("/save")
//    public Customer save(@RequestBody Customer customer) {
//        return this.customerRepo.save(customer);
//    }
//
//    @GetMapping("/find-all")
//    public List<Customer> findAll(){
//        return this.customerRepo.findAll();
//    }
//
//    @GetMapping("/mail/{mail}")
//    public Customer findByMail(@PathVariable("mail")  String mail){
//        return this.customerRepo.findByMail(mail);
//    }
//
//    @GetMapping("/find/{mail}/{gender}")
//    public Customer findByMailAndGender(@PathVariable("mail")  String mail , @PathVariable("gender") Customer.GENDER gender ){
//        return this.customerRepo.findByMailAndGender(mail,gender);  // mail ve gendera gore arama yapar.
//    }
//
//    @GetMapping("/find/{mail}/{gender}")
//    public List<Customer> findByMailOrGender(@PathVariable("mail")  String mail , @PathVariable("gender") Customer.GENDER gender ){
//        return this.customerRepo.findByMailOrGender(mail,gender);  // mail yada gendera gore arama yapar.
//    }


}
